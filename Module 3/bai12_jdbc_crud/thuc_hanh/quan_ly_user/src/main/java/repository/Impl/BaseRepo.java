package repository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
    private String jdbcUrl="jdbc:mysql://localhost:3360/demo";
    private String jdbcUsername="root";
    private String jdbcPassword="abc123";
    private Connection connection;

    public BaseRepo(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection= DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
}
