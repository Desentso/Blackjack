/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Olli
 */
public class BetButtonListener implements ActionListener{

    private Game game;
    private JTextField amountField;
    
    public BetButtonListener(Game game, JTextField amount){
        
        this.game = game;
        this.amountField = amount;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String amount = this.amountField.getText();

        
        if (this.isInteger(amount)) {
            
            this.game.bet(Integer.parseInt(this.amountField.getText()));
        }

    }
    
    public boolean isInteger(String string) {
        
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
