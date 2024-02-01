package CODEWAY.Task_01.task_02;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentsGrade extends JFrame {
        private JTextField[] subjectFields;
        private  JLabel totalMarksLabel;
        private JLabel averagePercentageLabel;
        private  JLabel gradeLabel;

        public studentsGrade(){
            setTitle("Student Grade Calculator");
            setSize(400,300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            mainComponents();
        }
        private void mainComponents(){
            JPanel mainPanel =  new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

            subjectFields = new JTextField[5];
            for (int i = 0; i < subjectFields.length ; i++) {
                JLabel subjectLabel =  new JLabel("Subject"+ ( i + 1)+ ":");
                subjectFields[i] = new JTextField(5);
                mainPanel.add(subjectLabel);
                mainPanel.add(subjectFields[i]);
            }
            JButton calculateButton = new JButton("Calculate");
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        calculateDisplayResult();
                }
            });
            mainPanel.add(calculateButton);
            totalMarksLabel = new JLabel("Total Marks: ");
            averagePercentageLabel = new JLabel("Average Percentage: ");
            gradeLabel = new JLabel("Grade: ");
            mainPanel.add(totalMarksLabel);
            mainPanel.add(averagePercentageLabel);
            mainPanel.add(gradeLabel);
            add(mainPanel);
        }

        private void calculateDisplayResult(){
            try {
                int[] marks =  new int[subjectFields.length];
                int totalMArks = 0;
                for (int i = 0; i < subjectFields.length ; i++) {
                    marks[i] = Integer.parseInt(subjectFields[i].getText());
                    totalMArks += marks[i];
                }
                double averagePercentage = (double) totalMArks / subjectFields.length;
                String grade;
                if (averagePercentage >= 90) {
                    grade = "A";
                } else if (averagePercentage >= 80) {
                    grade = "B";
                } else if (averagePercentage >= 70) {
                    grade = "C";
                } else if (averagePercentage >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }
                totalMarksLabel.setText("Total Marks: " + totalMArks);
                averagePercentageLabel.setText("Average Percentage: " + String.format("%.2f",averagePercentage)+ "%");
                gradeLabel.setText("Grade: " +grade);
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"Invalid input. Please enter valid integer marks.");
            }
        }

}


