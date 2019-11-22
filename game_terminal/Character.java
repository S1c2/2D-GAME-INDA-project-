package game_terminal;

/**
 *@author Sabrina Chowdhury
 *@version 2018.04.30
 */

public class Character{

	private int position;
	private String question;
	private String answer;
	private String falseAnswer1;
	private String falseAnswer2;

	public Character(int position,String question, String answer, String falseAnswer1, String falseAnswer2){

		this.position = position;
		this.question = question;
		this.answer = answer;
		this.falseAnswer1 = falseAnswer1;
		this.falseAnswer2 = falseAnswer2;

	}

	public int getCharacterPosition(){

		return position;

	}

	public String getCharacterQuestion(){

		return question;

	}

	public String getCharacterAnswer(){

		return answer;

	}

	public String getCharacterFalseAnswer1(){

		return falseAnswer1;
	}

	public String getCharacterFalseAnswer2(){

		return falseAnswer2;
	}

	public static void main(String [ ] args){

      
    }
}