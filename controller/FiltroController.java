package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.Filtro;
import view.NovaSugestaoView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class FiltroController{
   private Filtro model;
   
   public FiltroController(){
      model = new Filtro();
   }
   
   public String[] getLista(){
     
      Filtro filtro = new Filtro();
      ArrayList<Filtro> lista = filtro.selectAll();
      
      String[] saida = new String[lista.size()];
      Filtro f;
      //prenche o vetor com o id do cliente para criar a combobox
      for(int i = 0; i < lista.size(); i++){
         f = lista.get(i);
         saida[i] = f.getNome();
      }
      
      return saida;
   }
   

}