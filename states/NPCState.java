
package states;

import game.NPC;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 *
 * @author stohr@kth.se and sabcho@kth.se
 * @version 2018-05-14
 */
public class NPCState  extends BasicGameState{
    private StateBasedGame sbg;
    private NPC npc;
    private int correctNr;
    private int wrongNr;
    
    /**
     * Initialize the NPCState
     * @param gc GameContainer
     * @param sbg StateBasedGame
     * @throws SlickException 
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        //QuizGame qg = new QuizGame();
       // qg.preMadeQuiz();

    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString(npc.getQuestion().toString(), 50, 50);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) sbg.enterState(States.MENU);
    }
    @Override
    public void keyReleased(int key, char c) {
        int number = 0;
        if (key == Input.KEY_1) {
            number = 1;
        } else if (key == Input.KEY_2) {
            number = 2;
        } else if (key == Input.KEY_3) {
            number = 3;
        } else if (key == Input.KEY_4) {
            number = 4;
        } else if (key == Input.KEY_5) {
            number = 5;
        } else if (key == Input.KEY_6) {
            number = 6;
        } else if (key == Input.KEY_7) {
            number = 7;
        } else if (key == Input.KEY_8) {
            number = 8;
        } else if (key == Input.KEY_9) {
            number = 9;
        }
        if(number > 0) {
            if(npc.getQuestion().isCorrectAnswer(npc.getQuestion().getAnswerByNumber(number))) {
                sbg.enterState(States.CORRECT);
                correctNr = correctNr+1;
            } else {
                sbg.enterState(States.WRONG);
                wrongNr = wrongNr+1;
            }
            if(wrongNr >= 3 && npc.getQuestion().isLastQuestion() == true){
                sbg.enterState(States.GAMEOVER);
            }
            if(correctNr >=3 && npc.getQuestion().isLastQuestion() == true){
                sbg.enterState(States.WIN);
            }
        }
    }
        
    @Override
    public int getID() {
        return States.NPC;
    }
    
    public void setNPC(NPC npc) {
        this.npc = npc;
    }
    
    public NPC getNPC() {
        return npc;
    }
    
}
