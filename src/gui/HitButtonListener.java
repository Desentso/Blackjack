
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
