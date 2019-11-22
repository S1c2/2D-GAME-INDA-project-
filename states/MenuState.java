package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A class for the menu-state
 * @author stohr@kth.se
 * @version 2018-05-07
 */
public class MenuState extends BasicGameState{
    
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("Welcome to the menu!", 300, 50);
        g.fillRoundRect(300, 100, 50, 50, 15);
        g.drawString("New game", 380, 112);
        g.setColor(Color.black);
        g.drawString("N", 320, 112);
        g.setColor(Color.red);
        g.fillRoundRect(300, 160, 50, 50, 15);
        g.drawString("Pre-written questions", 380, 172);
        g.setColor(Color.black);
        g.drawString("P", 320, 172);
        g.setColor(Color.red);
        g.fillRoundRect(300, 220, 50, 50, 15);
        g.drawString("Exit", 380, 232);
        g.setColor(Color.black);
        g.drawString("E", 320, 232);
//        g.drawOval(300, 280, 50, 50);
//        g.drawString("New game", 380, 292);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_E)) gc.exit();
        if (gc.getInput().isKeyPressed(Input.KEY_N)) sbg.enterState(States.GAME);
        if (gc.getInput().isKeyPressed(Input.KEY_P)) sbg.enterState(States.GAME);
    }
    
    @Override
    public int getID() {
        return States.MENU;
    }
}
