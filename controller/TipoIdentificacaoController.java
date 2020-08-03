package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.UsuarioCadastro;
import model.UsuarioAcesso;
import view.UsuarioCadastroView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import model.TipoIdentificacao;

public class TipoIdentificacaoController{
   private TipoIdentificacao model;
   
   public TipoIdentificacaoController(){
      model = new TipoIdentificacao();
   }
   
   public String[] getLista(){
     
      TipoIdentificacao tipoIdentificacao = new TipoIdentificacao();
      ArrayList<TipoIdentificacao> lista = tipoIdentificacao.selectAll();
      
      String[] saida = new String[lista.size()];
      TipoIdentificacao tI;
      //prenche o vetor com o id do cliente para criar a combobox
      for(int i = 0; i < lista.size(); i++){
         tI = lista.get(i);
         saida[i] = tI.getNome();
      }
      
      return saida;
   }
   

}