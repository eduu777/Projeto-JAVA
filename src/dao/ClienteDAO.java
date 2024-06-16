/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.mysql.jdbc.PreparedStatement;
import dto.ClienteDTO;
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
public class ClienteDAO {
    Connection con;
        public boolean addCliente(ClienteDTO objclientedto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
           String sql = "INSERT INTO cliente (cpf, nome, rua, bairro, numero, telefone) VALUES (?,?,?,?,?,?)";
           
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getCpf());
            pstm.setString(2, objclientedto.getNome());
            pstm.setString(3, objclientedto.getRua());
            pstm.setString(4, objclientedto.getBairro());
            pstm.setInt(5, objclientedto.getNumero());
            pstm.setString(6, objclientedto.getTelefone());
            
            boolean rs = pstm.execute();
            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"ClienteDAO" + erro);
            return false;
        }
    }
    public ArrayList<ClienteDTO> listarClientes() throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM cliente";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            ArrayList<ClienteDTO> clientes = new ArrayList();
            while(rs.next()){
                ClienteDTO cliente = new ClienteDTO();
                
                cliente.setCod(rs.getInt("cod"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                
                clientes.add(cliente);
            }
            
            return clientes;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
            return null;
        }
    }
    
    public ClienteDTO selClienteCpf(ClienteDTO objclientedto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getCpf());
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                objclientedto.setNome(rs.getString("nome"));
                objclientedto.setBairro(rs.getString("bairro"));
                objclientedto.setRua(rs.getString("rua"));
                objclientedto.setNumero(rs.getInt("numero"));
                objclientedto.setTelefone(rs.getString("telefone"));
                objclientedto.setCod(rs.getInt("cod"));
            }else{
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado");
            }
            
            return objclientedto;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
            return null;
        }
    }
    
    public ClienteDTO selClienteCod(ClienteDTO objclientedto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "SELECT * FROM cliente WHERE cod = ?";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getCod());
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                objclientedto.setNome(rs.getString("nome"));
                objclientedto.setBairro(rs.getString("bairro"));
                objclientedto.setRua(rs.getString("rua"));
                objclientedto.setNumero(rs.getInt("numero"));
                objclientedto.setTelefone(rs.getString("telefone"));
                objclientedto.setCpf(rs.getInt("cpf"));
            }else{
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado");
            }
            
            return objclientedto;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
            return null;
        }
    }
    
     public boolean updateCliente(ClienteDTO objclientedto) throws Exception{
        con = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "UPDATE cliente SET cpf=?, nome=?, rua=?, bairro=?, numero=?,telefone=? WHERE cod=? ";
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getCpf());
            pstm.setString(2, objclientedto.getNome());
            pstm.setString(3, objclientedto.getRua());
            pstm.setString(4, objclientedto.getBairro());
            pstm.setInt(5, objclientedto.getNumero());
            pstm.setString(6, objclientedto.getTelefone());
            pstm.setInt(7, objclientedto.getCod());
            boolean rs = pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado!");
            
            return true;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO" + erro);
            return false;
        }
    }
}
