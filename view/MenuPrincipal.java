package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import controller.MuralController;
import model.UsuarioAcesso;

public class MenuPrincipal extends JPanel{
   private JMenuBar barra;
   
   private JButton btnNotificacao;
   private JMenu mePerfil;
   private JMenuItem subPerfil;
   private JMenuItem subSair; 
   private JMenu subSugestao;
   private JMenuItem    subNovaSugestao;
   private JMenuItem   subMinhaSugestao;
   
   private JMenu subAvaliacao;
   private JMenuItem   subNovaAvaliacao;
   private JMenu subRelatorio;
   private JMenuItem   subNovoRelatorio;   
   
   private  JFrame frame;
   private  JPanel painelAtual;
   
   private JButton btnMural, btnQuemSomos, btnContato;
   
   private UsuarioAcesso usuarioAcesso;
   
   public MenuPrincipal(ActionListener controller, UsuarioAcesso usuarioAcesso){
      
      this.usuarioAcesso = usuarioAcesso;
      
      barra = new JMenuBar();
   
      JLabel vazio = new JLabel("                                                                                                                                                                                                                                                                                                   ");
      JLabel logo = new JLabel (new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/logosaojudas.png"));
      btnMural = new JButton("");
      btnQuemSomos = new JButton();
      btnContato = new JButton();
      
      btnMural.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/mural.png"));
      btnQuemSomos.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/quemsomos.png"));
      btnContato.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/contato.png"));
      
      barra.add(logo); 
      barra.add(vazio);
      barra.add( btnMural );
      barra.add( btnQuemSomos );
      barra.add( btnContato );
      
     //----------------------Menu---------------
    
      btnNotificacao = new JButton();
      mePerfil = new JMenu(); 
      subPerfil = new JMenuItem("Perfil");
      subSair = new JMenuItem("Sair");
      subSugestao = new JMenu("Sugestão");
      subNovaSugestao = new JMenuItem("Nova Sugestão");
      subMinhaSugestao = new JMenuItem("Minhas Sugestões");
               
      subAvaliacao = new JMenu("Avaliações");
      subRelatorio = new JMenu("Relatórios");      
      subNovaAvaliacao = new JMenuItem("Nova avaliação");
      subNovoRelatorio = new JMenuItem("Emitir Relatório");
      
      
      /*int x=subSugestao.getLocation().x;
      int y=subSugestao.getLocation().y;
      y=y+subSugestao.getPreferredSize().height;
      subSugestao.setMenuLocation(x,y);
      
      int a=subAvaliacao.getLocation().a;
      int b=subAvaliacao.getLocation().b;
      b=b+subAvaliacao.getPreferredSize().height;
      subAvaliacao.setMenuLocation(a,b);
      
      int c=subRelatorio.getLocation().c;
      int d=subRelatorio.getLocation().d;
      d=d+subRelatorio.getPreferredSize().height;
      subRelatorio.setMenuLocation(c,d);*/
      
      
      barra.add(btnNotificacao );
      barra.add( mePerfil);
        
      mePerfil.add(subPerfil);
      mePerfil.add(subSair);
      subSugestao.setBackground(Color.blue);
     
      mePerfil.add(subSugestao);      
      subSugestao.add(subNovaSugestao);      
      subSugestao.add(subMinhaSugestao);
      
      mePerfil.add(subAvaliacao);            
      subAvaliacao.add(subNovaAvaliacao); 
      
      mePerfil.add(subRelatorio);     
      subRelatorio.add(subNovoRelatorio);
       //---Separador--- 
      mePerfil.addSeparator();
    
      btnNotificacao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/notificacao.png"));
      mePerfil.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/perfil.png"));
      
      subPerfil.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/subperfil6.png"));
      subSair.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/subsair2.png"));
      subSugestao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/sugestao.png"));
      subMinhaSugestao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/minhasugestao3.png"));
      subNovaSugestao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/novasugestao3.png"));
      
      subAvaliacao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/avaliacao.png"));
      subRelatorio.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/relatorio.png"));
   
      subNovaAvaliacao.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/novasugestao3.png"));
      subNovoRelatorio.setIcon(new ImageIcon("C:/Users/Janaina/Documents/Faculdade/Disciplinas/Projeto Interdisciplinar/Desenvolvimento/sistemaDeSugestoes/assets/imgs/novasugestao3.png"));
              
      subPerfil.setFont(new Font("helvetica", Font.PLAIN, 17));
      subSair.setFont(new Font("helvetica", Font.PLAIN, 17));
      subSugestao.setFont(new Font("helvetica", Font.PLAIN, 17));
      subNovaSugestao.setFont(new Font("helvetica", Font.PLAIN, 10));
      subMinhaSugestao.setFont(new Font("helvetica", Font.PLAIN, 10));
      subAvaliacao.setFont(new Font("helvetica", Font.PLAIN, 17));
      subNovaAvaliacao.setFont(new Font("helvetica", Font.PLAIN, 10));
      subRelatorio.setFont(new Font("helvetica", Font.PLAIN, 17));
      subNovoRelatorio.setFont(new Font("helvetica", Font.PLAIN, 10));
 
      
      btnMural.setBackground(Color.WHITE);
      btnContato.setBackground(Color.WHITE);
      btnQuemSomos.setBackground(Color.WHITE);
      btnNotificacao.setBackground(Color.WHITE);
      mePerfil.setBackground(Color.WHITE);
      barra.setBackground(Color.WHITE);
      
      btnMural.setBorderPainted( false );
      btnQuemSomos.setBorderPainted( false );
      btnContato.setBorderPainted( false );
      btnNotificacao.setBorderPainted(false);
      
      subSair.addActionListener(controller);
      subNovaSugestao.addActionListener(controller);
      subMinhaSugestao.addActionListener(controller);
      subNovaAvaliacao.addActionListener(controller);
      subNovoRelatorio.addActionListener(controller);
      
      btnQuemSomos.addActionListener(controller);
      btnContato.addActionListener(controller);
      btnMural.addActionListener(controller);
            
      MuralController mural = new MuralController();
      painelAtual = mural.getView();
      
      if(usuarioAcesso.selectPerfil(usuarioAcesso.getIdUsuarioAcesso()) == 1){
         subAvaliacao.setVisible(false);
         subRelatorio.setVisible(false);         
      }else if(usuarioAcesso.selectPerfil(usuarioAcesso.getIdUsuarioAcesso()) == 3){
         subAvaliacao.setVisible(false);         
      }
      
      frame = new JFrame("Sistema de Sugestão");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setJMenuBar(this.barra);
      frame.add(painelAtual);
      frame.pack();
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
   }
   
   public JMenuItem getSair(){
      return this.subSair;
   }
   
   public JMenuItem getNovaSugestao(){
      return this.subNovaSugestao;
   }
   
   public void close(){
      frame.dispose();
   }
   
   public JFrame getFrame(){
      return this.frame;
   }
   
   public JPanel painelAtual(){
      return this.painelAtual;
   }
   
   public void setPainelAtual(JPanel painelAtual){
      this.painelAtual = painelAtual;
   }
   
   public JButton getQuemSomos(){
      return  this.btnQuemSomos;
   }
   
   public JButton getContato(){
      return this.btnContato;
   }
   
   public JButton getMural(){
      return this.btnMural;
   }
   
   public JMenuItem getMinhasSugestoes(){
      return subMinhaSugestao;
   }
   
   public JMenuItem getNovaAvaliacao(){
      return subNovaAvaliacao;
   }
}