package model;

/*require imports*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Conexao;

/*class Sugestao*/
public class Sugestao extends Model{
   private int idSugestao;
   private String conteudo;
   private String dtSugestao;
//   private String assunto;
   private int idUsuarioAcesso;
   private int idDepartamento;   
   private String tipoSugestao;   
   private int idStatus;
      
   private String table = "sugestao";
   
   public Sugestao(){}
   
   public Sugestao(String table){
      super(table);
   }
   
   public void setIdSugestao(int idSugestao){
      this.idSugestao = idSugestao;
   }  
   
   public int getIdSugestao(){
      return this.idSugestao;
   }
   
   /*---*/
   public void setConteudo(String conteudo){
      this.conteudo = conteudo;
   }
     
   public String getConteudo(){
      return this.conteudo;
   }
   
   /*---*/
   public void setDtSugestao(String dtSugestao){
      this.dtSugestao = dtSugestao;
   }
     
   public String getDtSugestao(){
      return this.dtSugestao;
   }
   
   /*---*/
   /*public void setAssunto(String assunto){
      this.assunto = assunto;
   }
     
   public String getAssunto(){
      return this.assunto;
   }*/
   
   /*---*/
   public void setIdUsuarioAcesso(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;
   }
     
   public int getIdUsuarioAcesso(){
      return this.idUsuarioAcesso;
   }
   
   /*---*/
   public void setIdDepartamento(int idDepartamento){
      this.idDepartamento = idDepartamento;
   }
     
   public int getIdDepartamento(){
      return this.idDepartamento;
   }
   
   /*---*/
   public void setTipoSugestao(String tipoSugestao){
      this.tipoSugestao = tipoSugestao;
   }
     
   public String getTipoSugestao(){
      return this.tipoSugestao;
   }
   
   /*---*/
   public void setIdStatus (int idStatus){
      this.idStatus = idStatus;
   }
     
   public int getIdStatus(){
      return this.idStatus;
   }
      
   public boolean insert(){
      String query = "INSERT INTO sugestao (conteudo, dtSugestao, usuarioAcesso_id_usuarioAcesso, departamento_idDepartamento, tipoSugestao, status_IdStatus) VALUES (?,?,?,?,?,?)"; 
      
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         java.util.Date date = new java.util.Date();
      
         try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setString(1, getConteudo());
            stm.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            stm.setInt(3, getIdUsuarioAcesso());
            stm.setInt(4, getIdDepartamento());                                                           
            stm.setString(5, getTipoSugestao());           
            stm.setInt(6, 1);            
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
      
      return true;
   }
   
   public void update(){
   
   } 
     
   public ArrayList<Sugestao> selectAll(){
      ArrayList<Sugestao> lista = new ArrayList<>();
   
      String query = "select * from sugestao";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Sugestao sugestao = new Sugestao();
               //terminar de inserir os dados de retorno no arrayList
               sugestao.setIdSugestao(rs.getInt("idSugestao"));
               sugestao.setDtSugestao(rs.getString("dtSugestao"));
               sugestao.setConteudo(rs.getString("conteudo"));
               sugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_id_usuarioAcesso")); 
               sugestao.setIdDepartamento(rs.getInt("departamento_idDepartamento"));                
               sugestao.setTipoSugestao(rs.getString("tipoSugestao"));               
               sugestao.setIdStatus(rs.getInt("status_idStatus"));
                              
               lista.add(sugestao);
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
   
   public ArrayList<Sugestao> selectAberto(){
      ArrayList<Sugestao> lista = new ArrayList<>();
   
      String query = "select * from sugestao where status_idStatus = 1";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Sugestao sugestao = new Sugestao();
               //terminar de inserir os dados de retorno no arrayList
               sugestao.setIdSugestao(rs.getInt("idSugestao"));
               sugestao.setDtSugestao(rs.getString("dtSugestao"));
               sugestao.setConteudo(rs.getString("conteudo"));
               sugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_id_usuarioAcesso")); 
               sugestao.setIdDepartamento(rs.getInt("departamento_idDepartamento"));                
               sugestao.setTipoSugestao(rs.getString("tipoSugestao"));               
               sugestao.setIdStatus(rs.getInt("status_idStatus"));
                              
               lista.add(sugestao);
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
   
   public ArrayList<Sugestao> selectFinalizado(){
      ArrayList<Sugestao> lista = new ArrayList<>();
   
      String query = "select * from sugestao where status_idStatus = 3";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();){
            
            while(rs.next()){
               Sugestao sugestao = new Sugestao();
               //terminar de inserir os dados de retorno no arrayList
               sugestao.setIdSugestao(rs.getInt("idSugestao"));
               sugestao.setDtSugestao(rs.getString("dtSugestao"));
               sugestao.setConteudo(rs.getString("conteudo"));
               sugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_id_usuarioAcesso")); 
               sugestao.setIdDepartamento(rs.getInt("departamento_idDepartamento"));                
               sugestao.setTipoSugestao(rs.getString("tipoSugestao"));               
               sugestao.setIdStatus(rs.getInt("status_idStatus"));
                              
               lista.add(sugestao);
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

   public ArrayList<Sugestao> selectById(int id){
      ArrayList<Sugestao> lista = new ArrayList<>();
   
      String query = "select * from sugestao where usuarioAcesso_id_usuarioAcesso = ?";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);){
            pst.setInt(1, id);
            
            try(ResultSet rs = pst.executeQuery();){
            
               while(rs.next()){
                  Sugestao sugestao = new Sugestao();
                  //terminar de inserir os dados de retorno no arrayList
                  sugestao.setIdSugestao(rs.getInt("idSugestao"));
                  sugestao.setDtSugestao(rs.getString("dtSugestao"));
                  sugestao.setConteudo(rs.getString("conteudo"));
                  sugestao.setIdUsuarioAcesso(rs.getInt("usuarioAcesso_id_usuarioAcesso")); 
                  sugestao.setIdDepartamento(rs.getInt("departamento_idDepartamento"));                
                  sugestao.setTipoSugestao(rs.getString("tipoSugestao"));               
                  sugestao.setIdStatus(rs.getInt("status_idStatus"));
                                 
                  lista.add(sugestao);
               }
            }catch(SQLException e1){
               e1.printStackTrace();
            } 
         }
         catch(SQLException e2){
            e2.printStackTrace();
         }   
      }
      catch(SQLException e){
         e.printStackTrace();
      }
      return lista;
   }  
   
   public String selectDepartamento(int id){
      String departamento = null;
         
      String query = "select departamento.nomeDepartamento from departamento inner join sugestao on sugestao.departamento_idDepartamento = departamento.idDepartamento where sugestao.idSugestao = ?";
         
      Connection conn = null;    
     
      try{
         Conexao bd = new Conexao();
         conn = bd.conectar();
      
         try (PreparedStatement pst = conn.prepareStatement(query);){
            pst.setInt(1, id);
            
            try(ResultSet rs = pst.executeQuery();){
            
               if(rs.next()){
                  Sugestao sugestao = new Sugestao();
                  //terminar de inserir os dados de retorno no arrayList
                  departamento = rs.getString("nomeDepartamento");
               }
            }catch(SQLException e1){
               e1.printStackTrace();
            } 
         }
         catch(SQLException e2){
            e2.printStackTrace();
         }   
      }
      catch(SQLException e){
         e.printStackTrace();
      }
      return departamento;
   }   
}


