package CODEWAY.Task_01.task2;

import java.util.Scanner;

public class studentsGrade {
    private Scanner sc;
    private   int size;
    private int[] marks;

    private static final  int ARRAY_SIZE = 7;
    private static final  int MAX_MARKS = 100;

    public  studentsGrade(){
        sc = new Scanner(System.in);
        size = ARRAY_SIZE;
        marks = new int[size];
    }
    public  void getGrades(){
        System.out.println("Enter 7 values for marks (out of 100):");
        for (int i = 0; i <size ; i++) {
            System.out.println("Enter marks for Subject " + (i+1)+ ": ");
            marks[i] = sc.nextInt();
        }
    }
    public int calculateTotalMarks(){
        int total =0;
        for (int i = 0; i <size ; i++) {
            total +=marks[i];
        }
        return total;
    }

    public  double calculateAveragePercentage(){
        int totalMarks = calculateTotalMarks();
        return( (double) totalMarks /size) /MAX_MARKS * 100;
    }
    public  String calculateGrade(){
        double averagePercentage = calculateAveragePercentage();
        if(averagePercentage >= 90){
            return "A";
        } else if (averagePercentage >=80) {
            return "B";
        } else if (averagePercentage >=70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        }else {
            return "F";
        }
    }
    public void results(){
        int totalMarks = calculateTotalMarks();
        double averagePercentage = calculateAveragePercentage();
        String grade = calculateGrade();
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + " % ");
        System.out.println("Grade: " + grade);

    }

}
