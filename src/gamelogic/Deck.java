/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Olli
 */
public class Deck {
    
    private ArrayList<Card> deck;
    
    public Deck(){
        
        this.deck = new ArrayList<>();
        
        ArrayList<Symbol> symbols = new ArrayList<>(asList(Symbol.HEART, Symbol.DIAMOND, Symbol.CLUB, Symbol.SPADE));
        
        for(Symbol symbol : symbols){
            
            for(int i = 2; i < 15; i++){
                
                this.deck.add(new Card(symbol, i));
            }
        }
    }
    
    public Card dealCard(){
        
        Random rand = new Random();
        
        //System.out.println(this.deck.size());
        
        Card card = this.deck.get(rand.nextInt(this.deck.size()));
        
        this.deck.remove(card);
        
        return card;
    }
    
    public boolean hasCards(){
        
        if (this.deck.size() > 10){
            
            return true;
        } else {
            
            return false;
        }
    }
    
    
    
}
