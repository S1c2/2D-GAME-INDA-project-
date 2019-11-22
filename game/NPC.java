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
 * A class to handle the NPCs
 * @author stohr@kth.se
 * @version 2018-05-09
 */
public class NPC {
    
    private Shape NPC;
    private Question question;
    private boolean collision;
    
    private float initialx = 0;
    private float vY = 0;
    private float offset = 15;
    
    public NPC(Question question) {
        this.question = question;
        this.collision = false;

    }
    
    /**
     * Initialize the NPC
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @throws SlickException 
     */
    public void init(GameContainer gc, int xpos, int ypos) throws SlickException {
        NPC = new Rectangle(xpos, ypos, 32, 80); 
        initialx = xpos;
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.blue);
        g.draw(NPC);
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // offset += speed;
        // Move the NPC X
        NPC.setX(initialx - Player.getXDelta());
    }
    
    public Shape returnNPC() {
        return NPC;
    }
    
    public Question getQuestion() {
        return question;
    }


    public void collide() {
        collision = true;
    }
    
    public boolean hasCollided() {
        return collision;
    }
}
