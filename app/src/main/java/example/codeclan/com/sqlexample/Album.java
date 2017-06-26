package example.codeclan.com.sqlexample;

import java.sql.ResultSet;

import db.SqlRunner;

import static android.R.attr.format;

/**
 * Created by user on 26/06/2017.
 */

public class Album {

    private String title;
    private String genre;
    private int artist_id;
    private int id;

    public Album(String title, String genre, int artist_id) {
        this.title = title;
        this.genre = genre;
        this.artist_id = artist_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public void save() {
        String sql = String.format("INSERT INTO albums (title, genre, artist_id) VALUES ('%s', '%s', %d);"
                , this.title, this.genre, this.artist_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM albums;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while (rs.next()) {
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int artist_id = rs.getInt("artist_id)");
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Artist id: " + artist_id);
                System.out.println();
            }
            } catch (Exception ex){
                System.exit(0);
            } finally {
                SqlRunner.closeConnection();
            }
        }

    public static void deleteAll() {
        String sql = "DELETE FROM albums;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void deleteSingleAlbum(){
        String sql = String.format("DELETE FROM album WHERE artist.getId = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE albums SET title = '%s', genre = '%s', artist_id = %d " +
                        "WHERE artist_id = %d;", this.title,  this.genre, this.artist_id, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void getAllDetails(){
        String sql = String.format("SELECT artists.name, albums.title, albums.genre FROM" +
                " artists JOIN albums ON artists.id = albums.artist_id WHERE albums.id = %d;", this.id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                String name = rs.getString("name");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                System.out.println("Artist: " + name);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}


