package states;

import game.Player;
import game.Resources;
import org.newdawn.slick.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A class for the game-state
 * @author stohr@kth.se
 * @version 2018-05-07
 */
public class GameState extends BasicGameState{
    private Player player;
    
    /**
     * Initialize the game
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @throws SlickException 
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        player = new Player();
        player.init(gc);
        Resources.getNPC("npcOne").init(gc, 250, 325);
        Resources.getNPC("npcTwo").init(gc, 500, 325);
        Resources.getNPC("npcThree").init(gc, 750, 325);
        Resources.getNPC("npcFour").init(gc, 1000, 325);
        Resources.getNPC("npcFive").init(gc, 1250, 325);
    }
    
    /**
     * What happens in the game.
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @param g Graphics
     * @throws SlickException 
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        Resources.getImage("background").draw(-Player.getXDelta(), 0);
        Resources.getImage("player").draw(100, 350);
        Resources.getImage("npcOne").draw(250-Player.getXDelta(), 325);
        Resources.getImage("npcTwo").draw(500-Player.getXDelta(), 325);
        Resources.getImage("npcThree").draw(750-Player.getXDelta(), 350);
        Resources.getImage("npcFour").draw(1000-Player.getXDelta(), 325);
        Resources.getImage("npcFive").draw(1250-Player.getXDelta(), 350);
        g.setColor(Color.white);
        g.drawString("Welcome to the game of questions!", 50, 50);
        player.render(gc, g);
//        Resources.getNPC("npcOne").render(gc, g);
//        Resources.getNPC("npcTwo").render(gc, g);
//        Resources.getNPC("npcThree").render(gc, g);
//        Resources.getNPC("npcFour").render(gc, g);
//        Resources.getNPC("npcFive").render(gc, g);
    }
    
    /**
     * What happens when a key is pressed
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @param delta delta
     * @throws SlickException 
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) sbg.enterState(States.MENU);        
        if (gc.getInput().isKeyPressed(Input.KEY_RIGHT)) {
            player.update(gc, sbg, delta);
            Resources.getNPC("npcOne").update(gc, sbg, delta);
            Resources.getNPC("npcTwo").update(gc, sbg, delta);
            Resources.getNPC("npcThree").update(gc, sbg, delta);
            Resources.getNPC("npcFour").update(gc, sbg, delta);
            Resources.getNPC("npcFive").update(gc, sbg, delta);
        }
    }
    
    /**
     * Getting the ID of the state
     * @return ID of the state
     */
    @Override
    public int getID() {
        return States.GAME;
    }
}
