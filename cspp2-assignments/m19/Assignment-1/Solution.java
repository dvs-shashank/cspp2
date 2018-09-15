import java.util.Scanner;
class Quiz {
	private int questionCount;
	private Quiz[] questions;
	private String questionTxt;
	private String choices;
	private String correctChoice;
	private int maxMarks;
	private int penalty;
	private String userAns;
	Quiz(String questionTxt, String choices , String correctChoice, int maxMarks, int penalty) {
		this.questionTxt = questionTxt;
		this.choices = choices;
		this.correctChoice = correctChoice;
		this.maxMarks = maxMarks;
		this.penalty = penalty;
	}
	Quiz() {
		questions = new Quiz[10];
		questionCount = 0;
	}
	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}
	public String getQuestionTxt() {
		return this.questionTxt;
	}
	public String getChoices() {
		return this.choices;
	}
	public int getMaxMarks() {
		return this.maxMarks;
	}
	//public int getQuestionCount() {
	//	return this.questionCount;
	//}
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
    	int poolQuestion;
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
                poolQuestion = Integer.parseInt(tokens[1]);
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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        //this.questionCount = questionCount;
    	for(int i = 0; i < questionCount; i++) {
    		String questions = s.nextLine();
    		String[] token = questions.split(":");
    		Quiz questionObj = new Quiz(token[0], token[1], token[2],
    			Integer.parseInt(token[3]), Integer.parseInt(token[4]));
    	}
        // tokenize the question line and create the question object  
        // add the question objects to the Quiz class
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
    	for (int i = 0; i < answerCount ; i++) {
    	System.out.println(quiz.getQuestionTxt()+"("+quiz.getMaxMarks()+")");
    	String[] choice = quiz.getChoices().split(",");
    	System.out.println(choice[0]+"    "+choice[1]+"    "+choice[2]+"    "+choice[3]);
    	}
        // write your code here to display the quiz questions
        for (int i = 0; i < answerCount; i++) {
        	String input = s.nextLine();
        	//int ansChoice = Integer.parseInt(input.substring(6,7));
        	quiz.setUserAns(input);
        }
        // read the user responses from the console
        
        // store the user respones in the quiz object
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        for (int i =0 ;i < 4; i++) {
        	System.out.println("question text 1");
        	System.out.println("Wrong Answer! - Penalty: -4");
        }
    }
}
