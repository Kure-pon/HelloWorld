package com.grntea.ygocard.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.grntea.ygocard.DetailActivity;
import com.grntea.ygocard.Models.card;
import com.grntea.ygocard.Models.cardImage;
import com.grntea.ygocard.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.cardAdapterHolder> implements Filterable {

    private List<card> cardList = new ArrayList<>();
    private List<card> itemsModelListFiltered;
    private final Context context;

    public cardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public cardAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapterHolder holder, int position) {
        try {
            cardImage card = itemsModelListFiltered.get(position).getCardImageList().get(0);
            holder.screen.setOnClickListener(v ->
                    context.getApplicationContext()
                            .startActivity(new Intent(context.getApplicationContext(), DetailActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    .putExtra("card",itemsModelListFiltered.get(position))
                                    .putExtra("image",card.getImage_url())

                            ));
            holder.title.setText(itemsModelListFiltered.get(position).getName());
            holder.type.setText(itemsModelListFiltered.get(position).getType());
            holder.desc.setText(itemsModelListFiltered.get(position).getDesc());
            Glide.with(context).load(card.getImage_url_small()).placeholder(R.drawable.card_back).into(holder.img);
        } catch (Exception e) {
            //Toast.makeText(context.getApplicationContext(), "No Card With This Name!!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setList(List<card> cardList) {
        this.cardList = cardList;
        this.itemsModelListFiltered = cardList;
        notifyDataSetChanged();
    }

    public card getCardList(int position) {
        return cardList.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = cardList.size();
                    filterResults.values = cardList;
                } else {
                    List<card> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (card itemsModel : cardList) {
                        if (itemsModel.getName().toLowerCase().contains(searchStr)
                                || itemsModel.getType().toLowerCase().contains(searchStr)) {
                            resultsModel.add(itemsModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemsModelListFiltered = (List<card>) results.values;
                notifyDataSetChanged();
            }
        };

    }

    public class cardAdapterHolder extends RecyclerView.ViewHolder {

        TextView title, type, desc;
        ImageView img;
        LinearLayout screen;

        public cardAdapterHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_headline);
            desc = itemView.findViewById(R.id.text_subhead);
            type = itemView.findViewById(R.id.card_type);
            img = itemView.findViewById(R.id.imageList);
            screen = itemView.findViewById(R.id.screen);
        }
    }
}