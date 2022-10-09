import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Character {
    public Integer id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Object origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public String created;

    @JsonCreator
    public Character(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("status") String status,
            @JsonProperty("species") String species,
            @JsonProperty("type") String type,
            @JsonProperty("gender") String gender,
            @JsonProperty("origin") Object origin,
            @JsonProperty("location") Location location,
            @JsonProperty("image") String image,
            @JsonProperty("episode") ArrayList<String> episode,
            @JsonProperty("url") String url,
            @JsonProperty("created") String created
    ) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public Object getOrigin() {
        return origin;
    }

    public Location getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Character: { \n" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "status: " + status + "\n" +
                "species: " + species + "\n" +
                "type: " + type + "\n" +
                "gender: " + gender + "\n" +
                "origin: " + origin + "\n" +
                "location: " + location + "\n" +
                "image: " + image + "\n" +
                "episode: " + episode + "\n" +
                "url: " + url + "\n" +
                "created: " + created + "\n" +
                "}";
    }
}
