
package gamelogic;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Olli
 */
public class Decks {
    
    private ArrayList<Deck> decks;
    
    public Decks(ArrayList<Deck> decks){
        
        this.decks = decks;
    }
    
    public boolean hasCards(){
                
        for (Deck deck : this.decks){
            
            if (deck.hasCards()){
                
                return true;
            }
        }
        
        return false;
    }
    
    public Card dealCard(){
        
        Random rand = new Random();
        
        Deck deck = this.decks.get(rand.nextInt(this.decks.size()));
        
        Card card = null;
        
        if (deck.hasCards()){
                
            card = deck.dealCard();
        } else {
        
            while (!deck.hasCards()){

                deck = this.decks.get(rand.nextInt(this.decks.size()));

                if (deck.hasCards()){

                    card = deck.dealCard();
                    break;
                }
            }
        }
        
        return card;
    }
    
}
