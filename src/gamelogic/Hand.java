/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;

/**
 *
 * @author Olli
 */
public class Hand {
    
    private ArrayList<Card> cards;
    private boolean aceUsed;
    
    public Hand(){
      
        this.cards = new ArrayList<>();
        this.aceUsed = false;
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
        
        if (value > 21 && this.hasAce() && !this.aceUsed){
            
            value = value - 10;
            this.aceUsed = true;
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
    
    
    
}
