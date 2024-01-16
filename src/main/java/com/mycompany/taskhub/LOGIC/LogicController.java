
package com.mycompany.taskhub.LOGIC;
import com.mycompany.taskhub.PERSISTENCE.PresistenceController;
public class LogicController {
    
PresistenceController control= new PresistenceController();

public void createTask(Task task){
    control.createTask(task);
}

public void deleteTask(int id){
    control.deleteTask(id);
}
    
public void updateTask(Task task){
    control.updateTask(task);
}
    
public void findTask(int id){
    control.findTask(id);
}

}

