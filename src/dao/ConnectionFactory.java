/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eduardo
 */
public class ConnectionFactory {
    
    //nome do usuário do mysql
    private static final String USERNAME = "root";
    
    //Senha do banco
    private static final String PASSWORD = "";
    
    //Caminho do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/biblioteca";
    
    //conexão com o banco
    public static Connection createConnectionToMySQL()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        return connection;
    }
    
    public static void main(String[] args) throws Exception {
        //recuperar conexão
        Connection con = createConnectionToMySQL();
        
        if(con!=null){
            System.out.println("Ok");
            con.close();
        }
    }
    
}
