package com.example.javaservlet.conn;

import java.sql.*;

public class ConexaoFactory {
    public static Connection getConexao(){
        String url = "jdbc:mysql://localhost:3306/db_name";
        String user = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection connection){
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement stmt){
        close(connection);
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement stmt, ResultSet rs){
        close(connection,stmt);
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
