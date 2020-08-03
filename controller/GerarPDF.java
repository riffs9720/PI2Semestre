package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GerarPDF {
   
   private JTable tabela; 
   private JScrollPane barraRolagem;

   public GerarPDF(JTable tabela){
      this.tabela = tabela;
   }   
   
   public void print() {
      try {
      
         Document document = new Document();
         PdfWriter.getInstance(document,  new FileOutputStream("C:/Users/Public/Relatorio_Sugestoes.pdf"));
      
         document.open();
         
         document.add(new Paragraph("Relatório de Sugestões"));

         for (int i = 0; i < tabela.getRowCount(); i++) {
            //for(int j = 0; j < tabela.getColumnCount(); j++){
               
               document.add(new Paragraph("-----------------------------"));                  
               
               document.add(new Paragraph("Colaborador"));
               document.add(new Paragraph(tabela.getValueAt(i,0) + ""));
               document.add(new Paragraph("-----------------------------"));
               document.add(new Paragraph("Sugestão"));               
               document.add(new Paragraph(tabela.getValueAt(i,1) + ""));
               document.add(new Paragraph("-----------------------------"));               
               document.add(new Paragraph("Departamento"));               
               document.add(new Paragraph(tabela.getValueAt(i,2) + ""));
               document.add(new Paragraph("-----------------------------"));               
               document.add(new Paragraph("Data"));               
               document.add(new Paragraph(tabela.getValueAt(i,3) + ""));
            //}                      
         }
         
         JOptionPane.showMessageDialog(null, "acabou");            
         document.close();
         
         JOptionPane.showMessageDialog(null, "Salvo");
      } 
      catch (Exception e) {
      }
   }
}