package com.thp.project.vintud.config;

import java.sql.Connection;

public class DbContract {

    private static Connection connection;
    private static String host = "jdbc:postgresql://localhost:5432/";
    private static String dbName = "vintud";
    private static String user = "postgres";
    private static String password = "root";

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DbContract.connection = connection;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DbContract.host = host;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        DbContract.dbName = dbName;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DbContract.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DbContract.password = password;
    }

}
