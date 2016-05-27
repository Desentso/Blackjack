/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.Card;
import gamelogic.Hand;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Olli
 */
public class Draw extends JPanel{
    
    private Hand dealerHand;
    private Hand playerHand;
    
    public Draw(){
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawString("Dealer Cards:", 0, 10);
        g2d.drawString("Player Cards: ", 0, 140);
        
        String path = "E:/Käyttäjät/Tiedostot/Nettisivu/New blog site/Images/photo1.jpg";
        
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        
        //g2d.drawImage(image, 80, 80, 100, 150, this);
        
        //images of cards or image and adding numbers with text
        
        int x = 50;
        
        for(Card card : this.dealerHand.getCards()){
            
            g2d.drawString(Integer.toString(card.getValue()), x, 50);
            
            x += 20;
        }
        
        x = 50;
        
        for(Card card : this.playerHand.getCards()){
            
            g2d.drawString(Integer.toString(card.getValue()), x, 180);
            
            x += 20;
        }
        
        g2d.setFont(new Font("default", Font.BOLD, 20));
        g2d.drawString(Integer.toString(this.dealerHand.value()), 55, 80);
        g2d.drawString(Integer.toString(this.playerHand.value()), 55,210);
        
    }
    
    public void update(){
        
        repaint();
    }
    
    public void setHands(Hand dealer, Hand player){
        
        this.dealerHand = dealer;
        this.playerHand = player;
    }
}
