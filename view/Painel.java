package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Painel extends JFrame{
       
   public Painel(){}
   
   public void montarPainel(){
      JPanel pnlCentro = new JPanel(new GridLayout(2,0,2,2));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new FlowLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
      
      JPanel meio = new JPanel(new GridLayout(0,3,2,2));
      
      JPanel m1 = new JPanel(new BorderLayout());
      JPanel m2 = new JPanel(new BorderLayout());
      JPanel m3 = new JPanel(new BorderLayout());
   
      pnlBloco1.add(meio);
   
      meio.add(m1);
      meio.add(m2);
      meio.add(m3);
   
      add(pnlCentro);
      
      
       //******* divisao de 9 linhas --m1 --Primeiro Bloco--
   
      JPanel linhaBloco1 = new JPanel(new GridLayout(9,0,2,2));
      JPanel lb1 = new JPanel(new BorderLayout());
      JPanel lb2 = new JPanel(new FlowLayout());
      JPanel lb3 = new JPanel(new FlowLayout());
      JPanel lb4 = new JPanel(new BorderLayout());
      JPanel lb5 = new JPanel(new FlowLayout());
      JPanel lb6 = new JPanel(new FlowLayout());
      JPanel lb7 = new JPanel(new FlowLayout());
      JPanel lb8 = new JPanel(new FlowLayout());
      JPanel lb9 = new JPanel(new FlowLayout());
      
      Painel painel = new Painel();
   
   //******* divisao de 9 linhas no m2 --Segundo Bloco--
      
      JPanel linhaCentro = new JPanel(new GridLayout(9,0,2,2));
      JPanel l1 = new JPanel(new BorderLayout());
      JPanel l2 = new JPanel(new FlowLayout());
      JPanel l3 = new JPanel(new BorderLayout());
      JPanel l4 = new JPanel(new FlowLayout());
      JPanel l5 = new JPanel(new FlowLayout());
      JPanel l6 = new JPanel(new FlowLayout());
      JPanel l7 = new JPanel(new FlowLayout());
      JPanel l8 = new JPanel(new FlowLayout());
      JPanel l9 = new JPanel(new FlowLayout());
      
      m1.add( linhaBloco1); 
     
      linhaBloco1.add(lb1);
      linhaBloco1.add(lb2);
      linhaBloco1.add(lb3);
      linhaBloco1.add(lb4);
      linhaBloco1.add(lb5);
      linhaBloco1.add(lb6);
      linhaBloco1.add(lb7);
      linhaBloco1.add(lb8);
      linhaBloco1.add(lb9);
     
      m2.add(linhaCentro);
      linhaCentro.add(l1);
      linhaCentro.add(l2);
      linhaCentro.add(l3);
      linhaCentro.add(l4);
      linhaCentro.add(l5);
      linhaCentro.add(l6);
      linhaCentro.add(l7);
      linhaCentro.add(l8);
      linhaCentro.add(l9);  
      
      
      //l4.add(lblSistemaDeSugestao);
      //l6.add(lblGerenciarFuncao);
      //lb8.add(lblFiltrosDePesquisa);
   
      //lb9.add(txtPesquisarFuncao,BorderLayout.EAST);
      //lb9.add(btnPesquisar);
      
      lb1.setBackground(Color.WHITE);
      lb2.setBackground(Color.WHITE);
      lb3.setBackground(Color.WHITE);
      lb4.setBackground(Color.WHITE);
      lb5.setBackground(Color.WHITE);
      lb6.setBackground(Color.WHITE);
      lb7.setBackground(Color.WHITE);
      lb8.setBackground(Color.WHITE);
      lb9.setBackground(Color.WHITE);
      
      l1.setBackground(Color.WHITE);
      l2.setBackground(Color.WHITE);
      l3.setBackground(Color.WHITE);
      l4.setBackground(Color.WHITE);
      l5.setBackground(Color.WHITE);
      l6.setBackground(Color.WHITE);
      l7.setBackground(Color.WHITE);
      l8.setBackground(Color.WHITE);
      l9.setBackground(Color.WHITE);
      
      pnlBloco2.setBackground(Color.WHITE);
      m3.setBackground(Color.WHITE);
      //pnlCentro.setBackground(Color.WHITE);
               
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLocationRelativeTo(null);
       
      setVisible(true);
   
   }
   
   public void painel2(){
      JPanel pnlCentro = new JPanel(new GridLayout(2,0,2,2));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new BorderLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
      
      JPanel meio = new JPanel(new GridLayout(0,3,2,2));
      
      JPanel m1 = new JPanel(new BorderLayout());
      JPanel m2 = new JPanel(new BorderLayout());
      JPanel m3 = new JPanel(new BorderLayout());
             
      pnlBloco1.add(meio);
     
      meio.add(m1);
      meio.add(m2);
      meio.add(m3);
   
      add(pnlCentro);
      
      JPanel linhaCentro = new JPanel(new GridLayout(9,0,2,2));
      JPanel l1 = new JPanel(new BorderLayout());
      JPanel l2 = new JPanel(new FlowLayout());
      JPanel l3 = new JPanel(new BorderLayout());
      JPanel l4 = new JPanel(new FlowLayout());
      JPanel l5 = new JPanel(new FlowLayout());
      JPanel l6 = new JPanel(new FlowLayout());
      JPanel l7 = new JPanel(new FlowLayout());
      JPanel l8 = new JPanel(new BorderLayout());
      JPanel l9 = new JPanel(new BorderLayout());
   
      pnlBloco1.add(meio);
    
      JPanel meio2 = new JPanel(new GridLayout(0,3,2,2));
      
      JPanel me1 = new JPanel(new BorderLayout());
      JPanel me2 = new JPanel(new BorderLayout());
      JPanel me3 = new JPanel(new BorderLayout());
   
    
      pnlBloco2.add(meio2);       
      
   
     
      meio2.add(me1);
      meio2.add(me2);
      meio2.add(me3);
      
              
      JPanel linhaBloco2 = new JPanel(new GridLayout(2,0,2,2));
      JPanel lb1 = new JPanel(new BorderLayout());
      JPanel lb2 = new JPanel(new FlowLayout());
      me2.add(linhaBloco2);
   
      add(pnlCentro);
      
      m2.add(linhaCentro);
      linhaCentro.add(l1);
      linhaCentro.add(l2);
      linhaCentro.add(l3);
      linhaCentro.add(l4);
      linhaCentro.add(l5);
      linhaCentro.add(l6);
      linhaCentro.add(l7);
      linhaCentro.add(l8);
      linhaCentro.add(l9);  
      
      me2.add(linhaBloco2); 
     
      linhaBloco2.add(lb1);
      linhaBloco2.add(lb2);
              
      m1.setBackground(Color.WHITE);
      
      l1.setBackground(Color.WHITE);
      l2.setBackground(Color.WHITE);
      l3.setBackground(Color.WHITE);
      l4.setBackground(Color.WHITE);
      l5.setBackground(Color.WHITE);
      l6.setBackground(Color.WHITE);
      l7.setBackground(Color.WHITE);
      l8.setBackground(Color.WHITE);
      l9.setBackground(Color.WHITE);
      
      pnlBloco2.setBackground(Color.WHITE);
      lb1.setBackground(Color.WHITE);
      lb2.setBackground(Color.WHITE);
    
      m3.setBackground(Color.WHITE);
      me1.setBackground(Color.WHITE);
      me2.setBackground(Color.WHITE);
      me3.setBackground(Color.WHITE);
   
   
      /*public JPanel getL1(){
         return l1;
      }
      
      public void setL1(JPanel l1){
         this.l1 = l1;
      }
      
      public JPanel getL2(){
         return l2;
      }
      
      public void setL2(JPanel l2){
         this.l2 = l2;
      }
      
      public JPanel getL3(){
         return l3;
      }
      
      public void setL3(JPanel l3){
         this.l3 = l3;
      }
      public JPanel getL4(){
         return l4;
      }
      
      public void setL4(JPanel l4){
         this.l4 = l4;
      }
      
      public JPanel getL5(){
         return l5;
      }
      
      public void setL5(JPanel l5){
         this.l5 = l5;
      }
      public JPanel getL6(){
         return l6;
      }
      
      public void setL6(JPanel l6){
         this.61 = l6;
      }
   public JPanel getL7(){
         return l7;
      }
      
      public void setL7(JPanel l7){
         this.l7 = l7;
      }
      
      public JPanel getL8(){
         return l8;
      }
      
      public void setL8(JPanel l8){
         this.l8 = l1;
      }
      public JPanel getL9(){
         return l9;
      }
      
      public void setL9(JPanel l9){
         this.l9 = l9;
      }*/
   
      pack();
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLocationRelativeTo(null);
       
      setVisible(true);
   }
}