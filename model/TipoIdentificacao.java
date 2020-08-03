package model;

/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Model;
import dao.Conexao;

/*class TipoIdentificacao*/
public class TipoIdentificacao extends Model{
   private int idTipoIdentificacao;
   private String nome;
   
   public String table = "tipoPerfil";
   
   public TipoIdentificacao(){}
   
   public TipoIdentificacao(String table){
      super(table);
   }
   
   public void setIdTipoIdentificacao(int idTipoIdentificacao){
      this.idTipoIdentificacao = idTipoIdentificacao;
   }
   
   public int getIdTipoIdentificacao(){
      return this.idTipoIdentificacao;
   }
   
   /*---*/
   public void setNome(String nome){
      this.nome = nome;
   }
     
   public String getNome(){
      return this.nome;
   }
      
   public void insert(){
      String query = "INSERT INTO tipoIdentificacao (nome) VALUES (?)"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());
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
      }catch(Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }   
      }
   }
   
   public void update(){
      String query = "UPDATE tipoIdentificacao SET nome = ?"; 
      
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();
 
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getNome());      
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
      }catch(Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }   
      }   
   } 
   
   
   public ArrayList<TipoIdentificacao> selectAll(){
      ArrayList<TipoIdentificacao> lista = new ArrayList<>();

      String query = "select * from tipoIdentificacao";
         
      Connection conn = null;    
     
      try{
           Conexao bd = new Conexao();
           conn = bd.conectar();

         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               TipoIdentificacao tipoIdentificacao = new TipoIdentificacao();
               tipoIdentificacao.setIdTipoIdentificacao(rs.getInt("idTipoIdentificacao"));
               tipoIdentificacao.setNome(rs.getString("nome"));        
               lista.add(tipoIdentificacao);
            } 
         }
         catch(SQLException e){
            e.printStackTrace();
         }   
      }catch(SQLException e){
         e.printStackTrace();
      }
      
      return lista;
   }
}


