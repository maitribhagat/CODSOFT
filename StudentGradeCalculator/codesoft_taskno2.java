package javacode;
import java.util.Scanner;

		public class StudentGradeCalculator {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Welcome to the Student Grade Calculator!");

		        System.out.print("Enter the student's name: ");
		        String studentName = scanner.nextLine();

		        System.out.print("Enter the number of subjects: ");
		        int numSubjects = scanner.nextInt();

		        double totalMarks = 0.0;
		        double averageGrade;
		        char letterGrade;

		        for (int i = 1; i <= numSubjects; i++) {
		            System.out.print("Enter the marks for subject " + i + ": ");
		            double marks = scanner.nextDouble();
		            totalMarks += marks;
		        }

		        averageGrade = totalMarks / numSubjects;

		        if (averageGrade >= 90) {
		            letterGrade = 'A';
		        } else if (averageGrade >= 80) {
		            letterGrade = 'B';
		        } else if (averageGrade >= 70) {
		            letterGrade = 'C';
		        } else if (averageGrade >= 60) {
		            letterGrade = 'D';
		        } else {
		            letterGrade = 'F';
		        }

		        System.out.println("\nStudent Name: " + studentName);
		        System.out.println("Average Grade: " + averageGrade);
		        System.out.println("Letter Grade: " + letterGrade);

		        scanner.close();
		    }
		

	}
