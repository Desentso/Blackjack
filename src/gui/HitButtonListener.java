/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Olli
 */
public class HitButtonListener implements ActionListener{

    private Game game;
    
    public HitButtonListener(Game game){
        
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        this.game.playerHit();
    }
    
}
