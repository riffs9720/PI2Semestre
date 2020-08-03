package controller;

import model.UsuarioAcesso;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

//import model.Mural;
import view.Mural;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MuralController implements ActionListener{

//   private Sugestao model;
   private Mural view;
   private UsuarioAcesso usuarioAcesso;
   
   public MuralController(){
      view = new Mural(this);
   }
   
   public MuralController(UsuarioAcesso usuarioAcesso){
   //      model = new Mural();
      view = new Mural(this);
      this.usuarioAcesso = usuarioAcesso;
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == view.getBtnNovaSugestao()){  
      JOptionPane.showMessageDialog(null, "Clicou");
         //SugestaoController sugestao = new SugestaoController();
         
         /*MenuPrincipalController mpc = new MenuPrincipalController();
         
          JFrame frame = mpc.getFramePrincipal();
          
          frame.remove(mpc.painelAtual());
          frame.add(sugestao.getView());
          view.setPainelAtual(sugestao.getView());
 
          frame.validate();    
          frame.repaint();*/
      }else if(1==1){
         
      }
   }
   
   public JPanel getView(){
      return view.getCentro();
   }
   
}