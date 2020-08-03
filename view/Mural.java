package view;

import controller.SugestaoController;
import controller.DepartamentoController;
import controller.FiltroController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Mural extends JFrame{
   private JLabel  lblSistemaDeSugestao, lblFiltrosDePesquisa;
   private JComboBox cbCategoria,cbRanking;
   private JButton btnPesquisar, btnNovaSugestao;
   private String  frase =  "Tem algo a dizer? Faça um nova sugestão e nos ajude a melhorar nossos serviços para você";
   private JTextArea txtAFrase;
   private JPanel pnlCentro, painelAtual;
   //Criação da JTable
  /* private String [] colunas = {"Mural"};
   private Object [][] dados = {
                                {"1"},
                                {"3"},
                                {"5"},
                                {"6"},
                                {"7"},
                                {"8", "Limpeza", "Pendente", "15/10/2016"}};*/  
   private String[][] dados;                                                     
   private String[] colunas = {"Usuario", "Conteudo", "Departamento", "Data"};
   private JTable tabela; 
   private JScrollPane barraRolagem;
  
   public Mural(ActionListener controller){
   
       //**** Label--- Alterar cor e fonte do Sistema Sugestão
      lblSistemaDeSugestao = new JLabel("Bem-vindo ao Sistema De Sugestão");
      lblSistemaDeSugestao.setFont(new Font("Arial", Font.BOLD , 26));
      lblSistemaDeSugestao.setForeground(new Color(32,178,170));
      
      
      //**** Label --- Alterar cor e fonte Frase
      JTextArea txtAFrase  = new JTextArea("Tem algo a dizer? Faça uma \nnova sugestão e nos ajude a \nmelhorar nossos serviços\n  para você");
      txtAFrase.setEditable(false);
      //txtAFrase.setLineWrap(true);
      //txtAFrase.setPreferredSize(new Dimension(250,100));
      
      txtAFrase.setFont(new Font("Arial", Font.BOLD,20));
      txtAFrase.setForeground(Color.BLACK);
              
      
      //***Label -----Alterar a fonte -- Filtro de Pesquisa
      lblFiltrosDePesquisa = new JLabel("Filtros de Pesquisa");
      lblFiltrosDePesquisa.setFont(new Font("Sans serif", Font.ITALIC, 15));
   
   
     //***Botão Pesquisar*****
      btnPesquisar  = new JButton("Pequisar");
      btnPesquisar.setBackground(new Color(32,178,170));
      btnPesquisar.setForeground(Color.WHITE); 
      btnPesquisar.setBorderPainted( false );
      btnPesquisar.setPreferredSize( new Dimension(100,30) );
      
      //***Botão Nova Sugestão*****
      btnNovaSugestao  = new JButton("Nova sugestão");
      btnNovaSugestao.setBackground(new Color(32,178,170));
      btnNovaSugestao.setForeground(Color.WHITE); 
      btnNovaSugestao.setBorderPainted( false );
      btnNovaSugestao.setPreferredSize( new Dimension(120,30) );

      
      //***ComboBox Categoria ****
      DepartamentoController departamentoController = new DepartamentoController();
      cbRanking = new JComboBox(departamentoController.getLista());
      cbRanking.setPreferredSize( new Dimension(300,25) );
      
       //***ComboBox Ranking ****
      String[] arrayFiltro = {"Departamento","Rancking"};
      cbCategoria = new JComboBox(arrayFiltro);
      cbCategoria.setPreferredSize( new Dimension(300,25) );
      
        //***** Dimensões Tabela
      
      SugestaoController sugestao = new SugestaoController();
      dados = sugestao.getSugestoesFinalizadas();
      
      tabela = new JTable(dados,colunas);
      barraRolagem = new JScrollPane(tabela);
      tabela.setEnabled(false);
      
      barraRolagem.setPreferredSize(new Dimension(550, 250));
      tabela.setRowHeight(50); 
     
   
      pnlCentro = new JPanel(new GridLayout(2,0,2,2));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new BorderLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
      
      JPanel meio = new JPanel(new GridLayout(0,3));
      
      JPanel m1 = new JPanel(new BorderLayout());
      JPanel m2 = new JPanel(new BorderLayout());
      JPanel m3 = new JPanel(new BorderLayout());
             
      pnlBloco1.add(meio);
   
      meio.add(m1);
      meio.add(m2);
      meio.add(m3);
      
      add(pnlCentro);
      
     //******* divisao de 9 linhas --m1 --Primeiro Bloco--
   
      
      JPanel linhaBloco1 = new JPanel(new GridLayout(9,0));
      JPanel lb1 = new JPanel(new BorderLayout());
      JPanel lb2 = new JPanel(new FlowLayout());
      JPanel lb3 = new JPanel(new FlowLayout());
      JPanel lb4 = new JPanel(new BorderLayout());
      JPanel lb5 = new JPanel(new FlowLayout());
      JPanel lb6 = new JPanel(new FlowLayout());
      JPanel lb7 = new JPanel(new FlowLayout());
      JPanel lb8 = new JPanel(new FlowLayout());
      JPanel lb9 = new JPanel(new FlowLayout());
      
      
      
   //******* divisao de 9 linhas no m2 --Segundo Bloco--
      
      JPanel linhaCentro = new JPanel(new GridLayout(9,0));
      JPanel l1 = new JPanel(new BorderLayout());
      JPanel l2 = new JPanel(new FlowLayout());
      JPanel l3 = new JPanel(new BorderLayout());
      JPanel l4 = new JPanel(new FlowLayout());
      JPanel l5 = new JPanel(new FlowLayout());
      JPanel l6 = new JPanel(new FlowLayout());
      JPanel l7 = new JPanel(new FlowLayout());
      JPanel l8 = new JPanel(new FlowLayout());
      JPanel l9 = new JPanel(new FlowLayout());
   
      
      JPanel meioB2 = new JPanel(new GridLayout(0,2));
      
      JPanel mb2P = new JPanel(new FlowLayout());
      JPanel mb2S = new JPanel(new FlowLayout());
     
   
      pnlBloco2.add(meioB2);
      meioB2.add(mb2P);
      meioB2.add(mb2S);
     
      JPanel lBlocoM2 = new JPanel(new GridLayout(2,0));
      JPanel lbm1 = new JPanel(new BorderLayout());
      JPanel lbm2 = new JPanel(new FlowLayout());
             
   
      mb2S.add(lBlocoM2);
      lBlocoM2.add(lbm1);
      lBlocoM2.add(lbm2);
            
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
              
      lb7.add(lblFiltrosDePesquisa);
      lb8.add(cbCategoria);
      l8.add(cbRanking);
      l8.add(btnPesquisar);
      
      lbm1.add(txtAFrase,BorderLayout.CENTER);
      lbm2.add(btnNovaSugestao); 
     
      mb2P.add(barraRolagem);
   
     
      linhaBloco1.setBackground(Color.WHITE); 
      linhaCentro.setBackground(Color.WHITE);
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
      meioB2.setBackground(Color.WHITE);
      lbm1.setBackground(Color.WHITE);
      lbm2.setBackground(Color.WHITE);
      mb2P.setBackground(Color.WHITE);
      mb2S.setBackground(Color.WHITE);
      
      btnNovaSugestao.addActionListener(controller);      
      painelAtual = this.getCentro();

   }
   
   public JPanel getCentro(){
      return this.pnlCentro;
   }
   
   public JButton getBtnNovaSugestao(){
      return this.btnNovaSugestao;
   }
   
    public JFrame getFrame(){
      return this;
   }
   
   public JPanel painelAtual(){
      return this.painelAtual;
   }
   
   public void setPainelAtual(JPanel painelAtual){
      this.painelAtual = painelAtual;
   }

}

