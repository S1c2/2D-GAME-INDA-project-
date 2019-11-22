package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * A class for storing questions and answers
 * @author stohr@kth.se and sabcho@kth.se
 * @version 2018-05-16
 */
public class Question {
    private String question;
    private HashMap<String, Boolean> answers;
    private boolean lastQuestion;
    
    public Question(String question) {
        this.question = question;
        this.answers = new LinkedHashMap<String, Boolean>();
    }

    public void setLastQuestion(){
        lastQuestion = true;
    }

    public boolean isLastQuestion(){
        return lastQuestion;
    }


    public void addAnswer(String answer, boolean correct) {
        answers.put(answer, correct);
    }
    
    public String getQuestion() {
        return question;
    }
    
    public HashMap<String, Boolean> getAnswers() {
        return answers;
    }
    
    public String getAnswerByNumber(int number) {
        try {
            return (new ArrayList<String>(answers.keySet())).get(number - 1);
        } catch(ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }
    
    public boolean isCorrectAnswer(String answer) {
        if(answers.containsKey(answer)) {
            return answers.get(answer);
        }
        return false;
    }
    
    @Override
    public String toString() {
    	String output = "Question: " +  question;
        int i = 1;
        for(String answer : answers.keySet()) {
            output += "\n" + i + ") " + answer;
            i++;
        }
        return output;
    }
}
