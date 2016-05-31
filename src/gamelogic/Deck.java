
package gamelogic;

import java.util.ArrayList;
import static java.util.Arrays.asList;
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
        
        Card card = this.deck.get(rand.nextInt(this.deck.size()));
        
        this.deck.remove(card);
        
        return card;
    }
    
    public boolean hasCards(){
        
        if (this.deck.size() > 0){
            
            return true;
        } else {
            
            return false;
        }
    }
    
    
    
}
