package game_terminal;
/**
 *@author Sabrina Chowdhury
 *@version 2018.04.30
 */

import java.util.*;

public class PrintWindow extends QuizGame{

	public PrintWindow(){
    
    }

	public void openingMessage(){
    	System.out.println("\n \n \n 			Welcome to -QuizGame- \n 			Add your questions and answers \n \n \n ");
    }

    public void askForNrOfQuestions(){
    	System.out.println("			How many questions?: \n");
    }

	/**
	 * Displays the question and the right answer for a specific character (based on its position)
	 * @param characterPosition the position of the character
	 */
	public void displayQandA(int characterPosition){

    	String q, a;

    	q = characterList.get(characterPosition).getCharacterQuestion();
    	a = characterList.get(characterPosition).getCharacterAnswer();

    	System.out.println("Question " + (characterPosition + 1) + " : " + q);
    	System.out.println("Answer " + (characterPosition + 1) +  " : " + a);


    }

	/**
	 * Takes the position of the character, asks the user the question for this character
	 * Displays the three possible answers in random order
	 * Displays correct/wrong depending on what the user answers
	 * @param characterPosition the position of the character
	 */
	public void askQuestion(int characterPosition){

    	List<String> possibleAnswersList = new ArrayList<String>();
		

    	String question, answer,false1,false2, userAnswers;
    	input.useDelimiter("\n");

    	question = characterList.get(characterPosition).getCharacterQuestion();
    	answer = characterList.get(characterPosition).getCharacterAnswer();
    	false1 = characterList.get(characterPosition).getCharacterFalseAnswer1();
    	false2 = characterList.get(characterPosition).getCharacterFalseAnswer2();

    	possibleAnswersList.add(answer);
    	possibleAnswersList.add(false1);
    	possibleAnswersList.add(false2);

    	Collections.shuffle(possibleAnswersList);

    	System.out.println("Question " + (characterPosition +1) + ": " +  question + "\n a) " + possibleAnswersList.get(0) + "\n b) " + possibleAnswersList.get(1) + "\n c) " + possibleAnswersList.get(2));

    	userAnswers = input.next();

    	System.out.println(userAnswers);

    	if(userAnswers.equals("a") && answer.equals(possibleAnswersList.get(0))){
    		System.out.println("CORRECT!");
    	}
    	else if(userAnswers.equals("b") && answer.equals(possibleAnswersList.get(1))){
    		System.out.println("CORRECT!");
    	}
    	else if(userAnswers.equals("c") && answer.equals(possibleAnswersList.get(2))){
    		System.out.println("CORRECT!");
    	}
    	else{
    		System.out.println("WRONG!");
    		System.exit(0);
    	}


    }


}
