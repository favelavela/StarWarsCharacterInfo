package example.code.starwarscharacterinfo.Model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("mass")
    @Expose
    private String mass;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("skin_color")
    @Expose
    private String skinColor;
    @SerializedName("eye_color")
    @Expose
    private String eyeColor;
    @SerializedName("birth_year")
    @Expose
    private String birthYear;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("homeworld")
    @Expose
    private String homeworld;
    @SerializedName("films")
    @Expose
    private List<String> films = null;
    @SerializedName("species")
    @Expose
    private List<String> species = null;
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = null;
    @SerializedName("starships")
    @Expose
    private List<String> starships = null;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
            ;

    Result(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.mass = ((String) in.readValue((String.class.getClassLoader())));
        this.hairColor = ((String) in.readValue((String.class.getClassLoader())));
        this.skinColor = ((String) in.readValue((String.class.getClassLoader())));
        this.eyeColor = ((String) in.readValue((String.class.getClassLoader())));
        this.birthYear = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.homeworld = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.films, (java.lang.String.class.getClassLoader()));
        in.readList(this.species, (java.lang.String.class.getClassLoader()));
        in.readList(this.vehicles, (java.lang.String.class.getClassLoader()));
        in.readList(this.starships, (java.lang.String.class.getClassLoader()));
        this.created = ((String) in.readValue((String.class.getClassLoader())));
        this.edited = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Result() {
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getCreated() {
        return created;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(height);
        dest.writeValue(mass);
        dest.writeValue(hairColor);
        dest.writeValue(skinColor);
        dest.writeValue(eyeColor);
        dest.writeValue(birthYear);
        dest.writeValue(gender);
        dest.writeValue(homeworld);
        dest.writeList(films);
        dest.writeList(species);
        dest.writeList(vehicles);
        dest.writeList(starships);
        dest.writeValue(created);
        dest.writeValue(edited);
        dest.writeValue(url);
    }

    public int describeContents() {
        return 0;
    }

}