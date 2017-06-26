package example.codeclan.com.sqlexample;

/**
 * Created by user on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Artist artist = new Artist("Led Zeppelin");
        Album album = new Album("Houses of the holy", "Rock", artist);
        artist.save();
        album.save();


    }
}