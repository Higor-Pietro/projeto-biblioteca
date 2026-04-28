package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Atributos para conexão sql

    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "root";

    // Criação de objeto para conexão

    private static Connection conn;

    //método para verificação de conexão

    public static Connection getConexao(){

       try{
           if (conn == null){
               conn = DriverManager.getConnection(url, user, password);
               return conn;
           }else{
               return conn;
           }
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }

    }



}
