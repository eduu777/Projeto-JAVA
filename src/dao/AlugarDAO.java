/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import dto.AlugarDTO;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class AlugarDAO {
    Connection con;
   public boolean alugar(AlugarDTO objalugardto) throws Exception{
      con = new ConnectionFactory().createConnectionToMySQL();
       try {
           String sql = "INSERT INTO aluguel (cod_cliente, data_inicial, data_final, cod_livro, status) values (?,?,?,?,?)";
           PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
           pstm.setInt(1, objalugardto.getCod_cliente());
           pstm.setString(2, objalugardto.getData_inicial());
           pstm.setString(3, objalugardto.getData_final());
           pstm.setInt(4, objalugardto.getCod_livro());
           pstm.setString(5, objalugardto.getStatus());
           
           boolean rs = pstm.execute();
           return rs;
           
           
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null,"AlugarDAO" + erro);
           return false;
       }
   }
   
   public ArrayList<AlugarDTO> listarAlugados() throws Exception{
       con = new ConnectionFactory().createConnectionToMySQL();
       try {
           String sql = "SELECT * FROM aluguel";
           PreparedStatement pstm = (PreparedStatement) con .prepareStatement(sql);
           ResultSet rs = pstm.executeQuery();
           
           ArrayList<AlugarDTO> alugados = new ArrayList();
           while(rs.next()){
               AlugarDTO objalugardto = new AlugarDTO();
               objalugardto.setCod(rs.getInt("cod"));
               objalugardto.setCod_cliente(rs.getInt("cod_cliente"));
               objalugardto.setCod_livro(rs.getInt("cod_livro"));
               objalugardto.setData_final(rs.getString("data_final"));
               objalugardto.setData_inicial(rs.getString("data_inicial"));
               objalugardto.setStatus(rs.getString("status"));
               
               alugados.add(objalugardto);
           }
           
           return alugados;
       } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "AlugarDAO" + erro);
           return null;
       }
   }
}
