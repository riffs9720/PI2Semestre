package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView extends JFrame{

   private JTextField txtEmail;
   private JPasswordField txtSenha;
   private JLabel lblEmail, lblSenha, lblCadastrar, lblDuvidas;
   private JButton btnEntrar, btnRecuperarSenha, btnCadastrar, btnDuvidas;
   
   public LoginView(ActionListener controller){
      super("Sistema de Sugestões - Login"); //Definindo nome da tela
      Container login = getContentPane();
      login.setLayout(new FlowLayout()); 
      
      //Declarando os labels, textfields e botões
     
      //Usuário
      lblEmail = new JLabel ("Email: ");
      login.add(lblEmail); 
       
      txtEmail = new JTextField(20); 
      login.add(txtEmail);
      
      //Senha
      lblSenha = new JLabel ("Senha: ");
      login.add(lblSenha);
      
      txtSenha = new JPasswordField(20);
      login.add(txtSenha);
      
      //Recuperar Senha
      btnRecuperarSenha = new JButton("Esqueci minha senha");
      btnRecuperarSenha.setBackground(new Color(60, 179, 113));
		btnRecuperarSenha.setForeground(Color.WHITE);
      login.add(btnRecuperarSenha);
      btnRecuperarSenha.addActionListener(controller);
      
      //Botão Entrar    
      btnEntrar = new JButton ("Entrar");
      btnEntrar.setBackground(new Color(60, 179, 113));
		btnEntrar.setForeground(Color.WHITE);
      login.add(btnEntrar);
      btnEntrar.addActionListener(controller);
      
      //Cadastro
      lblCadastrar = new JLabel("Ainda não possui cadastro?");
      login.add(lblCadastrar);
      
      btnCadastrar = new JButton("Cadastre-se");
      btnCadastrar.setBackground(new Color(60, 179, 113));
		btnCadastrar.setForeground(Color.WHITE);
      login.add(btnCadastrar);
      btnCadastrar.addActionListener(controller);
      
      //Dúvidas
      lblDuvidas = new JLabel("Alguma Dúvida? Entre em contato conosco");
      login.add(lblDuvidas);
      
      btnDuvidas = new JButton ("Clique Aqui");
      btnDuvidas.setBackground(new Color(60, 179, 113));
		btnDuvidas.setForeground(Color.WHITE);
      login.add(btnDuvidas);
      btnDuvidas.addActionListener(controller);
      
      //Ajustes finais
      login.setBackground(Color.white); //Aplicando cor de fundo
      setSize(270, 270);  //Difinindo o tamanho do Frame
      setResizable(false); //Travando o tamanho da tela
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
   public void setTEmail(String email){
      txtEmail.setText(email);
   }
    
   public String getTEmail(){
      return txtEmail.getText();
   }
    
   public void setPSenha(String senha){
      txtSenha.setText(senha);
   }
     
   public String getPSenha(){
      return txtSenha.getText();
   }
   
   public JButton getCadastrar(){
      return btnCadastrar;
   }
    
   public JButton getEntrar(){
      return btnEntrar;
   }
   
   public JButton getRecuperarSenha(){
      return btnRecuperarSenha;
   }
   
   public void closeFrame(){
      super.dispose();
   }
}