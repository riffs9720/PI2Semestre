package controller;

import view.MenuPrincipal;

import controller.SugestaoController;
import controller.AvaliacaoController;
import view.NovaSugestaoView;
import model.UsuarioAcesso;
//import controller.MuralController;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuPrincipalController implements ActionListener{
   
   private MenuPrincipal view;
   private JFrame frame;
   private UsuarioAcesso usuarioAcesso;
   
   public MenuPrincipalController(UsuarioAcesso usuarioAcesso){
      view = new MenuPrincipal(this, usuarioAcesso);
      this.usuarioAcesso = usuarioAcesso;
   }
      
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == view.getSair()){
         view.close();
      }else if(e.getSource() == view.getNovaSugestao()){
         SugestaoController sugestao = new SugestaoController(usuarioAcesso);
         frame = view.getFrame();
        
         frame.remove(view.painelAtual());
         frame.add(sugestao.getView());
         view.setPainelAtual(sugestao.getView());
        
         frame.validate();    
         frame.repaint();
      }else if(e.getSource() == view.getMural()){
         MuralController mural = new MuralController(usuarioAcesso);
         JFrame frame = view.getFrame();
         
         frame.remove(view.painelAtual());
         frame.add(mural.getView());
         view.setPainelAtual(mural.getView());
         
         frame.validate();    
         frame.repaint();
      }else if(e.getSource() == view.getMinhasSugestoes()){
         MinhaSugestaoController minhaSugestao = new MinhaSugestaoController(usuarioAcesso);
         JFrame frame = view.getFrame();
         
         frame.remove(view.painelAtual());
         frame.add(minhaSugestao.getView());
         view.setPainelAtual(minhaSugestao.getView());
         
         frame.validate();    
         frame.repaint();
      }else if(e.getSource() == view.getNovaAvaliacao()){
         AvaliacaoController avaliacao = new AvaliacaoController(usuarioAcesso);
         JFrame frame = view.getFrame();
         
         frame.remove(view.painelAtual());
         frame.add(avaliacao.getView());
         view.setPainelAtual(avaliacao.getView());
         
         frame.validate();    
         frame.repaint();
      }
   }
   
   public JFrame getFramePrincipal(){
      return this.frame;
   }
   
   public UsuarioAcesso getUsuarioAcesso(){
      return this.usuarioAcesso;
   }
}