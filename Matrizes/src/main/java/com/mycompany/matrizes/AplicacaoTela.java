/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matrizes;

import com.mycompany.matrizes.Matrizes;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class AplicacaoTela extends javax.swing.JFrame {

    private BufferedImage imagemArq;
    public Matrizes matrizes = new Matrizes();
    public boolean validacaoDiminuiImagem;
    
    public AplicacaoTela() {
        initComponents();
        configuraTela();
    }
    
    public void configuraTela(){
        setTitle("Processamento de imagens.");
    }
    
    public boolean getIsImageValid(){
        if(this.matrizes.imageOrigin != null){
            return true;
        } else {
            JOptionPane.showMessageDialog(
            null,
            "Não existe imagem importada para realizar edição.",
            "Erro de validação",
            JOptionPane.ERROR_MESSAGE
            );
            
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneImgCarregada = new javax.swing.JScrollPane();
        jLabelImgCarregada = new javax.swing.JLabel();
        jScrollPaneImgNova = new javax.swing.JScrollPane();
        jLabelImgNova = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemEspelhamentoVertical = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelImgCarregada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPaneImgCarregada.setViewportView(jLabelImgCarregada);

        jLabelImgNova.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImgNova.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jScrollPaneImgNova.setViewportView(jLabelImgNova);

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Importar Arquivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importImage(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edição de Imagem");

        jMenuItemEspelhamentoVertical.setText("Espelhamento vertical");
        jMenuItemEspelhamentoVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getVerticalMirror(evt);
            }
        });
        jMenu2.add(jMenuItemEspelhamentoVertical);

        jMenuItem3.setText("Duplicar tamanho");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDuplicateSize(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Espelhamento horizontal");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getHorizonMirror(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Rotacionar 90º");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRotate(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Diminuir tamanho");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getDecreaseSize(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneImgCarregada, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneImgNova, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneImgCarregada)
            .addComponent(jScrollPaneImgNova, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importImage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importImage
        BufferedImage img = this.matrizes.buscaImagem();
        
        if(img != null){
            this.mostraImagemCarregada(img);
        }
    }//GEN-LAST:event_importImage

    private void getVerticalMirror(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getVerticalMirror
         if(getIsImageValid()) {
            BufferedImage newImage = this.matrizes.getMirror(true);
            this.showAlteredImage(newImage);
        }  
    }//GEN-LAST:event_getVerticalMirror

    private void getDuplicateSize(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDuplicateSize
        if(getIsImageValid()) {
            BufferedImage newImage =  this.matrizes.getChangeSize(true);
            this.showAlteredImage(newImage);
        }
    }//GEN-LAST:event_getDuplicateSize

    private void getDecreaseSize(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getDecreaseSize
        if(getIsImageValid()) {
            BufferedImage newImage =  this.matrizes.getChangeSize(false);
            this.showAlteredImage(newImage);
        }
    }//GEN-LAST:event_getDecreaseSize

    private void getHorizonMirror(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getHorizonMirror
        if(getIsImageValid()) {
            BufferedImage newImage = this.matrizes.getMirror(false);
            this.showAlteredImage(newImage);
        }    
    }//GEN-LAST:event_getHorizonMirror

    private void getRotate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRotate
       if(getIsImageValid()){
           BufferedImage newImage = this.matrizes.getRotate();
           this.showAlteredImage(newImage);
       }
    }//GEN-LAST:event_getRotate

    public void mostraImagemCarregada(BufferedImage img){
        ImageIcon icon = new ImageIcon(img);
        
        jLabelImgCarregada.setIcon(icon);
    }
    
    public void showAlteredImage(BufferedImage newImage){
        ImageIcon icon = new ImageIcon(newImage);

        jLabelImgNova.setIcon(icon);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplicacaoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacaoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacaoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacaoTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplicacaoTela().setVisible(true);
            }
        });
    }
    
private static javax.swing.JSlider sliderZoom;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImgCarregada;
    private javax.swing.JLabel jLabelImgNova;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemEspelhamentoVertical;
    private javax.swing.JScrollPane jScrollPaneImgCarregada;
    private javax.swing.JScrollPane jScrollPaneImgNova;
    // End of variables declaration//GEN-END:variables
}
