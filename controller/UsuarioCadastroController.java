package controller;

import javax.swing.JOptionPane;
import java.awt.event.*;
import java.security.*;

import model.UsuarioCadastro;
import model.UsuarioAcesso;
import view.UsuarioCadastroView;
import controller.MenuPrincipalController;
import java.io.*;
import java.sql.*;

public class UsuarioCadastroController implements ActionListener{
   private UsuarioCadastro model;
   private UsuarioCadastroView view;
   
   public UsuarioCadastroController(){
      view = new UsuarioCadastroView(this);
      model = new UsuarioCadastro();
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == view.getCadastrar()){
         //validar e cadastar
         if(view.getTNome().isEmpty() || view.getTCpf().isEmpty() || view.getTDtNascimento().isEmpty() || view.getTEndereco().isEmpty() || view.getTNumeroIdentificacao().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente.");     
         }
         else{
            model.setNome(view.getTNome());
            model.setCpf(view.getTCpf());
            model.setDtNascimento(view.getTDtNascimento());
            if(view.getTGenero() == "F"){
                model.setGenero("F");
            }else{
               model.setGenero("M");
            }
            model.setEndereco(view.getTEndereco());
            model.setIdTipoIdentificacao(view.getTTipoIdentificacao());
            model.setNumeroIdentificacao(Integer.parseInt(view.getTNumeroIdentificacao()));
            if(view.getTNumeroIdentificacao().startsWith("8")){
               model.setIdTipoIdentificacao(1);   
            }else{
               model.setIdTipoIdentificacao(2);
            }
           
            //retornar o last insert id
            int insertId = model.insert();
          
            String hash = model.getMD5(view.getPSenha());
            
            UsuarioAcesso usuarioAcesso = new UsuarioAcesso();
            usuarioAcesso.setIdUsuarioCadastro(insertId);
            usuarioAcesso.setEmail(view.getTEmail());
            usuarioAcesso.setSenha(hash);
            UsuarioAcesso idUsuarioAcesso = usuarioAcesso.insert();
            
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso! :D");
            
            view.close();
            
            new LoginController();
         }
      }
      else if(e.getSource() == view.getLimpar()){
         view.setTNome("");
         view.setTCpf("");
         view.setTDtNascimento("");
         view.setTEndereco("");
         view.setTNumeroIdentificacao("");
         view.setTEmail("");
         view.setPSenha("");
      }
   }
}