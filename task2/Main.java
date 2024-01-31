package CODEWAY.Task_01.task2;

import javax.swing.*;
import java.util.Arrays;

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
