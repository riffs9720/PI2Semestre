package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.Sugestao;
import model.UsuarioAcesso;
import model.Avaliacao;

import view.AvaliacaoView;
import view.AvaliarView;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.awt.event.*;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AvaliacaoController implements ActionListener, ListSelectionListener{

   private Avaliacao model;
   private AvaliacaoView view;
   private UsuarioAcesso usuarioAcesso;
   private int idUsuarioAcesso;
   private AvaliarView avaliarView;

   public AvaliacaoController(int idUsuarioAcesso){
      this.idUsuarioAcesso = idUsuarioAcesso;   
   }
   
   public AvaliacaoController(UsuarioAcesso usuarioAcesso){
      model = new Avaliacao();
      view = new AvaliacaoView(this, usuarioAcesso, this);
      this.usuarioAcesso = usuarioAcesso;
   }
   
   public void actionPerformed(ActionEvent e){
      /*if(e.getSource() == view.getPesquisar()){
      
         //validar e cadastar
         if(1==0){
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
         }*/
      //}   
      
        if(e.getSource() == avaliarView.getAprovar()){
            JOptionPane.showMessageDialog(null,"Avaliação feita com sucesso!");
            avaliarView.close();
        }
   }
   
   public void valueChanged(ListSelectionEvent e){
      /* colocar dentro deste if porque o evento e disparado duas vezes e assim 
         filtra-se somente um deles */
      if(e.getValueIsAdjusting()){
         avaliarView = new AvaliarView(this);
         avaliarView.getNome().setText(view.getTable().getValueAt(view.getTable().getSelectedRow(),0).toString());
         avaliarView.getSugestao().setText(view.getTable().getValueAt(view.getTable().getSelectedRow(),1).toString());
         avaliarView.getDepartamento().setText(view.getTable().getValueAt(view.getTable().getSelectedRow(),2).toString());         
      }
   
   }
   
   public JPanel getView(){
      return view.getCentro();
   }
   
   public String[][] getDados(){
      Sugestao sugestao = new Sugestao();
      ArrayList<Sugestao> lista = sugestao.selectById(this.idUsuarioAcesso);
      
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