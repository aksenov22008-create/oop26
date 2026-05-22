package auth;

import daabase.DaabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountManager {
    public static int register(String name ,String password) throws SQLException {
        Connection connection = DaabaseConnection.getInstance().getConnection();
        String query = "INSERT INTO account (username, password) VALUES(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, name);

        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        preparedStatement.setString(2, hashedPassword);
        preparedStatement.execute();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) rs.getInt(1);
        throw new RuntimeException("Nie udalo");
    }
    public static boolean authenticate(String name ,String password) throws SQLException {
        Connection connection = DaabaseConnection.getInstance().getConnection();
        String query = "SELECT password FROM account WHERE username =?";

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String dbPassword = rs.getString("password");
            BCrypt.Result result = BCrypt.verifyer().verefy(password.toCharArray(),dbPassword);
            return result.verified;
        }
        return false;
    }
}
