package com.grntea.ygocard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity{

    public ModelView modelView;
    public RecyclerView RecyclerViewCard;
    private cardAdapter cardAdapter;
    public Deck deck;
    private SearchView search;
    String a;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerViewCard = findViewById(R.id.recycler);
        intent = getIntent();
        search = findViewById(R.id.searchV);
        cardAdapter = new cardAdapter(getApplicationContext());
        RecyclerViewCard.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewCard.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        Swipe();
        Search();
        modelView = new ViewModelProvider(this).get(ModelView.class);
        findViewById(R.id.DeckButton).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DeckActivity.class)));

        if(getIntent().getExtras() != null){
            a = intent.getStringExtra("key");
            start();
        }else{
            a = "0";
            Toast.makeText(getApplicationContext(), "Loading Card List",
                    Toast.LENGTH_SHORT).show();
            modelView.getData();
            modelView.getCardMutableLiveData().observe(this, cards -> cardAdapter.setList(cards));
        }
    }

    private void start() {
        a = intent.getStringExtra("key");
        switch (a){
            case "1" :
                ApiClient.ApiClient().gettype(intent.getStringExtra("type"))
                        .enqueue(new Callback<data>() {
                            @Override
                            public void onResponse(Call<data> call, Response<data> response) {
                                if (response.isSuccessful()){
                                    List<card> results = response.body().getCards();
                                    cardAdapter.setList(results);
                                }
                            }
                            @Override
                            public void onFailure(Call<data> call, Throwable t) {
                            }
                        });
                break;
            case "2" :
                ApiClient.ApiClient().getracespell(intent.getStringExtra("type"),intent.getStringExtra("race"))
                        .enqueue(new Callback<data>() {
                            @Override
                            public void onResponse(Call<data> call, Response<data> response) {
                                if (response.isSuccessful()){
                                    List<card> results = response.body().getCards();
                                    cardAdapter.setList(results);
                                }
                            }
                            @Override
                            public void onFailure(Call<data> call, Throwable t) {
                            }
                        });
                break;
            case "3" :
                ApiClient.ApiClient().getrace(intent.getStringExtra("race"))
                        .enqueue(new Callback<data>() {
                            @Override
                            public void onResponse(Call<data> call, Response<data> response) {
                                if (response.isSuccessful()){
                                    List<card> results = response.body().getCards();
                                    cardAdapter.setList(results);
                                }
                            }
                            @Override
                            public void onFailure(Call<data> call, Throwable t) {

                            }
                        });
                break;
            case "4" :
                ApiClient.ApiClient().getatr(intent.getStringExtra("atr"))
                        .enqueue(new Callback<data>() {
                            @Override
                            public void onResponse(Call<data> call, Response<data> response) {
                                if (response.isSuccessful()){
                                    List<card> results = response.body().getCards();
                                    cardAdapter.setList(results);
                                }
                            }
                            @Override
                            public void onFailure(Call<data> call, Throwable t) {
                            }
                        });
                break;
        }
    }

    private void Search() {
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                switch (a){
                    case "0":
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
                        break;
                    case "1" :
                        ApiClient.ApiClient().quetype(newText,intent.getStringExtra("type"))
                                .enqueue(new Callback<data>() {
                                    @Override
                                    public void onResponse(Call<data> call, Response<data> response) {
                                        if (response.isSuccessful()){
                                            List<card> results = response.body().getCards();
                                            cardAdapter.setList(results);
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<data> call, Throwable t) {
                                    }
                                });
                        break;
                    case "2" :
                        ApiClient.ApiClient().queracespell(newText,intent.getStringExtra("type"),intent.getStringExtra("race"))
                                .enqueue(new Callback<data>() {
                                    @Override
                                    public void onResponse(Call<data> call, Response<data> response) {
                                        if (response.isSuccessful()){
                                            List<card> results = response.body().getCards();
                                            cardAdapter.setList(results);
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<data> call, Throwable t) {
                                    }
                                });
                        break;
                    case "3" :
                        ApiClient.ApiClient().querace(newText,intent.getStringExtra("race"))
                                .enqueue(new Callback<data>() {
                                    @Override
                                    public void onResponse(Call<data> call, Response<data> response) {
                                        if (response.isSuccessful()){
                                            List<card> results = response.body().getCards();
                                            cardAdapter.setList(results);
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<data> call, Throwable t) {

                                    }
                                });
                        break;
                    case "4" :
                        ApiClient.ApiClient().queatr(newText,intent.getStringExtra("atr"))
                                .enqueue(new Callback<data>() {
                                    @Override
                                    public void onResponse(Call<data> call, Response<data> response) {
                                        if (response.isSuccessful()){
                                            List<card> results = response.body().getCards();
                                            cardAdapter.setList(results);
                                        }
                                    }
                                    @Override
                                    public void onFailure(Call<data> call, Throwable t) {
                                    }
                                });
                        break;
                }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(getApplicationContext(), "About",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    public void refresh(View view) {
        Toast.makeText(getApplicationContext(), "Refreshing Card List",
                Toast.LENGTH_SHORT).show();
        a = "0";
        modelView.getData();
        modelView.getCardMutableLiveData().observe(this, cards -> cardAdapter.setList(cards));

    }
}