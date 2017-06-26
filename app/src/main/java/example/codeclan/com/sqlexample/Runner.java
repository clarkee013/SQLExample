package example.codeclan.com.sqlexample;

/**
 * Created by user on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Album.deleteAll();
        Artist.deleteAll();
        Artist artist = new Artist("Led Zeppelin");
        artist.save();
        Album album = new Album("Houses of the holy", "Rock", artist.getId());
        album.save();
        album.setTitle("Physical Graffiti");
        album.update();
        album.save();
        album.getAllDetails();

        Artist searchArtist = Artist.findArtistByName("Led Zeppelin");
        System.out.println(searchArtist.getName());



    }
}