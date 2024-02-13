import java.util.ArrayList;
import java.util.Scanner;

class Grade {
    private String courseName;
    private double grade;

    public Grade(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getGrade() {
        return grade;
    }
}
class Student{
	private String studentname;
	private ArrayList<Grade> Grades;
	Student(String name){
		this.studentname=name;
		this.Grades=new ArrayList<>();
	}
	void addgrade(String course,double grade){
		Grade newGrade = new Grade(course, grade);
        Grades.add(newGrade);
        System.out.println("Grade added successfully for " + studentname + " in " + course);
	}
	void display(){
		for(Grade grade1:Grades){
			System.out.println("Course:"+grade1.getCourseName());
			System.out.println("Grade:"+grade1.getGrade());
		}
	}
	String getName(){
		return studentname;
	}
	double average(){
		double sum=0,n=Grades.size();
		for(Grade grade:Grades){
			sum+=grade.getGrade();
		}
		return sum/n;
	}
}
public class StudentGrade{
	public static void main(String args[]){
		int choice;
		ArrayList <Student> students=new ArrayList <>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nStudent Grade Tracker:");
        System.out.println("1. Add Student");
        System.out.println("2. Add Grade");
        System.out.println("3. Display Grades");
        System.out.println("4. Exit");
		do{
			System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice){
				case 1:
				    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student newStudent = new Student(studentName);
                    students.add(newStudent);
                    System.out.println("Student added successfully.");
                    break;
				case 2:
				    if (students.isEmpty()) {
                        System.out.println("No students available. Please add a student first.");
                        break;
                    }

                    System.out.print("Enter student name: ");
                    String studentToAddGrade = scanner.nextLine();
                    Student selectedStudent = null;

                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(studentToAddGrade)) {
                            selectedStudent = student;
                            break;
                        }
                    }

                    if (selectedStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    selectedStudent.addgrade(courseName, grade);
                    break;
				case 3:
				    if (students.isEmpty()) {
                        System.out.println("No students available. Please add a student first.");
                        break;
                    }

                    System.out.print("Enter student name: ");
                    studentToAddGrade = scanner.nextLine();
                    selectedStudent = null;

                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(studentToAddGrade)) {
                            selectedStudent = student;
                            break;
                        }
                    }

                    if (selectedStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    selectedStudent.display();
                    System.out.println("Average Grade: "+selectedStudent.average());
                    break;
				case 4:
				    System.out.println("Exiting Student Grade Tracker. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice!=4);
	}
}