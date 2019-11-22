
package states;

import game.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A state when player answers correct
 * @author stohr@kth.se
 * @version 2018-05-14
 */
public class CorrectState  extends BasicGameState{
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Correct! Good job!", 50, 50);
        g.drawString("Press space to return to the game", 50, 100);        
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) sbg.enterState(States.MENU);
        if (gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            if(Player.getCorrectAnswers() == 3){
                sbg.enterState(States.WIN);
            } else{
                sbg.enterState(States.GAME);
            }
        }  
    }
    
        
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) {
        Player.addCorrrectAnswer();
    }
    
    @Override
    public int getID() {
        return States.CORRECT;
    }
}
