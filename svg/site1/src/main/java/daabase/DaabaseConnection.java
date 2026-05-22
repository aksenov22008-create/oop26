package daabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaabaseConnection {
    private Connection connection;
    private static DaabaseConnection instance =null;

    private DaabaseConnection(){

    }
    public static DaabaseConnection getInstance(){
        if (instance == null){
            instance = new DaabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    public void connect(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+path);
    }
    public void disconnect() throws SQLException {
        if (connection!= null && !connection.isClosed()){
            connection.close();
        }
    }
}
