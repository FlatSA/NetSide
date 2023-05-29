package src.by.fpmibsu.netside;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    public static Connection createConnection() throws ClassNotFoundException, SQLException, IOException {
        String connectionUrl = "jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi";
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(connectionUrl);
        return connection;
    }



}
