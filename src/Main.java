
import gamelogic.Game;
import gui.Draw;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olli
 */
public class Main {
    
    public static void main(String args[]){
        
        Draw draw = new Draw();
        Game game = new Game(draw);
        
        game.run();
    }
}
