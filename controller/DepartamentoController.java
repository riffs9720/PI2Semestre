package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.Departamento;
import view.NovaSugestaoView;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DepartamentoController{
   private Departamento model;
   
   public DepartamentoController(){
      model = new Departamento();
   }
   
   public String[] getLista(){
     
      Departamento departamento = new Departamento();
      ArrayList<Departamento> lista = departamento.selectAll();
      
      String[] saida = new String[lista.size()];
      Departamento d;
      //prenche o vetor com o id do cliente para criar a combobox
      for(int i = 0; i < lista.size(); i++){
         d = lista.get(i);
         saida[i] = d.getNome();
      }
      
      return saida;
   }
   

}