
package gui;

import gamelogic.Card;
import gamelogic.Game;
import gamelogic.Hand;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Olli
 */
public class Draw extends JPanel{
    
    private Hand dealerHand;
    private Hand playerHand;
    private Game game;
    
    public Draw(Game game){
        
        this.game = game;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        this.setBackground(new Color(7,99,36));
        
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setColor(Color.WHITE);
        
        g2d.setFont(new Font("default", Font.BOLD, 14));
        g2d.drawString("Dealer:", 5, 15);
        g2d.drawString("You: ", 5, 260);  
        
        g2d.drawString("Balance:", 575, 465);
        g2d.drawString(this.game.getBalance(), 640, 465);
        
        if (this.game.noBet()){
            
            g2d.drawString("Set your bet!", 338, 260);
        }
        
        if (this.game.win() && this.game.playerWin()){
            
            g2d.setFont(new Font("default", Font.BOLD, 25));
            g2d.setColor(new Color(92,225,80));
            g2d.drawString("You win!", 330, 240);
        } else if (this.game.win() && this.game.push()){
            
            g2d.setFont(new Font("default", Font.BOLD, 25));
            g2d.setColor(Color.WHITE);
            g2d.drawString("Push!", 330, 240);
        } else if (this.game.win()){
            
            g2d.setFont(new Font("default", Font.BOLD, 25));
            g2d.setColor(new Color(237,62,53));
            g2d.drawString("You lost!", 330, 240);    
        }
        
        g2d.setColor(Color.white);
        g2d.setFont(new Font("default", Font.BOLD, 14));
        
        Image image;
        
        int x = 20;
        
        if (this.dealerHand.showCards()){
            for(Card card : this.dealerHand.getCards()){


                    image = Toolkit.getDefaultToolkit().getImage(card.getImage());
                    g2d.drawImage(image, x, 20, 120, 165, this);

                    x += 140;
            }
        } else if (this.dealerHand.getCards().size() > 0) {
            
            image = Toolkit.getDefaultToolkit().getImage(this.dealerHand.getCards().get(0).getImage());
            g2d.drawImage(image, x, 20, 120, 165, this);

            x += 140;
            
            image = Toolkit.getDefaultToolkit().getImage("E:/JavaProjects/Blackjack/images/Back.jpg");
            g2d.drawImage(image, x, 20, 120, 165, this);
            
        }
        
        x = 20;
        
        for(Card card : this.playerHand.getCards()){
            
            image = Toolkit.getDefaultToolkit().getImage(card.getImage());
            g2d.drawImage(image, x, 270, 120, 165, this);
            
            x += 140;
        }
        
        g2d.setFont(new Font("default", Font.BOLD, 18));
        
        if (this.dealerHand.showCards()){
            
            g2d.drawString("Total: " + Integer.toString(this.dealerHand.value()), 25, 210);
        } else if (this.dealerHand.getCards().size() > 0){
            
            g2d.drawString("Total: " + Integer.toString(this.dealerHand.getCards().get(0).getValue()), 25, 210);
        }
        
        g2d.drawString("Total: " + Integer.toString(this.playerHand.value()), 25, 460);
        
        
        if (this.game.noCards()){
            
            g2d.setColor(new Color(7,99,36));
            g2d.fillRect(280, 220, 150, 50);
            
            g2d.setColor(Color.WHITE);
            g2d.drawString("Out of Cards!", 280, 250);
        }
    }
    
    public void update(){
        
        repaint();
    }
    
    public void setHands(Hand dealer, Hand player){
        
        this.dealerHand = dealer;
        this.playerHand = player;
    }
}
