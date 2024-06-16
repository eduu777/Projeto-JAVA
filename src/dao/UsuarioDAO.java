/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author Eduardo
 */
public class UsuarioDAO {
    
    Connection con;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "select * from usuario where login = ? and senha = ?";
            
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome());
            pstm.setString(2, objusuariodto.getSenha());
        
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDao erro" + erro);
            return null;
        }
    }
    
    public boolean addUsuario(UsuarioDTO objusuariodto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "INSERT INTO usuario (nome, login, senha, cargo) VALUES (?,?,?,?)";
            
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome());
            pstm.setString(2, objusuariodto.getLogin());
            pstm.setString(3, objusuariodto.getSenha());
            pstm.setString(4, objusuariodto.getCargo());
            
            boolean rs = pstm.execute();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDao erro" + erro);
            return false;
        }
    }
    
}
