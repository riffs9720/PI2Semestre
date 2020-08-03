package model;
import dao.Conexao;

/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.*;
import java.security.*;
import java.math.*;

/*class UsuarioCadastro*/
public class UsuarioAcesso extends Model{
   private int idUsuarioAcesso;
   private String nome;
   private String email;
   private String senha;
   private int idUsuarioCadastro;
   
   public String table = "usuarioAcesso";
   
   public UsuarioAcesso(){
   }
      
   /*public UsuarioCadastro(String table){
      super(table);
   }*/
   
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
   
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   public void setEmail(String email){
      this.email = email;
   }
     
   public String getEmail(){
      return this.email;
   }
   
   public void setSenha(String senha){
      this.senha = senha;
   }
     
   public String getSenha(){
      return this.senha;
   }
   
   public void setIdUsuarioCadastro(int idUsuarioCadastro){
      this.idUsuarioCadastro = idUsuarioCadastro;
   }
   
   public int getIdUsuarioCadastro(){
      return this.idUsuarioCadastro;
   }
   
   public String getMD5(String senhaUsuario){
      try{
         MessageDigest m = MessageDigest.getInstance("MD5");
         m.reset();
         m.update(senhaUsuario.getBytes());
         byte[] digest = m.digest();
         BigInteger bigInt = new BigInteger(1,digest);
         String hashtext = bigInt.toString(16);
         
         while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
         }
      
         return hashtext;
      
      }
      catch(java.security.NoSuchAlgorithmException e){
         return null;
      }
   }
   
   public UsuarioAcesso insert(){
      String query = "INSERT INTO usuarioAcesso (email, senha, usuarioCadastro_idUsuarioCadastro) VALUES (?,?,?)"; 
      
      Connection conn = null;    
      UsuarioAcesso usuarioAcesso = new UsuarioAcesso();
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
           
         try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getEmail());
            stm.setString(2, getSenha());
            stm.setInt(3, getIdUsuarioCadastro());
            stm.execute();
            
            String sql = "select LAST_INSERT_ID()";
            
            try(PreparedStatement pst2 = conn.prepareStatement(sql);
               ResultSet rs = pst2.executeQuery();){
               if(rs.next()){
                  
                  usuarioAcesso = this.selectById(rs.getInt(1));
               } 
            }
            catch(SQLException e){
               throw new IOException(e);
            }
         } 
         catch (Exception e) {
            e.printStackTrace();
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }   
         }
      }
      catch(Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }   
      }
      
      return usuarioAcesso;
   }  
   
   public void update(){
      String query = "UPDATE usuarioAcesso SET email = ?, senha = ?"; 
      
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getEmail());
            stm.setString(2, getSenha());      
            stm.execute();
         } 
         catch (Exception e) {
            e.printStackTrace();
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }   
         }
      }
      catch(Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }   
      }
   }   
   
   public ArrayList<UsuarioAcesso> selectAll(){
      ArrayList<UsuarioAcesso> lista = new ArrayList<>();
   
      String query = "select * from usuarioAcesso";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               UsuarioAcesso usuarioAcesso = new UsuarioAcesso();
               //terminar de inserir os dados de retorno no arrayList
               usuarioAcesso.setIdUsuarioAcesso(rs.getInt("idUsuarioAcesso"));
               usuarioAcesso.setEmail(rs.getString("email"));
               usuarioAcesso.setIdUsuarioCadastro(rs.getInt("usuarioCadastro_idUsuarioCadastro")); 
                              
               lista.add(usuarioAcesso);
            } 
         }
         catch(SQLException e){
            e.printStackTrace();
         }   
      }
      catch(SQLException e){
         e.printStackTrace();
      }
      return lista;
   }

   public UsuarioAcesso selectByEmail(){
      String query = "select * from usuarioAcesso where email = ?";
         
      Connection conn = null;
      
      UsuarioAcesso usuarioAcesso = new UsuarioAcesso();    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);){
            stm.setString(1, getEmail());
            try( ResultSet rs = stm.executeQuery();){ 
               if(rs.next()){
                  usuarioAcesso.setIdUsuarioAcesso(rs.getInt("idUsuarioAcesso"));
                  usuarioAcesso.setEmail(rs.getString("email"));
                  usuarioAcesso.setSenha(rs.getString("senha"));
                  usuarioAcesso.setIdUsuarioCadastro(rs.getInt("usuarioCadastro_idUsuarioCadastro"));
               } 
            }
            catch(SQLException e){
               e.printStackTrace();
            }
         }
         catch(SQLException e1){
            e1.printStackTrace();
         }   
      }
      catch(SQLException e2){
         e2.printStackTrace();
      }
      
      return usuarioAcesso;
   }
   
   public UsuarioAcesso selectById(int id){
      String query = "select * from usuarioAcesso where idUsuarioAcesso = ?";
         
      Connection conn = null;
      
      UsuarioAcesso usuarioAcesso = new UsuarioAcesso();    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);){
            stm.setInt(1, id);
            try( ResultSet rs = stm.executeQuery();){ 
               if(rs.next()){
                  usuarioAcesso.setIdUsuarioAcesso(rs.getInt("idUsuarioAcesso"));
                  usuarioAcesso.setEmail(rs.getString("email"));
                  usuarioAcesso.setSenha(rs.getString("senha"));
                  usuarioAcesso.setIdUsuarioCadastro(rs.getInt("usuarioCadastro_idUsuarioCadastro"));
               } 
            }
            catch(SQLException e){
               e.printStackTrace();
            }
         }
         catch(SQLException e1){
            e1.printStackTrace();
         }   
      }
      catch(SQLException e2){
         e2.printStackTrace();
      }
      
      return usuarioAcesso;
   }
   
   public String selectNome(int id){
      String query = "select usuarioCadastro.nome from usuarioCadastro inner join usuarioAcesso on usuarioCadastro.idUsuarioCadastro = usuarioAcesso.usuarioCadastro_idUsuarioCadastro where usuarioAcesso.idUsuarioAcesso = ?";
         
      Connection conn = null;
      
      String nome = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);){
            stm.setInt(1, id);
            try( ResultSet rs = stm.executeQuery();){ 
               if(rs.next()){
                  nome = rs.getString("nome");
               } 
            }
            catch(SQLException e){
               e.printStackTrace();
            }
         }
         catch(SQLException e1){
            e1.printStackTrace();
         }   
      }
      catch(SQLException e2){
         e2.printStackTrace();
      }
      
      return nome;
   }
   
   public int selectPerfil(int id){
      String query = "select usuarioCadastro.tipoPerfil_id_tipoPerfil as 'Perfil' from usuarioCadastro inner join usuarioAcesso on usuarioCadastro.idUsuarioCadastro = usuarioAcesso.usuarioCadastro_idUsuarioCadastro where usuarioAcesso.idUsuarioAcesso = ?";
         
      Connection conn = null;
      
      int perfil = 0;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);){
            stm.setInt(1, id);
            try( ResultSet rs = stm.executeQuery();){ 
               if(rs.next()){
                  perfil = rs.getInt("Perfil");
               } 
            }
            catch(SQLException e){
               e.printStackTrace();
            }
         }
         catch(SQLException e1){
            e1.printStackTrace();
         }   
      }
      catch(SQLException e2){
         e2.printStackTrace();
      }
      
      return perfil;
   }
}


