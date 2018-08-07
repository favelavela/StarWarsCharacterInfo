package example.code.starwarscharacterinfo.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import example.code.starwarscharacterinfo.Model.Api.StarWarsApiClient;
import example.code.starwarscharacterinfo.Model.Api.StarsWarsApiService;
import example.code.starwarscharacterinfo.Model.StarWarsCharacters;
import example.code.starwarscharacterinfo.R;
import example.code.starwarscharacterinfo.Utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private Call<StarWarsCharacters> call;
    private StarWarsCharacters charactersArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = findViewById(R.id.characters_list);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        StarsWarsApiService starsWarsApiService = StarWarsApiClient.getClient().create(StarsWarsApiService.class);
        call = starsWarsApiService.getStarWarsCharacters();


        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                getCharactersInformation();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent = new Intent(MainActivity.this, CharacterDescriptionActivity.class);
                myIntent.putExtra(Utils.NAME, charactersArrayList.getResults().get(position).getName());
                myIntent.putExtra(Utils.WEIGHT, charactersArrayList.getResults().get(position).getHeight());
                myIntent.putExtra(Utils.HEIGHT, charactersArrayList.getResults().get(position).getMass());
                myIntent.putExtra(Utils.DATE, charactersArrayList.getResults().get(position).getCreated());
                MainActivity.this.startActivity(myIntent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

    }

    private void setCharacterNames(StarWarsCharacters charactersArrayList) {
        this.charactersArrayList = charactersArrayList;
        RecyclerView.Adapter adapter = new CharacterListAdapter(charactersArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void getCharactersInformation() {
        swipeRefreshLayout.setRefreshing(true);
        call.clone().enqueue(new Callback<StarWarsCharacters>() {

            @Override
            public void onResponse(@NonNull Call<StarWarsCharacters> call, @NonNull Response<StarWarsCharacters> response) {
                setCharacterNames(response.body());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<StarWarsCharacters> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong. Please swipe down to try again", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }

        });
    }


    @Override
    public void onRefresh() {
        getCharactersInformation();
    }
}
