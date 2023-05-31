package src.by.fpmibsu.netside;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Connector {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        config.setUsername("user");
        config.setPassword("DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        config.setDriverClassName("org.postgresql.Driver");
        dataSource = new HikariDataSource(config);
    }

    public static Connection createConnection() throws SQLException, IOException, ClassNotFoundException {
        return dataSource.getConnection();
    }

}

