package com.grntea.ygocard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grntea.ygocard.Adapter.cardAdapter;
import com.grntea.ygocard.Models.Deck;
import com.grntea.ygocard.Models.ModelView;
import com.grntea.ygocard.Models.card;
import com.grntea.ygocard.Models.data;
import com.grntea.ygocard.Retrofit.ApiClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    public ModelView modelView;
    public RecyclerView RecyclerViewCard;
    private cardAdapter cardAdapter;
    public Deck deck;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewCard = findViewById(R.id.recycler);
        search = findViewById(R.id.searchV);
        cardAdapter = new cardAdapter(getApplicationContext());
        RecyclerViewCard.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewCard.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        Swipe();
        Search();
        modelView = new ViewModelProvider(this).get(ModelView.class);
        modelView.getData();
        modelView.getCardMutableLiveData().observe(this, cards -> cardAdapter.setList(cards));

        findViewById(R.id.DeckButton).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DeckActivity.class)));
    }

    private void Search() {
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ApiClient.ApiClient().getQuery(newText)
                        .enqueue(new Callback<data>() {
                            @Override
                            public void onResponse(Call<data> call, Response<data> response) {
                                if (response.isSuccessful()){
                                    List<card> results = response.body().getCards();
                                    cardAdapter.setData(results);
                                }

                            }

                            @Override
                            public void onFailure(Call<data> call, Throwable t) {

                            }
                        });
                Log.e("Main", " data search " + newText);
                return true;
            }
        });
    }

    private void Swipe() {
        ItemTouchHelper.SimpleCallback touchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                card c = cardAdapter.getCardList(viewHolder.getAdapterPosition());
                deck = new Deck(c);
                modelView.SaveData(deck);
                cardAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Added To Your Deck", Toast.LENGTH_SHORT).show();
            }
        };
        new ItemTouchHelper(touchHelper).attachToRecyclerView(RecyclerViewCard);
    }

}