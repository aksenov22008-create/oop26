package org.example;

import daabase.DaabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DaabaseConnection db = DaabaseConnection.getInstance();
        try {
            db.connect("site/users.db");
            selection();
            db.disconnect();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    public static void selection() throws SQLException {
        Connection conn = DaabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM account";
        PreparedStatement staement = conn.prepareCall(query);
        staement.execute();
        ResultSet rs = staement.getResultSet();
        while(rs.next()){
            int id = rs.getInt("id");
            String name =rs.getString("username");
            String path = rs.getString("password");
            System.out.println("ID:"+id +"NAME:"+name+"HASLO:"+path);
        }
    }
}
