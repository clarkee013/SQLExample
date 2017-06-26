package example.codeclan.com.sqlexample;

import android.database.CursorJoiner;

import java.sql.ResultSet;

import db.SqlRunner;

import static android.R.attr.format;

/**
 * Created by user on 26/06/2017.
 */

public class Artist {

    private String name;
    private int id;

    public Artist(String name){
        this.name = name;
    }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }


    public void save() {
        String sql = String.format("INSERT INTO artists (name) VALUES ('%s');", this.name);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM artists;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void deleteAll() {
        String sql = "DELETE FROM artists;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void deleteSingleArtist() {
        String sql = String.format("DELETE FROM artists WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE artists SET name = '%s' WHERE id = %d;", this.name, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static Artist findArtistByName(String name) {
        Artist artist = null;
        String sql = String.format("SELECT * FROM artists WHERE name = '%s';", name);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameOfArtist = rs.getString("name");
                artist = new Artist(id, nameOfArtist);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return artist;
    }
}
