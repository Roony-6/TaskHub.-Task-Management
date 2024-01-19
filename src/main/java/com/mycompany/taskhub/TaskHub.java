package com.mycompany.taskhub;

import com.mycompany.taskhub.GUI.Index;
import com.mycompany.taskhub.LOGIC.LogicController;
import com.mycompany.taskhub.LOGIC.Task;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class TaskHub {

    public static LogicController control= new LogicController();
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
     
        Index mainForm= new Index();
        mainForm.setVisible(true);
        mainForm.setLocationRelativeTo(null);
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainForm.setUndecorated(true);  // Eliminar la barra de título
        mainForm.getContentPane().setLayout(new BorderLayout());
        
       // control.deleteTask(1);
       Task task= new Task(1, "Esto es una prueba");
               
       control.createTask(task);
       
       
        
    }
}
