import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {
		//choices = new String(100);

	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
	         final int correctAnswer1, final int maxMarks1, final int penalty1) {
		this.questiontext = question1;
		this.choices = choices1;
		this.correctAnswer = correctAnswer1;
		this.maxMarks = maxMarks1;
		this.penalty = penalty1;
		this.response = null;
	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse() {
		//System.out.println(response.substring(7));
		//System.out.println(this.correctAnswer);
		if (response.substring(7).equals(this.correctAnswer)) {
			// System.out.println("shashank");
			//System.out.println("Correct Answer " + "Marks Awarded: " + getMaxMarks());
			return true;
		}
		//System.out.println("Wrong Answer- Penalty!: " + getPenalty());
		return false;
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public String getCorrectAnswer() {
		//return this.correctAnswer;
		return this.correctAnswer+"";
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		//return this.question1;
		return this.questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return this.choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return this.maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return this.penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		this.response = answer;
	}
	
	
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		s = s + getQuestionText();
		s = s + "(" + getMaxMarks() + ")" + "\n";
		for (int i = 0; i < choices.length; i++) {
			s = s + "	" + choices[i];
		}
		return s;
	}

}
/**
 * Class for quiz.
 */
class Quiz {
	/**
	 * { var_description }.
	 */
	private final int onehundred = 100;
	/**
	 * { var_description }.
	 */
	public Question[] questions;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Quiz() {
		questions = new Question[onehundred];
		size = 0;
	}
	/**
	 * Adds a question.
	 *
	 * @param      q     The question
	 */
	public void addQuestion(final Question q) {
		this.questions[size++] = q;
	}
	/**
	 * Gets the question.
	 *
	 * @param      index  The index
	 *
	 * @return     The question.
	 */
	public Question getQuestion(final int index) {
		return questions[index];
	}
	/**
	 * Calculates the score.
	 *
	 * @param      score  The score.
	 *
	 * @return     The score.
	 */
	public int calculateScore(final int score) {
		int totalScore = 0;
		totalScore += score;
		return totalScore;
	}
	/**
	 * Shows the report.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String showReport() {
		String s = "";
		int totalScore = 0;
		for (int i = 0; i < size; i++) {
			System.out.println(questions[i].getQuestionText());
			boolean b = questions[i].evaluateResponse();
			if (b == true) {
				int marks = questions[i].getMaxMarks();
				totalScore += calculateScore(marks);
				System.out.println("sha");
				s = s + "Correct Answer! - Marks Awarded: " + questions[i].getMaxMarks() + "\n";
			} else {
				int marks = questions[i].getPenalty();
				totalScore += calculateScore(marks);
				//System.out.println("shank");
				System.out.println("Wrong Answer- Penalty!: " + questions[i].getPenalty());
			}
		}
		//s = s + "\n";
		s = s + "Total score: " + totalScore;
		//evaluateResponse(getResponse());
		return s;
	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public static void loadQuestions(final Scanner scan,
	                                 final Quiz quiz, final int q) {
		for (int i = 0; i < q; i++) {
			String input = scan.nextLine();
			String[] token = input.split(":");
			String[] choiceArr = token[1].split(",");
			Question questObj = new Question(token[0], choiceArr, Integer.parseInt(token[2]),
			                                 Integer.parseInt(token[3]), Integer.parseInt(token[4]));
			//Quiz.getQuestion(i) = questObj;
			quiz.addQuestion(questObj);
		}
		System.out.println(q + " are added to the quiz");
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public static void startQuiz(final Scanner scan,
	                             final Quiz quiz, final int q) {
		for (int i = 0; i < q; i++) {
			System.out.println(quiz.getQuestion(i));
			String responseFromUser = scan.nextLine();
			quiz.questions[i].setResponse(responseFromUser);
			// Question responses = new Question();
			// responses.setResponse(responseFromUser);
		}
		// write your code here to display the quiz questions on the console.
		// read the user responses from the console using scanner object.
		// store the user respone in the question object
	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.
		//System.out.println(quiz.getQuestion(i));
		System.out.println(quiz.showReport());

	}
}
