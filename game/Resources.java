package game;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;

/**
 * A class for the rescources in the game.
 * Resources is for example the background and such.
 * @author stohr@kth.se and sabcho@kth.se
 * @version 2018-05-07
 */
public class Resources {
    
    private static Map<String, Image> images;
    private static Map<String, SpriteSheet> sprites;
    private static Map<String, NPC> npcs;
    
    /**
     * A method to intialize the different resources used
     */
    public Resources() {
        images = new HashMap<String, Image>();
        sprites = new HashMap<String, SpriteSheet>();
        npcs = new HashMap<String, NPC>();
        Question question;
        
        try {
            images.put("background", loadImage("res/background.jpg"));
            images.put("player", loadImage("res/spr_m_pjnerd2.png"));
            images.put("npcOne", loadImage("res/spr_f_arctic_lisa.png"));
            images.put("npcTwo", loadImage("res/spr_dog_medium.png"));
            images.put("npcThree", loadImage("res/spr_scarab.PNG"));
            images.put("npcFour", loadImage("res/spr_f_ayla.png"));
            images.put("npcFive", loadImage("res/spr_f_sara.png"));

            question = new Question("How many letters are in the word Red?");

            question.addAnswer("3", true);
            question.addAnswer("5", false);
            question.addAnswer("6", false);
            npcs.put("npcOne", new NPC(question));
            question = new Question("How many letters are in the word Hello?");
            question.addAnswer("3", false);
            question.addAnswer("5", true);
            question.addAnswer("6", false);
            npcs.put("npcTwo", new NPC(question));
            question = new Question("How many letters are in the word Facebook?");
            question.addAnswer("7", false);
            question.addAnswer("9", false);
            question.addAnswer("8", true);
            npcs.put("npcThree", new NPC(question));
            question = new Question("How many letters are in the word University?");
            question.addAnswer("11", false);
            question.addAnswer("10", true);
            question.addAnswer("12", false);
            npcs.put("npcFour", new NPC(question));
            question = new Question("How many letters are in the word Book?");
            question.addAnswer("4", true);
            question.addAnswer("5", false);
            question.addAnswer("3", false);
            npcs.put("npcFive", new NPC(question));
            question.setLastQuestion();

        } catch (SlickException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Load the images used.
     * @param path where the image is stored
     * @return returns image
     * @throws SlickException 
     */
    private Image loadImage(String path) throws SlickException {
        return new Image(path, false, Image.FILTER_NEAREST);
    }
    
    /**
     * Gets the image asked for
     * @param getter the place where the image is stored
     * @return the image
     */
    public static Image getImage(String getter) {
        return images.get(getter);
    }
    
    public static NPC getNPC(String index) {
        return npcs.get(index);
    }
    
    public static Map<String, NPC> getNPCs() {
        return npcs;
    }
}
