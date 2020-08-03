package view;

import controller.DepartamentoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NovaSugestaoView extends JFrame{
   private JLabel  lblSistemaDeSugestao, lblNovaSugestao, lblDepartamento, lblFrase, lblTipoSugestao;
   private JComboBox cbTipoDeSugestao, cbCategoria;
   private JTextField txtSuasugestao;
   private JButton btnEnviar;
   private JPanel pnlCentro;
   
   public NovaSugestaoView(ActionListener controller){
      super("Sistema De Sugestao");
   
    //**** Label--- Alterar cor e fonte do Sistema Sugestão
      lblSistemaDeSugestao = new JLabel("Sistema De Sugestão");
      lblSistemaDeSugestao.setFont(new Font("Arial", Font.BOLD , 26));
      lblSistemaDeSugestao.setForeground(new Color(32,178,170));
      
      
   //***Label -----Alterar a fonte -- Filtro de Pesquisa
      lblDepartamento = new JLabel("Departamento");
      lblDepartamento.setFont(new Font("Sans serif", Font.ITALIC, 11));
 
  //***Label -----Alterar a fonte -- Filtro de Pesquisa
      lblTipoSugestao = new JLabel("Tipo de sugestão");
      lblTipoSugestao.setFont(new Font("Sans serif", Font.ITALIC, 11));
   
    //**** Label --- Alterar cor e fonte do Nova Sugestão
      lblNovaSugestao = new JLabel("Nova Sugestão");
      lblNovaSugestao.setFont(new Font("Arial", Font.BOLD,20));
      lblNovaSugestao.setForeground(new Color(32,178,170));
      
      //*** Label frase
      lblFrase = new JLabel("Preencha todos os campos corretamente.");
      lblFrase.setFont(new Font("Sans serif", Font.ITALIC, 12));
      
      
       //***ComboBox Tipo de Sugestao****
      String[] arrayTiposugestao = {"Elogio","Reclamação","Melhoria"};
      cbTipoDeSugestao = new JComboBox(arrayTiposugestao);
      cbTipoDeSugestao.setPreferredSize( new Dimension(400,20) );
      

       //***ComboBox Categoria****
      //String[] arrayCategoria= {"Categoria","Segundo ","Terceiro ","Quarto"};
      //cbCategoria = new JComboBox(arrayCategoria);
      
      DepartamentoController departamentoController = new DepartamentoController();
      cbCategoria = new JComboBox(departamentoController.getLista());           
      cbCategoria.setPreferredSize(new Dimension(450,20));
       
        //****Alterar o TextField
      txtSuasugestao = new JTextField("Sua Sugestão");
      txtSuasugestao.setPreferredSize( new Dimension(456,140) );
    
      btnEnviar  = new JButton("Enviar");
      btnEnviar.setBackground(new Color(32,178,170));
      btnEnviar.setForeground(Color.WHITE); 
      btnEnviar.setBorderPainted( false );
      btnEnviar.setPreferredSize( new Dimension(90,25) );
      
      
      // Divisao da tela em dos blocos horizontais
      pnlCentro = new JPanel(new GridLayout(2,0));      
      JPanel pnlBloco1 = new JPanel(new BorderLayout());
      JPanel pnlBloco2 = new JPanel(new BorderLayout());
      pnlCentro.add(pnlBloco1);
      pnlCentro.add(pnlBloco2);
//      add(pnlPrincipal);
      
      //*******divisao em 3 Colonas no pnlBloco1
      JPanel pnlDivisao = new JPanel(new GridLayout(0,3));
      JPanel pnlParte1 = new JPanel(new BorderLayout());
      JPanel pnlParte2 = new JPanel(new BorderLayout());
      JPanel pnlParte3 = new JPanel(new BorderLayout());
   
      pnlBloco1.add(pnlDivisao);
      pnlDivisao.add(pnlParte1);
      pnlDivisao.add(pnlParte2);
      pnlDivisao.add(pnlParte3);
   
      
      //*******Adicionando 9 linhas no pnlParte1
      JPanel linhasParte1 = new JPanel(new GridLayout(9,0));
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
   
      
    //***Divisão em três partes Verticais no pnlBloco2
      JPanel pnlDivisao2 = new JPanel(new GridLayout(0,3));
      JPanel divisaoParte1 = new JPanel(new BorderLayout());
      JPanel divisaoParte2 = new JPanel(new BorderLayout());
      JPanel divisaoParte3 = new JPanel(new BorderLayout());
   
      pnlBloco2.add(pnlDivisao2);       
      pnlDivisao2.add(divisaoParte1);
      pnlDivisao2.add(divisaoParte2);
      pnlDivisao2.add(divisaoParte3);
      
       
       //***Divisão em duas partes horizontais no divisaoParte2         
      JPanel linhasParte2 = new JPanel(new GridLayout(2,0));
      JPanel ln1 = new JPanel(new BorderLayout());
      JPanel ln2 = new JPanel(new FlowLayout());
      
      divisaoParte2.add(linhasParte2);
      linhasParte2.add(ln1);
      linhasParte2.add(ln2);
              
      
        
        
      //******Adicionando a cor         
      pnlParte1.setBackground(Color.WHITE);
      pnlParte2.setBackground(Color.WHITE);
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
      pnlBloco2.setBackground(Color.WHITE);
      divisaoParte1.setBackground(Color.WHITE);
      divisaoParte2.setBackground(Color.WHITE);
      divisaoParte3.setBackground(Color.WHITE);
      pnlCentro.setBackground(Color.WHITE);
      
      
   // **** Adicionando Componentes
      lp4.add(lblSistemaDeSugestao);
      lp6.add(lblNovaSugestao);
      lp7.add(lblFrase,BorderLayout.SOUTH );
      lp9.add(cbTipoDeSugestao,BorderLayout.NORTH);
      lp8.add(lblTipoSugestao, BorderLayout.SOUTH);
      ln1.add(cbCategoria,BorderLayout.NORTH);
      lp9.add(lblDepartamento, BorderLayout.SOUTH);
      ln1.add(txtSuasugestao,BorderLayout.SOUTH);
      ln2.add(btnEnviar);
      
      btnEnviar.addActionListener(controller);
   }
   
   public void setTSugestao(String msg){
      this.txtSuasugestao.setText(msg);
   }
   
   public String getTSugestao(){
      return txtSuasugestao.getText();
   }
   
   public String getTTipoSugestao(){
      String value = (String)cbTipoDeSugestao.getSelectedItem();
      return value;
   }
   
   public int getTDepartamento(){
      int value = cbCategoria.getSelectedIndex() + 1;
      return value;
   }
   
   public JPanel getCentro(){
      return this.pnlCentro;
   }
   
   public void close(){
      super.dispose();
   }
   
   public JButton getEnviar(){
      return this.btnEnviar;
   }
}