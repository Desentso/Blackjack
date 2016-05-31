
package gui;

import gamelogic.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Olli
 */
public class StandButtonListener implements ActionListener{

    private Game game;
    
    public StandButtonListener (Game game){
        
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        this.game.playerStand();
    }
    
}
