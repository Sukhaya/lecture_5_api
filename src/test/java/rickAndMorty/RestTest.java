
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RestTest {
    private static final String URL = " https://rickandmortyapi.com/api";

    @Test
    public void getRick() {
        List<Character> characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.getName().matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        System.out.println(optionalMortySmith.get());
    }

    @Test
    public void getRickLastEpisode() {
        List<Character> characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.getName().matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);
        System.out.println(lastEpisodeOfMortySmith);
    }

    @Test
    public void getLastCharacterFromLastEpisodeOfRickMorty() {
        List<Character> characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.getName().matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        Episode lastEpisode = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastEpisodeOfMortySmith)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        System.out.println(lastEpisode.characters.get(lastEpisode.characters.size() - 1));
    }

    @Test
    public void getLocationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty() {
        List<Character> characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.getName().matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        Episode lastEpisode = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastEpisodeOfMortySmith)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        String lastCharacterId = lastEpisode.characters.get(lastEpisode.characters.size() - 1);

        Character lastCharacter = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastCharacterId)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Character.class);

        assertFalse(lastCharacter.location.getName().isEmpty(), "Нет данных о местоположении");
        assertFalse(lastCharacter.species.isEmpty(), "Нет данных о расе");

        System.out.println("Местоположение: " + lastCharacter.location.name + " Раса: " + lastCharacter.species);
    }

    @Test
    public void checkLocationAndSpeciesOfLastCharacterAndMorty() {
        List<Character> characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.getName().matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        Episode lastEpisode = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastEpisodeOfMortySmith)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        String lastCharacterId = lastEpisode.characters.get(lastEpisode.characters.size() - 1);

        Character lastCharacter = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastCharacterId)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Character.class);

        assertFalse(lastCharacter.location.getName().isEmpty(), "Нет данных о местоположении");
        assertFalse(lastCharacter.species.isEmpty(), "Нет данных о расе");

        assertAll(
                () -> assertEquals(mortySmith.location.name, lastCharacter.location.name),
                () -> assertEquals(mortySmith.species, lastCharacter.species)
        );
    }
}
