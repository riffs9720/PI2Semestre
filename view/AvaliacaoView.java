package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.*;

import model.UsuarioAcesso;

import controller.SugestaoController;
import controller.GerarPDF;

public class AvaliacaoView extends JFrame{
   private JLabel lblSistemaDeSugestao, lblAvaliacoes,lblFiltrosDePesquisa, lblDe, lblAte;
   private JTextField txtDe, txtAte;
   private JButton btnPesquisar;
   private String [] colunas = {"Usuário", "Conteúdo", "Departamento", "Data"};
   private Object [][] dados;;
   
   private JPanel pnlCentro;
                          
   private JTable tabela;
   private JScrollPane barraRolagem;
   private UsuarioAcesso usuarioAcesso;
   
   public AvaliacaoView(ActionListener controller, UsuarioAcesso usuarioAcesso, ListSelectionListener controllerListener){
      super("Sistema de Sugestão");
      
      this.usuarioAcesso = usuarioAcesso;
      
    //**** Label---  Sistema Sugestão
      lblSistemaDeSugestao = new JLabel("Sistema De Sugestão");
      lblSistemaDeSugestao.setFont(new Font("Arial", Font.BOLD , 26));
      lblSistemaDeSugestao.setForeground(new Color(32,178,170));
   
     //**** Label --- Avaliações
      lblAvaliacoes  = new JLabel("Avaliações");
      lblAvaliacoes.setFont(new Font("Arial", Font.BOLD,20));
      lblAvaliacoes.setForeground(new Color(32,178,170));
      
      //***Label --- Filtro de Pesquisa
      lblFiltrosDePesquisa = new JLabel("Filtros de Pesquisa");
      lblFiltrosDePesquisa.setFont(new Font("Sans serif", Font.ITALIC, 15)); 
      
       //***Label --- De
      lblDe = new JLabel("De");
      lblDe.setFont(new Font("Sans serif", Font.ITALIC, 10));
      
        //***Label --- Até
      lblAte = new JLabel("Até");
      lblAte.setFont(new Font("Sans serif", Font.ITALIC, 10));       
      
      
       //***TextField Ate ****
      txtAte = new JTextField("Data");
      txtAte .setPreferredSize( new Dimension(320,25) );
      
         //***TextField De ****
      txtDe = new JTextField("Data");
      txtDe .setPreferredSize( new Dimension(320,25) );
      
         //***Botão Pesquisar*****
      btnPesquisar  = new JButton("Pequisar");
      btnPesquisar.setBackground(new Color(32,178,170));
      btnPesquisar.setForeground(Color.WHITE); 
      btnPesquisar.setBorderPainted( false );
      btnPesquisar.setPreferredSize( new Dimension(90,25) );
      
      
         //***** Dimensões Tabela
   
      SugestaoController sugestao = new SugestaoController();
      dados = sugestao.getSugestoesAbertas();
      
      tabela = new JTable(dados, colunas);
      //tabela.setEnabled(false);
      tabela.getSelectionModel().addListSelectionListener(controllerListener);
      barraRolagem = new JScrollPane(tabela);
      barraRolagem.setPreferredSize(new Dimension(600,250));
      tabela.setRowHeight(50);
      
      GerarPDF gerarPDF = new GerarPDF(tabela);
      gerarPDF.print();
      
      pnlCentro = new JPanel(new GridLayout(2,0));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new FlowLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
      
       //*******divisao em 3 Colonas no pnlBloco1
      JPanel pnlDivisao = new JPanel(new GridLayout(0,3));
      JPanel pnlParte1 = new JPanel(new BorderLayout());
      JPanel pnlParte2 = new JPanel(new BorderLayout());
      JPanel pnlParte3 = new JPanel(new BorderLayout());
    
      pnlBloco1.add(pnlDivisao);
      pnlDivisao.add(pnlParte1);
      pnlDivisao.add(pnlParte2);
      pnlDivisao.add(pnlParte3);
   
   
       //******* divisao de 9 linhas --pnlParte1 --Primeiro Bloco--
   
      
      JPanel linhasParte1 = new JPanel(new GridLayout(9,0));
      JPanel lp1 = new JPanel(new BorderLayout());
      JPanel lp2 = new JPanel(new FlowLayout());
      JPanel lp3 = new JPanel(new FlowLayout());
      JPanel lp4 = new JPanel(new BorderLayout());
      JPanel lp5 = new JPanel(new FlowLayout());
      JPanel lp6 = new JPanel(new FlowLayout());
      JPanel lp7 = new JPanel(new FlowLayout());
      JPanel lp8 = new JPanel(new FlowLayout());
      JPanel lp9 = new JPanel(new FlowLayout());
      
      pnlParte1.add(linhasParte1); 
      linhasParte1.add(lp1);
      linhasParte1.add(lp2);
      linhasParte1.add(lp3);
      linhasParte1.add(lp4);
      linhasParte1.add(lp5);
      linhasParte1.add(lp6);
      linhasParte1.add(lp7);
      linhasParte1.add(lp8);
      linhasParte1.add(lp9);
   
      
      
      
   //******* Adicionando 9 linhas no pnlParte2
      JPanel linhasParte2 = new JPanel(new GridLayout(9,0));
      JPanel ln1 = new JPanel(new BorderLayout());
      JPanel ln2 = new JPanel(new FlowLayout());
      JPanel ln3 = new JPanel(new BorderLayout());
      JPanel ln4 = new JPanel(new FlowLayout());
      JPanel ln5 = new JPanel(new FlowLayout());
      JPanel ln6 = new JPanel(new FlowLayout());
      JPanel ln7 = new JPanel(new FlowLayout());
      JPanel ln8 = new JPanel(new FlowLayout());
      JPanel ln9 = new JPanel(new FlowLayout());
      
      pnlParte2.add(linhasParte2);
      linhasParte2.add(ln1);
      linhasParte2.add(ln2);
      linhasParte2.add(ln3);
      linhasParte2.add(ln4);
      linhasParte2.add(ln5);
      linhasParte2.add(ln6);
      linhasParte2.add(ln7);
      linhasParte2.add(ln8);
      linhasParte2.add(ln9); 
      
               
               
      // *** Divisão em duas partes verticais no pnlBloco2
      JPanel  pnlDivisao2 = new JPanel(new GridLayout(0,2));
      JPanel divisaoParte1 = new JPanel(new FlowLayout());
      JPanel divisaoParte2 = new JPanel(new FlowLayout());
      pnlBloco2.add( pnlDivisao2);
   
   
      pnlBloco2.add( pnlDivisao2);
      pnlDivisao2.add(divisaoParte1);
      pnlDivisao2.add(divisaoParte2);
   
      
   //***Adicionando cor
      lp1.setBackground(Color.WHITE);
      lp2.setBackground(Color.WHITE);
      lp3.setBackground(Color.WHITE);
      lp4.setBackground(Color.WHITE);
      lp5.setBackground(Color.WHITE);
      lp6.setBackground(Color.WHITE);
      lp7.setBackground(Color.WHITE);
      lp8.setBackground(Color.WHITE);
      lp9.setBackground(Color.WHITE);
      
      ln1.setBackground(Color.WHITE);
      ln2.setBackground(Color.WHITE);
      ln3.setBackground(Color.WHITE);
      ln4.setBackground(Color.WHITE);
      ln5.setBackground(Color.WHITE);
      ln6.setBackground(Color.WHITE);
      ln7.setBackground(Color.WHITE);
      ln8.setBackground(Color.WHITE);
      ln9.setBackground(Color.WHITE);
      divisaoParte1.setBackground(Color.WHITE);
      divisaoParte2.setBackground(Color.WHITE);
      linhasParte2.setBackground(Color.WHITE);
      linhasParte1.setBackground(Color.WHITE);
   
      
      pnlBloco2.setBackground(Color.WHITE);
      pnlParte3.setBackground(Color.WHITE);
      
      
      //***Adicionando componentes
      divisaoParte1.add(barraRolagem);
      ln4.add(lblSistemaDeSugestao);
      ln6.add(lblAvaliacoes);
      lp8.add(lblFiltrosDePesquisa);
      lp9.add(lblDe);
      lp9.add(txtDe);
      ln9.add(lblAte);
      ln9.add(txtAte);
      ln9.add(btnPesquisar);
   }
   
   public JPanel getCentro(){
      return pnlCentro;
   }
   
   public void close(){
      super.dispose();
   }
   
   public JTable getTable(){
      return this.tabela;
   }
}