package com.mycompany.taskhub;

import com.mycompany.taskhub.LOGIC.LogicController;
import com.mycompany.taskhub.LOGIC.Task;

public class TaskHub {

    public static LogicController control= new LogicController();
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
     
        
        
        control.deleteTask(1);
        
    }
}
