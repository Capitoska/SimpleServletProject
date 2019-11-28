package by.kosya.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDatabaseConnection {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static {
        config.setJdbcUrl("jdbc:mysql:// localhost:3306/servlets_databases?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("32163216");
        config.setDriverClassName("com.mysql.jdbc.Driver");
//        config.addDataSourceProperty( "cachePrepStmts"
//        , "true" );
//        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        dataSource = new HikariDataSource(config);
        System.out.println("HikariDatabaseConnection.static initializer");
    }

    private HikariDatabaseConnection(){}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
