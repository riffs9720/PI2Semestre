package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AvaliarView extends JFrame{
   private JLabel  lblSistemaDeSugestao,lblNome, lblDepartamento, lblSugestao;
   private JTextField txtNome, txtDepartamento;
   private JTextArea txtrAvaliacao, txtrSugestao,lblAvaliar;
   private JButton btnAprovar, btnReprovar;
   private String suaString = "exemplo sujestao";

   public AvaliarView(ActionListener controller){
    //**** Label--- Sistema Sugestão
      lblSistemaDeSugestao = new JLabel("Sistema De Sugestão");
      lblSistemaDeSugestao.setFont(new Font("Arial", Font.BOLD , 26));
      lblSistemaDeSugestao.setForeground(new Color(32,178,170));
      
      //**** Label ---  Avaliar
      //lblAvaliar  = new JLabel("Avaliar");
      lblAvaliar  = new JTextArea("Avaliar");
      lblAvaliar.setEditable(false);

      lblAvaliar.setFont(new Font("Arial", Font.BOLD,20));
      lblAvaliar.setForeground(new Color(32,178,170));
      
       //***Label --- Nome
      lblNome = new JLabel("Nome");
      lblNome.setFont(new Font("Sans serif", Font.BOLD, 12));
      
        //***Label --- Departamento
      lblDepartamento = new JLabel("Área");
      lblDepartamento.setPreferredSize( new Dimension(200,25) );
      lblDepartamento.setFont(new Font("Sans serif", Font.BOLD, 12));
      
         //***Label ---Sugestão
      lblSugestao = new JLabel("Sugestão");
      lblSugestao.setFont(new Font("Sans serif", Font.BOLD, 12));
      
       //***TextField Nome ****
      txtNome = new JTextField("João");
      txtNome .setPreferredSize( new Dimension(400,25) );
      txtNome.setFont(new Font("Arial", Font.ITALIC, 15)); 
      txtNome.setEditable(false);
      txtNome.setBorder(null);
      txtNome.setBackground(Color.WHITE);
             
       //***TextField Departamento ****
      txtDepartamento = new JTextField("14/05/2015");
      txtDepartamento .setPreferredSize( new Dimension(400,25) );
      txtDepartamento.setFont(new Font("Arial", Font.ITALIC, 15));
      txtDepartamento .setPreferredSize( new Dimension(400,25) ); 
      txtDepartamento.setEditable(false);
      txtDepartamento.setBorder(null);
      txtDepartamento.setBackground(Color.WHITE);
      
       //***JTextArea Sugestao ****
      txtrSugestao = new JTextArea();
      txtrSugestao .setPreferredSize( new Dimension(452,200) );
      txtrSugestao.setText(suaString);
      txtrSugestao.setEditable(false);
      txtrSugestao.setLineWrap(true);
            
      JScrollPane barraSugestao = new JScrollPane( txtrSugestao ); 
      barraSugestao.setPreferredSize(new Dimension(450,70));
      
      //** TextArea --- Avaliação
      txtrAvaliacao  = new JTextArea("Descrição da Avaliação");
      txtrAvaliacao .setPreferredSize( new Dimension(452,200) );
      txtrAvaliacao.setEditable(true);
      txtrAvaliacao.setLineWrap(true);
            
      JScrollPane barra = new JScrollPane( txtrAvaliacao ); 
      barra.setPreferredSize(new Dimension(450,70));
         
       //***Botão Aprovar*****
      btnAprovar  = new JButton("Aprovar");
      btnAprovar.setBackground(new Color(32,178,170));
      btnAprovar.setForeground(Color.WHITE); 
      btnAprovar.setBorderPainted( false );
      btnAprovar.setPreferredSize( new Dimension(90,25) );
      
        //***Botão Cancelar*****
      btnReprovar = new JButton("Reprovar");
      btnReprovar.setBackground(new Color(255,0,0));
      btnReprovar.setForeground(Color.WHITE); 
      btnReprovar.setBorderPainted( false );
      btnReprovar.setPreferredSize( new Dimension(90,25) );
   
   
      btnAprovar.addActionListener(controller);
      btnReprovar.addActionListener(controller);
      
    // Divisao da tela em dos blocos horizontais
      JPanel pnlPrincipal = new JPanel(new GridLayout(2,0,2,2));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new BorderLayout());
      pnlPrincipal.add(pnlBloco1);
      pnlPrincipal.add(pnlBloco2);
      add(pnlPrincipal);
      
       // Divisao da tela em dos blocos horizontais
      JPanel pnlDivisao = new JPanel(new GridLayout(0,3,2,2)); 
      JPanel pnlParte1 = new JPanel(new BorderLayout());
      JPanel pnlParte2 = new JPanel(new BorderLayout());
      JPanel pnlParte3 = new JPanel(new BorderLayout());
         
      pnlBloco1.add(pnlDivisao);
      pnlDivisao.add(pnlParte1);
      pnlDivisao.add(pnlParte2);
      pnlDivisao.add(pnlParte3);
   
       //*******Adicionando 9 linhas no pnlParte1
      JPanel linhasParte1 = new JPanel(new GridLayout(9,0,2,2));
      JPanel lp1 = new JPanel(new BorderLayout());
      JPanel lp2 = new JPanel(new FlowLayout());
      JPanel lp3 = new JPanel(new BorderLayout());
      JPanel lp4 = new JPanel(new FlowLayout());
      JPanel lp5 = new JPanel(new FlowLayout());
      JPanel lp6 = new JPanel(new FlowLayout());
      JPanel lp7 = new JPanel(new FlowLayout());
      JPanel lp8 = new JPanel(new BorderLayout());
      JPanel lp9 = new JPanel(new BorderLayout());
      
      pnlParte2.add(linhasParte1);
      linhasParte1.add(lp1);
      linhasParte1.add(lp2);
      linhasParte1.add(lp3);
      linhasParte1.add(lp4);
      linhasParte1.add(lp5);
      linhasParte1.add(lp6);
      linhasParte1.add(lp7);
      linhasParte1.add(lp8);
      linhasParte1.add(lp9);  
   
      pnlBloco1.add(pnlDivisao);
    
     //***Divisão em três partes Verticais no pnlBloco2
      JPanel pnlDivisao2 = new JPanel(new GridLayout(0,3,2,2));
      JPanel divisaoParte1 = new JPanel(new BorderLayout());
      JPanel divisaoParte2 = new JPanel(new BorderLayout());
      JPanel divisaoParte3 = new JPanel(new BorderLayout());
   
      pnlBloco2.add(pnlDivisao2);       
      pnlDivisao2.add(divisaoParte1);
      pnlDivisao2.add(divisaoParte2);
      pnlDivisao2.add(divisaoParte3);
      
       //***Divisão em duas partes horizontais no divisaoParte2   
      JPanel linhasParte2 = new JPanel(new GridLayout(2,0,2,2));
      JPanel ln1 = new JPanel(new BorderLayout());
      JPanel ln2 = new JPanel(new FlowLayout());
      divisaoParte2.add(linhasParte2);        
      linhasParte2.add(ln1);
      linhasParte2.add(ln2);
      
         //******Adicionando a cor     
      //pnlPrincipal.setBackground(Color.WHITE);
      pnlParte1.setBackground(Color.WHITE);
      pnlParte3.setBackground(Color.WHITE);
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
     
      //pnlBloco1.setBackground(Color.WHITE);
      //pnlBloco2.setBackground(Color.WHITE);
      divisaoParte1.setBackground(Color.WHITE);
      divisaoParte2.setBackground(Color.WHITE);
      divisaoParte3.setBackground(Color.WHITE);
      linhasParte1.setBackground(Color.WHITE);
      linhasParte2.setBackground(Color.WHITE);
      
      // **** Adicionando Componentes
   
      lp4.add(lblSistemaDeSugestao);
      lp6.add(lblAvaliar);
      lp8.add(lblNome);
      lp8.add(txtNome,BorderLayout.EAST);
      lp9.add(lblDepartamento);
      lp9.add(txtDepartamento,BorderLayout.EAST);
      ln1.add(lblSugestao,BorderLayout.NORTH);
      ln1.add(barraSugestao ,BorderLayout.EAST);
      ln2.add(barra);
      ln2.add(btnReprovar);
      ln2.add(btnAprovar);
   
      
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      //setSize(550, 700);  //Difinindo o tamanho do Frame
    //  setResizable(false); //Travando o tamanho da tela

      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLocationRelativeTo(null);
       
      setVisible(true);
   }
    
   public JTextField getNome(){
      return txtNome;
   }
   
   public void setNome(String nome){
      this.txtNome.setText(nome);
   }
   
   public JTextField getDepartamento(){
      return txtDepartamento;
   }
   
   public void setDepartamento(String departamento){
      this.txtDepartamento.setText(departamento);
   }
  
   public JTextArea getSugestao(){
      return txtrSugestao;
   }
   
   public void setSugestao(String sugestao){
      this.txtrSugestao.setText(sugestao);
   }
   
   public JTextArea getAvaliacao(){
      return txtrAvaliacao;
   }
   
   public JButton getAprovar(){
      return btnAprovar;
   }
   
   public JButton getReprovar(){
      return btnReprovar;
   }
   
   public void close(){
      super.dispose();
   }
}