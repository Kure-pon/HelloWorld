package com.grntea.ygocard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.grntea.ygocard.Models.Deck;
import com.grntea.ygocard.Models.cardImage;
import com.grntea.ygocard.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.DeckAdapterHolder> {

    private List<Deck> deckList = new ArrayList<>();
    private final Context context;

    public DeckAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DeckAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DeckAdapterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DeckAdapterHolder holder, int position) {
        holder.title.setText(deckList.get(position).getCard().getName());
        holder.type.setText(deckList.get(position).getCard().getType());
        holder.desc.setText(deckList.get(position).getCard().getDesc());
        cardImage card = deckList.get(position).getCard().getCardImageList().get(0);
        Glide.with(context).load(card.getImage_url_small()).placeholder(R.drawable.card_back).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return deckList.size();
    }

    public void setList(List<Deck> deckList) {
        this.deckList = deckList;
        notifyDataSetChanged();
    }

    public Deck getFavList(int position) {
        return deckList.get(position);
    }

    public class DeckAdapterHolder extends RecyclerView.ViewHolder {

        TextView title, desc, type;
        ImageView img;

        public DeckAdapterHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_headline);
            type = itemView.findViewById(R.id.card_type);
            desc = itemView.findViewById(R.id.text_subhead);
            img = itemView.findViewById(R.id.imageList);
        }
    }
}