/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import java.util.ArrayList;

/**
 *
 * @author Olli
 */
public class Hand {
    
    private ArrayList<Card> cards;
    private int acesUsed;
    private boolean show;
    
    public Hand(){
      
        this.cards = new ArrayList<>();
        this.acesUsed = 0;
        this.show = true;
    }
    
    public void addCard(Card card){
        
        this.cards.add(card);
    }
    
    public int value(){
        
        int value = 0;
        
        for(Card card : this.cards){
            
            if(card.getValue() == 11){
              
                value += 11;
            } else if (card.getValue() > 10){
                
                value += 10;
            } else {
                
                value += card.getValue();
            }
            
        }
        
        if (value > 21 && this.hasAce()){
            
            value = value - 10;
            this.acesUsed += 1;
        }
        
        return value;
    }
    
    public boolean hasAce(){
        
        boolean ace = false;
        
        for(Card card : this.cards){
            
            if(card.getValue() == 11){
                
                ace = true;
            }
        }
        
        return ace;
    }
    
    public ArrayList<Card> getCards(){
        
        return this.cards;
    }
    
    public void setShow(boolean show){
        
        this.show = show;
    }
    
    public boolean showCards(){
        
        return this.show;
    }
    
}
