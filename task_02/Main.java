package CODEWAY.Task_01.task_02;

import javax.swing.*;

public class Main  {
    public static void main(String[] args) {
//
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              new  studentsGrade().setVisible(true);

            }
        });
    }
}
