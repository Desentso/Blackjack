/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

/**
 *
 * @author Olli
 */
public class Card {
    
    private Symbol symbol;
    private int value;
    private String image;
    
    public Card(Symbol symbol, int value){
        
        this.symbol = symbol;
        this.value = value;
        
        if (null != this.symbol)switch (this.symbol) {
            case HEART:
                this.image = "E:/JavaProjects/Blackjack/images/Heart" + this.value + ".jpg";
                break;
            case DIAMOND:
                this.image = "E:/JavaProjects/Blackjack/images/Diamond" + this.value + ".jpg";
                break;
            case CLUB:
                this.image = "E:/JavaProjects/Blackjack/images/Club" + this.value + ".jpg";
                break;
            case SPADE:
                this.image = "E:/JavaProjects/Blackjack/images/Spade" + this.value + ".jpg";
                break;
            default:
                break;
        }
    }
    
    public int getValue(){
        
        if (this.value == 14){
            
            return 11;
        } else if (this.value > 10){
            
            return 10;
        } else {
            
            return this.value;
        }
    }
    
    public int rawValue(){
        
        return this.value;
    }
    
    public Symbol getSymbol(){
        
        return this.symbol;
    }
    
    public String getImage(){
        
        return this.image;
    }
}
