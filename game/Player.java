package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import states.NPCState;
import states.States;

/**
 * A class for the player
 * @author stohr@kth.se
 * @version 2018-05-09
 */
public class Player {
    
    private static float speed = 15;
    private static int correctAnswers = 0;
    
    private static Shape player;
    
    private static float initialx = 0;
    private static float currentx = 0;
    
     public Player() {
        this.correctAnswers = correctAnswers;
    }   
    
    /**
     * Initialize the player
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @throws SlickException 
     */
    public void init(GameContainer gc) throws SlickException {
        player = new Rectangle(100, 350, 38, 67); // size 29 so it can move through holes of 30
        initialx = 100;
        currentx = 100;
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        //g.draw(player);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        currentx += speed;
        for(NPC npc : Resources.getNPCs().values()) {
            if(npc.returnNPC().intersects(Player.returnPlayer())) {
                if(!npc.hasCollided()) {
                    npc.collide();
                    NPCState state = (NPCState) sbg.getState(States.NPC);
                    state.setNPC(npc);
                    sbg.enterState(States.NPC);
                }
            }
        }        
    }
    
    public static Shape returnPlayer() {
        return player;
    }
    
    public static void addCorrrectAnswer() {
        correctAnswers ++;
    }
    
    public static int getCorrectAnswers() {
        return correctAnswers;
    }
    
    public static float getXDelta() {
        return currentx - initialx;
    }
}
