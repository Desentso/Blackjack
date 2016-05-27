package gamelogic;

import gui.Draw;
import gui.Gui;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olli
 */
public class Game {
    
    private Draw draw;
    private boolean playerHit;
    private boolean playerStand;
    private boolean playerTurn;
    
    public Game(Draw draw){
        
        this.draw = draw;
        
        this.playerHit = false;
        this.playerStand = false;
    }
    
    public void run(){
        
        Gui gui = new Gui(this.draw, this);
        gui.run();
        
        boolean dealerTurn = false;
        this.playerTurn = false;
        
        Deck deck1 = new Deck();
        
        
        
        while(deck1.hasCards()){
            
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();

            this.draw.setHands(dealerHand, playerHand);
            
            this.draw.update();
            
            playerHand.addCard(deck1.dealCard());
            dealerHand.addCard(deck1.dealCard());

            playerHand.addCard(deck1.dealCard());
            dealerHand.addCard(deck1.dealCard());

            //System.out.println(playerHand.value());
            
            if (playerHand.value() == 21){
                
                System.out.println("Player has BLACKJACK");
                continue;
            }
            this.playerTurn = true;
            
            while(this.playerTurn){
                
                if(this.playerHit){
                    
                    playerHand.addCard(deck1.dealCard());
                    
                    this.draw.update();
                    this.playerHit = false;
                    
                    if (playerHand.value() > 21){
                        
                        System.out.println("Player busted, Dealer wins!");
                        
                        this.playerTurn = false;
                    }
                }
                
                if (this.playerStand){
                    
                    this.playerStand = false;
                    this.playerTurn = false;
                    dealerTurn = true;
                }
            }
            
            while(dealerTurn){
                
                if(dealerHand.value() < 17){
                    
                    dealerHand.addCard(deck1.dealCard());
                    this.draw.update();
                } else {

                    dealerTurn = false;
                }
            }
            
            if (dealerHand.value() < 22 && playerHand.value() < 22){
                
                if (dealerHand.value() > playerHand.value()){
                    
                    System.out.println("Dealer wins!");

                } else if (dealerHand.value() < playerHand.value()) {
                    
                    System.out.println("Player wins!");
                } else {
                    
                    System.out.println("Push!");
                }
            } else if (dealerHand.value() > 21){
                
                System.out.println("Dealer busted, Player wins!");
            }
            
            try {
                
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                
                Thread.currentThread().interrupt();
            }
            
        }
        
        System.out.println("OUT OF CARDS!");
        
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
}
