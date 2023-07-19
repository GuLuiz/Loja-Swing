package br.com.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDB {
    
    //faz conexão com o banco de dados
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");

            conn = DriverManager.getConnection(
            "jdbc:h2:tcp://localhost/c:/Projeto/banco/loja",
            "sa",
            "123");



         } catch (ClassNotFoundException e) {

            e.printStackTrace();
            } catch (SQLException e) {
            e.printStackTrace();
            }

        return conn;

    }

    // executa comandos Insert, Delete, Update
    public void executeUpdate(String sql){
        Connection conn = getConnection();

        try {
            int i = conn.createStatement().executeUpdate(sql);
            System.out.println("Numero de registro afetados : " + i);
        } catch (SQLException e) {

            e.printStackTrace();

            
        }
        

    }
        
    // executa Select
    public ResultSet executeSelect(String sql) {
        Connection conn = getConnection();
        ResultSet ret = null;
        try {
            ret= conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
    
            e.printStackTrace();
        }
        return ret;
    }


    public int executeInsertGetId(String sqlInsert ){
        Connection conn = getConnection();
        int id = -1;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
            int linhasAfetadas = pstmt.executeUpdate();
            ResultSet idGerado = pstmt.getGeneratedKeys();
            if ( idGerado.next()){
                id = idGerado.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }
}