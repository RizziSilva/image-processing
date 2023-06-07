/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrizes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author William
 */
public class Matrizes {
    public BufferedImage imageOrigin;
    public BufferedImage image;
    
    public Matrizes() {}
    
    public BufferedImage buscaImagem(){
        JFileChooser fileChooser = new JFileChooser();
          
        fileChooser.setDialogTitle("Escolha a imagem.");
        FileNameExtensionFilter filtroJPEG = new FileNameExtensionFilter("Arquivos JPEG", "jpg");
        FileNameExtensionFilter filtroPNG = new FileNameExtensionFilter("Arquivos PNG", "png");
        fileChooser.setFileFilter(filtroJPEG);
        fileChooser.setFileFilter(filtroPNG);

        int fileReturn = fileChooser.showOpenDialog(fileChooser);

        if(fileReturn == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            
            try {
                this.imageOrigin = ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(AplicacaoTela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return this.imageOrigin;
        }

        return null;
    }
    
    public BufferedImage getMirror(boolean isVerticalMirror) {
        int height = this.imageOrigin.getHeight();
        int width = this.imageOrigin.getWidth();
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = this.imageOrigin.getRGB(x, y);
                int destinyPositionX = x;
                int destinyPositionY = y;
                
                if (isVerticalMirror) destinyPositionY = height - y - 1;
                else destinyPositionX = width - x - 1;
                
                newImage.setRGB(destinyPositionX, destinyPositionY, pixel);
            }
        }
        
        return newImage;
    }
    
    public BufferedImage getChangeSize(boolean isIncrease) {
        int height = this.imageOrigin.getHeight();
        int width = this.imageOrigin.getWidth();
        double sizeChange = 0.5;
        
        if (isIncrease) sizeChange = 2;
        
        double newWidth = width * sizeChange;
        double newHeight = height * sizeChange;
        BufferedImage newImage = new BufferedImage((int)newWidth, (int)newHeight, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = this.imageOrigin.getRGB(x, y);
                double destinyPositionX = x * sizeChange;
                double destinyPositionY = y * sizeChange;

                newImage.setRGB((int)destinyPositionX, (int)destinyPositionY, pixel);
                if (isIncrease) {
                    newImage.setRGB((int)destinyPositionX, (int)destinyPositionY + 1, pixel);
                    newImage.setRGB((int)destinyPositionX + 1, (int)destinyPositionY, pixel);
                    newImage.setRGB((int)destinyPositionX + 1, (int)destinyPositionY + 1, pixel);
                } 
            }
        }
        
        return newImage;
    }
    
    public BufferedImage getTranslate() {
        int TRANSLATE_SIZE = 200;
        int height = this.imageOrigin.getHeight();
        int width = this.imageOrigin.getWidth();
        int widthWithTranslate = width + TRANSLATE_SIZE;
        int heightWithTranslate = height + TRANSLATE_SIZE;
        BufferedImage newImage = new BufferedImage(widthWithTranslate, heightWithTranslate, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel =  this.imageOrigin.getRGB(x, y);
                int destinyPositionX = x + TRANSLATE_SIZE;
                int destinyPositionY = y + TRANSLATE_SIZE;
                
                newImage.setRGB(destinyPositionX, destinyPositionY, pixel);
            }
        }
        
        return newImage;
    }
    
    public BufferedImage getRotate() {
        double degrees = 90.0;
        double radians = Math.toRadians(degrees);
        double sen = Math.sin(radians);
        double cos = Math.cos(radians);
        int height = this.imageOrigin.getHeight();
        int width = this.imageOrigin.getWidth();
        
        BufferedImage newImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel =  this.imageOrigin.getRGB(x, y);
                double destinyPositionXDouble = x * cos - y * sen;
                double destinyPositionYDouble = x * sen + y * cos;
                int destinyPositionX = (int) destinyPositionXDouble;
                int destinyPositionY = (int) destinyPositionYDouble;
                
                newImage.setRGB(Math.abs(destinyPositionX), Math.abs(destinyPositionY), pixel);
            }
        }
         
        return newImage;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
