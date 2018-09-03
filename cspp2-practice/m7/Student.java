import java.text.DecimalFormat;
/**
 * Class for student.
 */
public class Student {
	private String studentName ;
	private String rollNo;
	private double subj1;
	private double subj2;
	private double subj3;
	private double gpa;
	/**
	 * Constructs the object.
	 *
	 * @param      studentName  The student name.
	 * @param      rollNo       The roll no.
	 * @param      subj1        The subj 1.
	 * @param      subj2        The subj 2.
	 * @param      subj3        The subj 3.
	 */
	Student(String studentName,String rollNo,double subj1, double subj2,double subj3) {
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.subj1 = subj1;
		this.subj2 = subj2;
		this.subj3 = subj3;
	}
	/**
	 * Calculates the gpa.
	 *
	 * @param      sub1  The sub 1.
	 * @param      sub2  The sub 2.
	 * @param      sub3  The sub 3.
	 *
	 * @return     The gpa.
	 */
	public double calculateGpa(double sub1, double sub2, double sub3) {
		//DecimalFormat df = new DecimalFormat("#,#");
		this.gpa = (sub1 + sub2 + sub3) / 3;
		gpa = Math.floor(this.gpa*10)/10;
		//df.format(this.gpa);
		return gpa;
	}
	public static void main(String[] args) {
		Student s1 = new Student("Sanjay", "IT201985001", 7.5, 7.0, 8.0);
		double cgpa; 
		cgpa = s1.calculateGpa(s1.subj1,s1.subj2,s1.subj3);
		System.out.println(cgpa);
		Student s2 = new Student("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
		cgpa = s2.calculateGpa(s2.subj1,s2.subj2,s2.subj3);
		System.out.println(cgpa);
		Student s3 = new Student("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
		cgpa = s3.calculateGpa(s3.subj1,s3.subj2,s3.subj3);
		System.out.println(cgpa);
	}

}