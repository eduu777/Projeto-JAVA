/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.mysql.jdbc.PreparedStatement;
import dto.LivroDTO;
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
public class LivroDAO {
    Connection con;
    public boolean adicionarLivro(LivroDTO objlivrodto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "INSERT INTO livro (nome, autor, categoria, isbn) VALUES (?,?,?,?)";
            
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, objlivrodto.getNome());
            pstm.setString(2, objlivrodto.getAutor());
            pstm.setString(3, objlivrodto.getCategoria());
            pstm.setInt(4, objlivrodto.getIsbn());
            
        
            boolean rs = pstm.execute();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "livroDAO erro" + erro);
            return false;
        }
    }
    
    public ArrayList<LivroDTO> listarLivros() throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM livro";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<LivroDTO> livros = new ArrayList();
            while(rs.next()){
                LivroDTO livro = new LivroDTO();
                
                livro.setCod(rs.getInt("cod"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setIsbn(rs.getInt("isbn"));
                
                livros.add(livro);
            }
            return livros;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"LivroDAO" + erro);
            return null;
        }
        
    }
    
    public ArrayList<LivroDTO> listarLivrosCFiltro(LivroDTO objlivrodto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM livro WHERE nome LIKE ?";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, objlivrodto.getNome());
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<LivroDTO> livros = new ArrayList();
            while(rs.next()){
                LivroDTO livro = new LivroDTO();
                
                livro.setCod(rs.getInt("cod"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setIsbn(rs.getInt("isbn"));
                
                livros.add(livro);
            }
            return livros;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"LivroDAO" + erro);
            return null;
        }
        
    }
    
    public LivroDTO selLivroCod(LivroDTO objlivrodto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM livro WHERE cod = ?";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, objlivrodto.getCod());
            ResultSet rs = pstm.executeQuery();
            
           if(rs.next()){
               objlivrodto.setNome(rs.getString("nome"));
               objlivrodto.setAutor(rs.getString("autor"));
               objlivrodto.setCategoria(rs.getString("categoria"));
               objlivrodto.setIsbn(rs.getInt("isbn"));
               
           }
           return objlivrodto;
        } catch (SQLException e) {
            return null;
        }
    }
}
