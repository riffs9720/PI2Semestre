package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.TipoFiltro;
import view.NovaSugestaoView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class TipoFiltroController{
   private TipoFiltro model;
   
   public TipoFiltroController(){
      model = new TipoFiltro();
   }
   
   public String[] getLista(){
     
      TipoFiltro tipoFiltro = new TipoFiltro();
      ArrayList<TipoFiltro> lista = tipoFiltro.selectAll();
      
      String[] saida = new String[lista.size()];
      TipoFiltro tF;
      //prenche o vetor com o id do cliente para criar a combobox
      for(int i = 0; i < lista.size(); i++){
         tF = lista.get(i);
         saida[i] = tF.getNome();
      }
      
      return saida;
   }
   

}