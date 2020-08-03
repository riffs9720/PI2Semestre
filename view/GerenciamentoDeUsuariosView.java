package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GerenciamentoDeUsuariosView extends JFrame{
   private JComboBox cbPerfil;
   private JLabel lblGerenciarUsuario, lblFiltrosDePesquisa, lblSistemaDeSugestao;
   private JTextField txtPesquisarUsuario;
   private JButton btnPesquisar;
   //private JTable tabela;
   
   private JPanel pnlCentro;
   
   public GerenciamentoDeUsuariosView(){
      super("Sistema De Sugestão - Gerenciar Usuários");
      
      //Container caixa = getContentPane();
      //caixa.setLayout(new BorderLayout());
      
      //**** Label--- Alterar cor e fonte do Sistema Sugestão
      lblSistemaDeSugestao = new JLabel("Sistema De Sugestão");
      lblSistemaDeSugestao.setFont(new Font("Arial", Font.BOLD , 30));
      lblSistemaDeSugestao.setForeground(new Color(32,178,170));
      
      //**** Label --- Alterar cor e fonte do Sistema Sugestão
      lblGerenciarUsuario  = new JLabel("Gerenciar Funções");
      lblGerenciarUsuario.setFont(new Font("Arial", Font.BOLD,25));
      lblGerenciarUsuario.setForeground(new Color(32,178,170));
      
      //***Label -----Alterar a fonte -- Filtro de Pesquisa
      lblFiltrosDePesquisa = new JLabel("Filtros de Pesquisa");
      lblFiltrosDePesquisa.setFont(new Font("Sans serif", Font.ITALIC, 15));
     
      //****Alterar o TextField
      txtPesquisarUsuario = new JTextField("Nome do Usuário");
      txtPesquisarUsuario .setPreferredSize( new Dimension(320,25) );
   
      
      
      //***ComboBox Perfil****
      String[] arrayItens = {"Perfil","Segundo ","Terceiro ","Quarto"};
      cbPerfil = new JComboBox(arrayItens);
      cbPerfil.setPreferredSize( new Dimension(320,25) );
      
      //***Botão Pesquisar*****
      btnPesquisar  = new JButton("Pequisar");
      btnPesquisar.setBackground(new Color(32,178,170));
      btnPesquisar.setForeground(Color.WHITE); 
      btnPesquisar.setBorderPainted( false );
      btnPesquisar.setPreferredSize( new Dimension(90,25) );
     
    //*************Bloco Principal*****************
     
     // Divisao da tela em duas Linhhas
      pnlCentro = new JPanel(new GridLayout(2,0,2,2));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new FlowLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
               
    //*******divisao em 3 Colonas no Bloco1
      JPanel meio = new JPanel(new GridLayout(0,3,2,2));
      
      JPanel m1 = new JPanel(new BorderLayout());
      JPanel m2 = new JPanel(new BorderLayout());
      JPanel m3 = new JPanel(new BorderLayout());
   
      pnlBloco1.add(meio);
   
      meio.add(m1);
      meio.add(m2);
      meio.add(m3);
      
    
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
      
      m1.add(linhaBloco1); 
     
      linhaBloco1.add(lb1);
      linhaBloco1.add(lb2);
      linhaBloco1.add(lb3);
      linhaBloco1.add(lb4);
      linhaBloco1.add(lb5);
      linhaBloco1.add(lb6);
      linhaBloco1.add(lb7);
      linhaBloco1.add(lb8);
      linhaBloco1.add(lb9);
     
      lb8.add(lblFiltrosDePesquisa);
      lb9.add(cbPerfil);  
      
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
   
      l4.add(lblSistemaDeSugestao);
      l6.add(lblGerenciarUsuario);
      l9.add(txtPesquisarUsuario,BorderLayout.SOUTH);
      l9.add(btnPesquisar);
       
              
       //******* divisao de 9 linhas no m3 --Terceiro Bloco--
   
      JPanel parte3 = new JPanel(new GridLayout(9,0,2,2));
      JPanel p1 = new JPanel(new BorderLayout());
      JPanel p2 = new JPanel(new FlowLayout());
      JPanel p3 = new JPanel(new FlowLayout());
      JPanel p4 = new JPanel(new BorderLayout());
      JPanel p5 = new JPanel(new FlowLayout());
      JPanel p6 = new JPanel(new FlowLayout());
      JPanel p7 = new JPanel(new BorderLayout());
      JPanel p8 = new JPanel(new FlowLayout());
      JPanel p9 = new JPanel(new FlowLayout());
    
      m3.add(parte3);
      
      parte3.add(p1);
      parte3.add(p2);
      parte3.add(p3);
      parte3.add(p4);
      parte3.add(p5);
      parte3.add(p6);
      parte3.add(p7);
      parte3.add(p8);
      parte3.add(p9);
                        
     //******Adionar a cor
     
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
      
      p1.setBackground(Color.WHITE);
      p2.setBackground(Color.WHITE);
      p3.setBackground(Color.WHITE);
      p4.setBackground(Color.WHITE);
      p5.setBackground(Color.WHITE);
      p6.setBackground(Color.WHITE);
      p7.setBackground(Color.WHITE);
      p8.setBackground(Color.WHITE);
      p9.setBackground(Color.WHITE);
      pnlBloco2.setBackground(Color.WHITE);
      pnlBloco1.setBackground(Color.WHITE);
      pnlCentro.setBackground(Color.WHITE);
      m1.setBackground(Color.WHITE);
      m2.setBackground(Color.WHITE);
      m3.setBackground(Color.WHITE);
   }
   
   public JPanel getCentro(){
      return this.pnlCentro;
   }
}
