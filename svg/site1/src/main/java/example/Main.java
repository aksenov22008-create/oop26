package example;

import auth.AccountManager;
import daabase.DaabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DaabaseConnection db = DaabaseConnection.getInstance();
        try {
            db.connect("site1/users.db");
            AccountManager.register("Tesownik","test123");
            AccountManager.authenticate("JanKow","test123");
            selection();
            db.disconnect();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    public static void selection() throws SQLException {
        Connection conn = DaabaseConnection.getInstance().getConnection();
        String query = "SELECT * FROM account";
        PreparedStatement staement = conn.prepareStatement(query);
        staement.execute();
        ResultSet rs = staement.getResultSet();
        while(rs.next()){
            int id = rs.getInt("id");
            String name =rs.getString("username");
            String path = rs.getString("password");
            System.out.println("ID:"+id +" NAME:"+name+" HASLO:"+path);
        }
    }
    public static void insert(String name ,String password) throws SQLException {
        Connection connection = DaabaseConnection.getInstance().getConnection();
        String query = "INSERT INTO account (username, password) VALUES(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            System.out.println("Create ID: "+id);
        }
    }
}
