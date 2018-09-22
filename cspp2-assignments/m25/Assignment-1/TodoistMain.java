import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */
class Todoist {
	public String getNextTask(String x) {
		return null;
	}
	public Task[] getNextTask(String x, int y) {
		return null;
	}
	public int totalTime4Completion() {
		return -1;
	}
	public void addTask(Task taskobj) {
		//return null;
	}
}
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private boolean important;
	private boolean urgent;
	private String status;
	private int flag;

	/**
	 * Constructs the object.
	 *
	 * @param      title           The title
	 * @param      assignedTo      The assigned to
	 * @param      timeToComplete  The time to complete
	 * @param      important       The important
	 * @param      urgent          The urgent
	 * @param      status          The status
	 */
	Task(final String title, final String assignedTo, final int timeToComplete,
	     final boolean important, final boolean urgent, final String status) {
		flag = 0;
		try {
			if (title != null) {
				this.title = title;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Title not provided");
			flag = 1;
		}
		this.assignedTo = assignedTo;
		try {
			if (timeToComplete > 0) {
			this.timeToComplete = timeToComplete;
			} else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.out.println("Invalid timeToComplete "+timeToComplete);
			flag = 1;
		}
		this.important = important;
		this.urgent = urgent;
		try {
			if (status.equals("todo") || status.equals("done")) {
			this.status = status;		
			} else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			flag = 1;
			System.out.println("Invalid status "+status);
			return ;
		}
		
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @param      task  The task
	 *
	 * @return     String representation of the object.
	 */
	public  String toString() {
		String str = "";
		String cmm = ", ";
		String imp = "";
		String urg = "";
		if (this.important == true) {
			imp = "Important";
		} else {
			imp = "Not Important";
		}
		if (this.urgent == true) {
			urg = "Urgent";
		} else {
			urg = "Not Urgent";
		}
		if (flag != 1) {
			str += title + cmm + assignedTo + cmm + timeToComplete + cmm
		       + imp + cmm + urg + cmm + status ;
		}
		return str;
	}
}
/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				System.out.println(todo);
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			case "get-next-n":
				int n = Integer.parseInt(tokens[2]);
				Task[] tasks = todo.getNextTask(tokens[1], n);
				System.out.println(Arrays.deepToString(tasks));
				break;
			case "total-time":
				System.out.println(todo.totalTime4Completion());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			//System.out.println("hi");
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
