
package com.mycompany.taskhub.PERSISTENCE;

import com.mycompany.taskhub.LOGIC.Task;
import com.mycompany.taskhub.PERSISTENCE.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PresistenceController {
    
    TaskJpaController taskControl= new TaskJpaController();
    
    public void createTask(Task task){
        taskControl.create(task);
    }
    public void updateTask(Task task){
        try {
            taskControl.edit(task);
        } catch (Exception ex) {
            Logger.getLogger(PresistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTask(int id){
        
        try {
            taskControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PresistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void findTask(int id){
        taskControl.findTask(id);
    }
    
    
    
    
    
    
    
    
    
}
