package game_terminal;
/**
*@author Sabrina Chowdhury
*@version 2018.04.30
*/

import java.util.*;

public class QuizGame{

	static HashMap<String, String> questionsAnswersMap = new HashMap<String, String>();
	static ArrayList<String> questionList = new ArrayList<String>();
	static Scanner input = new Scanner(System.in);
	
	static ArrayList<Character> characterList = new ArrayList<Character>();
	static int nrOfQuestions;

	
    
    public QuizGame() {
    
    }

    public void preMadeQuiz(){

    	addNewCharacter(0, "How many letters are in the word Red?, answer with a digit please","3","4","5");
    	addNewCharacter(1, "How many letters are in the word Hello?, answer with a digit please","5","10","6");
    	addNewCharacter(2, "How many letters are in the word Facebook?, answer with a digit please","8","9","7");
    	addNewCharacter(3, "How many letters are in the word University?, answer with a digit please","10","11","9");
    	addNewCharacter(4, "How many letters are in the word Book?, answer with a digit please","4","6","5");

    }

	/**
	 * Takes input from the user in the beginning on question, two false answers and one correct answer
	 * @param characterPosition position of the character/question
	 */
	public void getQuestionsAndAnswers(int characterPosition){

    	
    	String question, rightAnswer, falseAnswer1,falseAnswer2;
    	input.useDelimiter("\n");


    	System.out.println("			Question " + (characterPosition + 1) + " : \n");
    	question = input.next();
    	questionList.add(question);
		//System.out.println(question);
		System.out.println("			Right Answer: \n");
    	rightAnswer = input.next();
		//System.out.println(rightAnswer);
		System.out.println("			False Answer 1: \n");
    	falseAnswer1 = input.next();
		//System.out.println(falseAnswer1);
		System.out.println("			False Answer 2: \n");
    	falseAnswer2 = input.next();
		//System.out.println(falseAnswer2);

    	questionsAnswersMap.put(question, rightAnswer);

    	addNewCharacter(characterPosition, question,rightAnswer,falseAnswer1,falseAnswer2);

    }

	/**
	 * Adds a new character with its own question to the game
	 * @param characterPosition
	 * @param question
	 * @param rightAnswer
	 * @param falseAnswer1
	 * @param falseAnswer2
	 */
    public void addNewCharacter(int characterPosition, String question, String rightAnswer,String falseAnswer1,String falseAnswer2){

    	Character character;

    	character = new Character(characterPosition, question,rightAnswer,falseAnswer1,falseAnswer2);

    	characterList.add(character);

    }

    /*

    public void addNewQuiz(String quizName, List<Character> characterList){

    	Quiz quiz;

    	quiz = new Quiz(1, characterList);

    	quizList.add(quiz);

    }

    */

    public static void newGame(){

    	QuizGame qg = new QuizGame();
    	PrintWindow pw = new PrintWindow();

    	pw.openingMessage();

    	pw.askForNrOfQuestions();
    	nrOfQuestions = input.nextInt();

        for(int i = 0; i<nrOfQuestions; i++){
    		qg.getQuestionsAndAnswers(i);
    	}

    	for(int i = 0; i<nrOfQuestions; i++){
    		pw.displayQandA(i);
    	}

    	for(int i = 0; i<nrOfQuestions; i++){
    		pw.askQuestion(i);
    	}

    }

    public static void oldGame(){

    	QuizGame qg = new QuizGame();
    	PrintWindow pw = new PrintWindow();

    	pw.openingMessage();

    	//pw.askForNrOfQuestions();
    	//nrOfQuestions = input.nextInt();

    	/*
        for(int i = 0; i<nrOfQuestions; i++){
    		qg.getQuestionsAndAnswers(i);
    	}
    	*/

    	qg.preMadeQuiz();

    	for(int i = 0; i<characterList.size(); i++){
    		pw.displayQandA(i);
    	}

    	for(int i = 0; i<characterList.size(); i++){
    		pw.askQuestion(i);
    	}

    }

    public static void main(String [ ] args){

    	QuizGame qg = new QuizGame();
    	PrintWindow pw = new PrintWindow();

    	String userAnswer;

    	System.out.println("Old or new game? Answer with old/new");
    	userAnswer = input.next();
    	

    	if(userAnswer.equals("new")){

    		newGame();
    	
    	}

    	if(userAnswer.equals("old")){

    		oldGame();

    	}
      
	}

}
