package dao;

public interface DBConfig {
    final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    final String JDBC_URL = "jdbc:mysql://localhost/javadb?characterEncoding=UTF-8&serverTimezone=JST";
    //final String DB_USER="root";
    final String DB_USER="insuser";
    final String DB_PASS="";
}
