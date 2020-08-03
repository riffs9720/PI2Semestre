package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.Sugestao;
import model.UsuarioAcesso;
import view.NovaSugestaoView;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.awt.event.*;

public class SugestaoController implements ActionListener{

   private Sugestao model;
   private NovaSugestaoView view;
   private UsuarioAcesso usuarioAcesso;
   
   public SugestaoController(){}
   
   public SugestaoController(UsuarioAcesso usuarioAcesso){
      model = new Sugestao();
      view = new NovaSugestaoView(this);
      this.usuarioAcesso = usuarioAcesso;
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == view.getEnviar()){
      
         //validar e cadastar
         if(view.getTSugestao().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            model.setConteudo(view.getTSugestao());
            model.setIdUsuarioAcesso(usuarioAcesso.getIdUsuarioAcesso());
            model.setIdDepartamento(view.getTDepartamento());
            model.setTipoSugestao(view.getTTipoSugestao());
            
            JOptionPane.showMessageDialog(null, usuarioAcesso.getIdUsuarioAcesso());
          
            if(model.insert()){
               JOptionPane.showMessageDialog(null,"Sua sugestão foi cadastrada e em breve será avaliada. Muito Obrigada :D");
            
               view.setTSugestao("");
            }
         }
      }
            
   }
   
   public JPanel getView(){
      return view.getCentro();
   }
   
   public String[][] getDados(){
      Sugestao sugestao = new Sugestao();

      ArrayList<Sugestao> lista = sugestao.selectAll();
      
      //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      String[][] saida = new String[lista.size()][4];
      Sugestao sugestoes;
      for(int i = 0; i < lista.size(); i++){
         sugestoes = lista.get(i);
         
         UsuarioAcesso usu = new UsuarioAcesso();
         String nomeUsuario = usu.selectNome(sugestoes.getIdUsuarioAcesso());
         
         Sugestao su = new Sugestao();
         String departamento = su.selectDepartamento(sugestoes.getIdSugestao());
         
         saida[i][0] = nomeUsuario;
         saida[i][1] = sugestoes.getConteudo();
         saida[i][2] = departamento;         
         saida[i][3] = sugestoes.getDtSugestao();
      }
      return saida;
   }
   
   public String[][] getSugestoesAbertas(){
      Sugestao sugestao = new Sugestao();

      ArrayList<Sugestao> lista = sugestao.selectAberto();
      
      //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      String[][] saida = new String[lista.size()][4];
      Sugestao sugestoes;
      for(int i = 0; i < lista.size(); i++){
         sugestoes = lista.get(i);
         
         UsuarioAcesso usu = new UsuarioAcesso();
         String nomeUsuario = usu.selectNome(sugestoes.getIdUsuarioAcesso());
         
         Sugestao su = new Sugestao();
         String departamento = su.selectDepartamento(sugestoes.getIdSugestao());
         
         saida[i][0] = nomeUsuario;
         saida[i][1] = sugestoes.getConteudo();
         saida[i][2] = departamento;         
         saida[i][3] = sugestoes.getDtSugestao();
      }
      return saida;
   }
   
   public String[][] getSugestoesFinalizadas(){
      Sugestao sugestao = new Sugestao();

      ArrayList<Sugestao> lista = sugestao.selectFinalizado();
      
      //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      String[][] saida = new String[lista.size()][4];
      Sugestao sugestoes;
      for(int i = 0; i < lista.size(); i++){
         sugestoes = lista.get(i);
         
         UsuarioAcesso usu = new UsuarioAcesso();
         String nomeUsuario = usu.selectNome(sugestoes.getIdUsuarioAcesso());
         
         Sugestao su = new Sugestao();
         String departamento = su.selectDepartamento(sugestoes.getIdSugestao());
         
         saida[i][0] = nomeUsuario;
         saida[i][1] = sugestoes.getConteudo();
         saida[i][2] = departamento;         
         saida[i][3] = sugestoes.getDtSugestao();
      }
      return saida;
   }

}