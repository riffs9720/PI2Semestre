package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.UsuarioAcesso;

import controller.UsuarioCadastroController;

import view.UsuarioCadastroView;
import view.LoginView;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginController implements ActionListener{

   private UsuarioAcesso model;
   private LoginView view;
   
   public LoginController(){
      model = new UsuarioAcesso();
      view = new LoginView(this);
   }
   
   public void actionPerformed(ActionEvent e){
       if(e.getSource() == view.getEntrar()){
         //validar e cadastar
         if(view.getTEmail().isEmpty() || view.getPSenha().isEmpty() ){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            model.setEmail(view.getTEmail());
            model.setSenha(view.getPSenha());
                       
            //retornar o last insert id
            UsuarioAcesso validate = model.selectByEmail();
            String hash = model.getMD5(view.getPSenha());
            
            if(validate.getSenha().equals(hash)){    
               UsuarioAcesso usuarioAcesso = new UsuarioAcesso();
               usuarioAcesso.setIdUsuarioAcesso(validate.getIdUsuarioAcesso());
               usuarioAcesso.setIdUsuarioCadastro(validate.getIdUsuarioCadastro());
               usuarioAcesso.setEmail(validate.getEmail());
               usuarioAcesso.setSenha(validate.getSenha());
               view.closeFrame();
               new MenuPrincipalController(usuarioAcesso);
            }else{
               System.out.println(validate.getSenha());
               System.out.println(hash);
               JOptionPane.showMessageDialog(null, "Email e/ou senha inválido(s) :(");
            }
         }
      }else if(e.getSource() == view.getCadastrar()){
         view.closeFrame(); 
         UsuarioCadastroController cadastroController = new UsuarioCadastroController();        
      }else if(e.getSource() == view.getRecuperarSenha()){
      
      }
   }
   

}