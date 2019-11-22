package game;

/**
 * A class for the game-engine.
 * Here the game is initialized 
 * @author stohr@kth.se
 * @version 2018-05-04
 */
import java.io.File;

import states.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.*;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame {
    private Command jump = new BasicCommand("jump");
    public static boolean _APPLET = true;
    
    /**
     * A method to create the engine
     * @param title the name of the game 
     */
    public Engine(String title) {
        super(title);
    }
    
    public static void main(String[] args) {
        _APPLET = false;
        
        //Set natives folder
        File f = new File("natives");
        if (f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
        
        try {
            AppGameContainer game = new AppGameContainer(new Engine("Game of questions"));
            game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
            game.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
   
    /**
     * Initiates the game
     * @param gc information about the game
     * @throws SlickException 
     */
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
            gc.setTargetFrameRate(60);
            gc.setMaximumLogicUpdateInterval(60);
            gc.setAlwaysRender(true);
            gc.setVSync(true);
            gc.setShowFPS(false);
            
            new Resources();
            
            this.addState(new MenuState());
            this.addState(new GameState());            
            this.addState(new GameOverState());
            this.addState(new NPCState());
            this.addState(new WinState());
            this.addState(new CorrectState());
            this.addState(new WrongState());
//        InputProvider provider = new InputProvider(gc.getInput());
//        provider.addListener(this);
//        provider.bindCommand(Input.KEY_UP, jump);
    }
    

    
}
