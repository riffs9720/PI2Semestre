package model;
import model.UsuarioAcesso;

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


import model.Model;
import model.TipoPerfil;
import model.TipoIdentificacao;
import dao.Conexao;

/*class UsuarioCadastro*/
public class UsuarioCadastro extends Model{
   private int idUsuarioCadastro;
   private String nome;
   private String cpf;
   private String dtNascimento;
   private String genero;
   private String endereco;
   private int numeroIdentificacao;
   private String dtCadastro;
   private int idTipoPerfil;
   private int idTipoIdentificacao; 
   private TipoPerfil tipoPerfil;
   private TipoIdentificacao tipoIdentificacao;
   
   public String table = "usuarioCadastro";
   
   public UsuarioCadastro(){
   }
      
   /*public UsuarioCadastro(String table){
      super(table);
   }*/
   
   public void setIdUsuarioCadastro(int idUsuarioCadastro){
      this.idUsuarioCadastro = idUsuarioCadastro;
   }
   
   public int getIdUsuarioCadastro(){
      return this.idUsuarioCadastro;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
   
   /*---*/
   public void setCpf(String cpf){
      this.cpf = cpf;
   }
     
   public String getCpf(){
      return this.cpf;
   }
   
   /*---*/
   public void setDtNascimento(String dtNascimento){
      /*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      Date date = new Date();
      this.dtNascimento = dateFormat.format(dtNascimento);*/
      this.dtNascimento = dtNascimento;
   }
     
   public String getDtNascimento(){
      return this.dtNascimento;
   }
   
   /*---*/
   public void setGenero(String genero){
      this.genero = genero;
   }
     
   public String getGenero(){
      return this.genero;
   }
   
   /*---*/
   public void setEndereco(String endereco){
      this.endereco = endereco;
   }
     
   public String getEndereco(){
      return this.endereco;
   }
   
   /*---*/
   public void setNumeroIdentificacao(int numeroIdentificacao){
      this.numeroIdentificacao = numeroIdentificacao;
   }
     
   public int getNumeroIdentificacao(){
      return this.numeroIdentificacao;
   }
   
   /*---*/
   public void setDtCadastro(String dtCadastro){
      this.dtCadastro = dtCadastro;
   }
     
   public String getDtCadastro(){
      return this.dtCadastro;
   }
   
   /*---*/
   public void setIdTipoPerfil(int idTipoPerfil){
      this.idTipoPerfil = idTipoPerfil;
   }
     
   public int getIdTipoPerfil(){
      return this.idTipoPerfil;
   }
   
   /*---*/
   public void setIdTipoIdentificacao(int idTipoIdentificacao){
      this.idTipoIdentificacao = idTipoIdentificacao;
   }
     
   public int getIdTipoIdentificacao(){
      return this.idTipoIdentificacao;
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
   
   public int insert(){
      String query = "INSERT INTO usuarioCadastro (nome, cpf, dtNascimento, genero, endereco, numeroIdentificacao, dtCadastro, tipoPerfil_id_tipoPerfil, tipoIdentificacao_id_tipoIdentificacao) VALUES (?,?,?,?,?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
           
          // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          // Date dtNascimento = format.parse(getDtNascimento());
           
         try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
            stm.setString(2, getCpf());
            stm.setString(3, getDtNascimento());
            stm.setString(4, getGenero());
            stm.setString(5, getEndereco());
            stm.setInt(6, getNumeroIdentificacao());
            stm.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setInt(8, getIdTipoIdentificacao());
            stm.setInt(9, getIdTipoIdentificacao());
            stm.execute();
            
            String sql = "select LAST_INSERT_ID()";
            
            try(PreparedStatement pst2 = conn.prepareStatement(sql);
               ResultSet rs = pst2.executeQuery();){
               if(rs.next()){
                  setIdUsuarioCadastro(rs.getInt(1));
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
      return getIdUsuarioCadastro();
   }  
   
   public void update(){
      String query = "UPDATE usuarioCadastro SET nome = ?, endereco = ?"; 
      
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
            stm.setString(2, getEndereco());      
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
   
   public ArrayList<UsuarioCadastro> selectAll(){
      ArrayList<UsuarioCadastro> lista = new ArrayList<>();
   
      String query = "select * from usuarioCadastro";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               UsuarioCadastro usuarioCadastro = new UsuarioCadastro();
               usuarioCadastro.setIdUsuarioCadastro(rs.getInt("idUsuarioCadastro"));
               usuarioCadastro.setNome(rs.getString("nome"));
               usuarioCadastro.setCpf(rs.getString("cpf"));               
               usuarioCadastro.setDtNascimento(rs.getString("dtNascimento"));   
               usuarioCadastro.setGenero(rs.getString("genero"));                           
               usuarioCadastro.setEndereco(rs.getString("endereco"));               
               usuarioCadastro.setNumeroIdentificacao(rs.getInt("numeroIdentificacao"));               
               usuarioCadastro.setDtCadastro(rs.getString("dtCadastro"));               
               usuarioCadastro.setIdUsuarioCadastro(rs.getInt("usuarioCadastro_idUsuarioCadastro")); 
                              
               lista.add(usuarioCadastro);
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

   public UsuarioCadastro selectById(){
      String query = "select * from usuarioCadastro where idUsuarioCadastro = ?";
         
      Connection conn = null;
      
      UsuarioCadastro usuarioCadastro = new UsuarioCadastro();    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            if(rs.next()){
               usuarioCadastro.setIdUsuarioCadastro(rs.getInt("idUsuarioCadastro"));
               usuarioCadastro.setNome(rs.getString("nome"));
               usuarioCadastro.setCpf(rs.getString("cpf"));               
               usuarioCadastro.setDtNascimento(rs.getString("dtNascimento"));   
               usuarioCadastro.setGenero(rs.getString("genero"));                           
               usuarioCadastro.setEndereco(rs.getString("endereco"));               
               usuarioCadastro.setNumeroIdentificacao(rs.getInt("numeroIdentificacao"));               
               usuarioCadastro.setDtCadastro(rs.getString("dtCadastro"));               
               usuarioCadastro.setIdUsuarioCadastro(rs.getInt("usuarioCadastro_idUsuarioCadastro")); 
            } 
         }
         catch(SQLException e){
            e.printStackTrace();
         }   
      }
      catch(SQLException e){
         e.printStackTrace();
      }
      
      return usuarioCadastro;
   }   
}


