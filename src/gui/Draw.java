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
        
        g2d.setFont(new Font("default", Font.BOLD, 14));
        g2d.drawString("Dealer:", 0, 10);
        g2d.drawString("Player: ", 0, 260);
        
        String path = "E:/JavaProjects/Blackjack/images/Heart2.jpg";
        
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        
        //g2d.drawImage(image, 80, 80, 100, 150, this);
        
        //images of cards or image and adding numbers with text
        
        int x = 20;
        
        for(Card card : this.dealerHand.getCards()){
            
            image = Toolkit.getDefaultToolkit().getImage(card.getImage());
            g2d.drawImage(image, x, 20, 120, 165, this);
            
            x += 140;
           /* g2d.drawString(Integer.toString(card.getValue()), x, 50);
            x += 20;*/
        }
        
        x = 20;
        
        for(Card card : this.playerHand.getCards()){
            
            image = Toolkit.getDefaultToolkit().getImage(card.getImage());
            g2d.drawImage(image, x, 270, 120, 165, this);
            
            x += 140;
            
            /*g2d.drawString(Integer.toString(card.getValue()), x, 180);
            
            x += 20;*/
        }
        
        g2d.setFont(new Font("default", Font.BOLD, 18));
        g2d.drawString("Total: " + Integer.toString(this.dealerHand.value()), 25, 210);
        g2d.drawString("Total: " + Integer.toString(this.playerHand.value()), 25, 460);
        
    }
    
    public void update(){
        
        repaint();
    }
    
    public void setHands(Hand dealer, Hand player){
        
        this.dealerHand = dealer;
        this.playerHand = player;
    }
}
