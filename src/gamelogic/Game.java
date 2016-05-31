package gamelogic;

import gui.Draw;
import gui.Gui;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Olli
 */
public class Game {
    
    private Draw draw;
    private boolean playerHit;
    private boolean playerStand;
    private boolean playerTurn;
    private boolean dealerTurn;
    private Hand playerHand;
    private Hand dealerHand;
    
    private boolean noBet;
    private int bet;
    private int balance;
    
    private boolean playerWin;
    private boolean win;
    private boolean push;
    
    private boolean noCards;
            
    public Game(){
        
        //this.draw = draw;
        this.draw = new Draw(this);
        
        this.playerHit = false;
        this.playerStand = false;
        
        this.noCards = false;
        
        this.balance = 1000;
    }
    
    public void run(){
        
        Gui gui = new Gui(this.draw, this);
        gui.run();
        
        this.dealerTurn = false;
        this.playerTurn = false;
        
        this.noBet = true;
        
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Deck deck3 = new Deck();
        Deck deck4 = new Deck();
        
        ArrayList<Deck> arrdecks = new ArrayList<>();
        
        arrdecks.add(deck1);
        arrdecks.add(deck2);
        arrdecks.add(deck3);
        arrdecks.add(deck4);
        
        Decks decks = new Decks(arrdecks);
        
        this.playerHand = new Hand();
        this.dealerHand = new Hand();

        this.dealerHand.setShow(false);
        
        this.draw.setHands(this.dealerHand, this.playerHand);
        
        
        while(decks.hasCards()){
            
            
            if (this.balance == 0){
                
                this.balance = 100;
                this.draw.update();
            }
            
            this.draw.update();
            
            while(this.noBet){
                
                
            }
            
            this.playerWin = false;
            this.win = false;
            this.push = false;
            
            this.playerHand = new Hand();
            this.dealerHand = new Hand();

            this.dealerHand.setShow(false);
            
            this.draw.setHands(this.dealerHand, this.playerHand);
            
            this.playerHand.addCard(decks.dealCard());
            this.dealerHand.addCard(decks.dealCard());

            this.playerHand.addCard(decks.dealCard());
            this.dealerHand.addCard(decks.dealCard());

            this.draw.update();
            
            if (playerHand.value() == 21){
                
                System.out.println("Player has BLACKJACK");
                
                this.playerWin = true;
                this.win = true;
                this.balance += (this.bet + (this.bet * 1.5));
                
                try {

                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {

                    Thread.currentThread().interrupt();
                }
                
                this.noBet = true;
                
                continue;
            }
            
            this.playerTurn = true;
            
            while(this.playerTurn){
                
                this.draw.update();
                
                if(this.playerHit){
                    
                    this.playerHand.addCard(decks.dealCard());
                    
                    this.draw.update();
                    this.playerHit = false;
                    
                    if (this.playerHand.value() > 21){
                        
                        System.out.println("Player busted, Dealer wins!");
                        
                        this.playerTurn = false;
                        this.win = true;
                    }
                }
                
                if (this.playerStand){
                    
                    this.playerStand = false;
                    this.playerTurn = false;
                    this.dealerTurn = true;
                }
            }
            
            this.dealerHand.setShow(true);
            this.draw.update();
            
            while(this.dealerTurn){
                
                if(dealerHand.value() < 17){
                    
                    dealerHand.addCard(decks.dealCard());
                    this.draw.update();
                } else {

                    this.dealerTurn = false;
                }
            }
            
            if (dealerHand.value() < 22 && playerHand.value() < 22){
                
                if (dealerHand.value() > playerHand.value()){
                    
                    System.out.println("Dealer wins!");
                    this.win = true;
                } else if (dealerHand.value() < playerHand.value()) {
                    
                    System.out.println("Player wins!");
                    
                    this.playerWin();
                    this.balance += (this.bet + this.bet);
                    this.playerWin = true;
                    this.win = true;
                } else {
                    
                    System.out.println("Push!");
                    this.balance += this.bet;
                    this.win = true;
                    this.push = true;
                }
            } else if (dealerHand.value() > 21){
                
                System.out.println("Dealer busted, Player wins!");
                this.balance += (this.bet + this.bet);
                this.playerWin = true;
                this.win = true;
            }
            
            try {
                
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                
                Thread.currentThread().interrupt();
            }

            this.noBet = true;
            
        }
        
        System.out.println("OUT OF CARDS!");
        
        this.noCards = true;
        this.draw.update();
    }
    
    public void playerHit(){
        
        if(this.playerTurn){
            
            this.playerHit = true;
        }
    }
    
    public void playerStand(){
        
        if (this.playerTurn){
            
            this.playerStand = true;
        }
    }
    
    public void bet(int amount){
        
        if (this.noBet && (this.balance - amount) >= 0){
            
            this.balance -= amount;
            this.bet = amount;
            this.noBet = false;
        }
    }
    
    public boolean noBet(){
        
        return this.noBet;
    }
    
    public String getBet(){
        
        return Integer.toString(this.bet);
    }
    
    public String getBalance(){
        
        return Integer.toString(this.balance);
    }
    
    public boolean win(){
        
        return this.win;
    }
    
    public boolean playerWin(){
        
        return this.playerWin;
    }
    
    public boolean push(){
        
        return this.push;
    }
    
    public boolean noCards(){
        
        if (this.noCards){
            
            return true;
        } else {
            
            return false;
        }
    }
}
