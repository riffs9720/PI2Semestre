package view;

/* require imports*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import controller.TipoIdentificacaoController;
import model.TipoIdentificacao;
import java.util.ArrayList;
//import org.jdesktop.swingx.JXDatePicker;


/* UsuarioCadastro View*/
public class UsuarioCadastroView extends JFrame{
   private JTextField txtNome, txtCpf, txtDtNascimento, txtEmail, txtNumeroIdentificacao,txtEndereco;
   private JLabel lblNome, lblCPF, lblDtNascimento, lblEmail, lblTipoIdentificacao, lblGenero, lblEndereco, lblNumeroIdentificacao, lblSenha;
   private JLabel lblSdS;
   private JButton btnCadastrar, btnLimpar;
   private JComboBox<String> cbxTipoIdentificacao,cbxGenero;
   private JPasswordField passSenha;
   private Font fonte = new Font("Arial", Font.BOLD, 35);
    
   public UsuarioCadastroView(ActionListener controller){
      super("Sitema de Sugestões - Cadastro");
      
      JPanel caixa = new JPanel(new GridLayout(0,1));
      JPanel cadastro = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro2 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro3 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro4 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro6 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro8 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro9 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro10 = new JPanel (new FlowLayout(FlowLayout.LEFT));
      JPanel cadastro11 = new JPanel (new FlowLayout());
      JPanel cadastro12 = new JPanel(new FlowLayout());
       
      Container painel = getContentPane();
      painel.setLayout(new BorderLayout());   
      
      painel.add(caixa, BorderLayout.CENTER);
      painel.add(cadastro12, BorderLayout.NORTH);
      
      caixa.add(cadastro);
      caixa.add(cadastro2); 
      caixa.add(cadastro3); 
      caixa.add(cadastro4); 
     // caixa.add(cadastro5); 
      caixa.add(cadastro6); 
      //caixa.add(cadastro7); 
      caixa.add(cadastro8); 
      caixa.add(cadastro9); 
      caixa.add(cadastro10); 
      caixa.add(cadastro11);      
   
      //Sistema de Sugestões
      lblSdS =  new JLabel ("Cadastro");
      lblSdS.setFont(fonte);
      lblSdS.setForeground(new Color(60, 179, 113));
      cadastro12.add(lblSdS);
              
      //Nome
      lblNome = new JLabel ("Nome: ");
      cadastro.add(lblNome);
      
      txtNome = new JTextField(26);
      cadastro.add(txtNome);
      
      //CPF
      lblCPF = new JLabel ("CPF: ");
      cadastro2.add(lblCPF);
      
      txtCpf = new JTextField(10);
      cadastro2.add(txtCpf);
      
      //Data de Nascimento
      lblDtNascimento =  new JLabel("Data de Nascimento: ");
      cadastro4.add(lblDtNascimento);
      
      txtDtNascimento = new JTextField(7);
      cadastro4.add(txtDtNascimento);
      
      //Sexo
      lblGenero = new JLabel ("Sexo: ");
      cadastro4.add(lblGenero);
   
      String[] arraySexo = {"F", "M"};
      cbxGenero = new JComboBox(arraySexo);
      cadastro4.add(cbxGenero);
            
       //Tipo de identificacao (ra/rf)
      lblTipoIdentificacao = new JLabel ("Tipo de Registro:");
      cadastro6.add(lblTipoIdentificacao);
      
      TipoIdentificacaoController tipoIdentificacaoController = new TipoIdentificacaoController();
      cbxTipoIdentificacao = new JComboBox(tipoIdentificacaoController.getLista());    
      cadastro6.add(cbxTipoIdentificacao);
      
      //Número de Registro
      lblNumeroIdentificacao = new JLabel("Número de Registro: ");
      cadastro8.add(lblNumeroIdentificacao);
      
      txtNumeroIdentificacao = new JTextField(15);
      cadastro8.add(txtNumeroIdentificacao);
      
      //Enredeco
      lblEndereco =  new JLabel("Endereço: ");
      cadastro3.add(lblEndereco);
      
      txtEndereco = new JTextField(26);
      cadastro3.add(txtEndereco);
      
         
      //Email
      lblEmail = new JLabel ("E-mail: ");
      cadastro9.add(lblEmail);
       
      txtEmail = new JTextField(26);
      cadastro9.add(txtEmail);   
      
      //Senha
      lblSenha = new JLabel ("Senha: ");
      cadastro10.add(lblSenha);
       
      passSenha = new JPasswordField(26);
      cadastro10.add(passSenha);   
      
      //Limpar
      btnLimpar = new JButton("Limpar");
      btnLimpar.setBackground(new Color(211, 211, 211));
      btnLimpar.setForeground(Color.WHITE);
      cadastro11.add(btnLimpar);
      btnLimpar.addActionListener(controller);
      
      //Cadastrar
      btnCadastrar = new JButton("Cadastrar");
      btnCadastrar.setBackground(new Color(60, 179, 113));
      btnCadastrar.setForeground(Color.WHITE);
      cadastro11.add(btnCadastrar);
      btnCadastrar.addActionListener(controller);
         
      //Configurações Gerais do Frame   
      
      cadastro.setBackground(Color.white); //Aplicando cores de fundo
      cadastro2.setBackground(Color.white);
      cadastro4.setBackground(Color.white);
      cadastro3.setBackground(Color.white);
      cadastro6.setBackground(Color.white);
      cadastro8.setBackground(Color.white);
      cadastro9.setBackground(Color.white);
      cadastro10.setBackground(Color.white);
      cadastro11.setBackground(Color.white);
      cadastro12.setBackground(Color.white);
      
      setSize(450,500); //larguraXtamaho
      //setExtendedState(JFrame.MAXIMIZED_BOTH);  //Maximizando o JFrame
      //setResizable(false);//Travando o tamanho da tela
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true); 
   }
   
   public void setTNome(String nome){
      txtNome.setText(nome);
   }
   
   public String getTNome(){
      return txtNome.getText();
   }
   
   public void setTCpf(String cpf){
      txtCpf.setText(cpf);
   }
   
   public String getTCpf(){
      return txtCpf.getText();
   }
      
   public void setTDtNascimento(String dtNascimento){
      txtDtNascimento.setText(dtNascimento);
   }
   
   public String getTDtNascimento(){
      return txtDtNascimento.getText();
   }
   
   public String getTGenero(){
      String value = (String)cbxGenero.getSelectedItem();
      return value;
   }
   
   public int getTTipoIdentificacao(){
      int value = cbxTipoIdentificacao.getSelectedIndex() + 1;
      return value;
   }
   
   public void setTEndereco(String endereco){
      txtEndereco.setText(endereco);
   }
   
   public String getTEndereco(){
      return txtEndereco.getText();
   }
  
   
   public void setTNumeroIdentificacao(String numeroIdentificacao){
      txtNumeroIdentificacao.setText(numeroIdentificacao);
   }
   
   public String getTNumeroIdentificacao(){
      return txtNumeroIdentificacao.getText();
   }

   public void setTEmail(String email){
      txtEmail.setText(email);
   }
    
   public String getTEmail(){
      return txtEmail.getText();
   }
    
   public void setPSenha(String senha){
      passSenha.setText(senha);
   }
     
   public String getPSenha(){
      return passSenha.getText();
   }
   
   public JButton getCadastrar(){
      return btnCadastrar;
   }
    
   public JButton getLimpar(){
      return btnLimpar;
   }
   
   public void close(){
      super.dispose();
   }
}
