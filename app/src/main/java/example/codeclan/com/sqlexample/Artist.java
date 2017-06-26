package example.codeclan.com.sqlexample;

import db.SqlRunner;

/**
 * Created by user on 26/06/2017.
 */

public class Artist {

    private String name;
    private int id;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }


    public void save() {
        String sql = "";
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


}
