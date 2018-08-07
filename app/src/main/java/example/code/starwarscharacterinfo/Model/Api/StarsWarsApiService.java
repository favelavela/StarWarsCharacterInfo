package example.code.starwarscharacterinfo.Model.Api;


import example.code.starwarscharacterinfo.Model.StarWarsCharacters;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StarsWarsApiService {

    @GET("people/")
    Call<StarWarsCharacters> getStarWarsCharacters();

}
