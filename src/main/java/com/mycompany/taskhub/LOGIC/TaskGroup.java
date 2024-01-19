package com.mycompany.taskhub.LOGIC;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author roony
 */
@Entity
public class TaskGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String groupName;
    
   

    public void TaskGroup(){
        
    }
    
    
    
    public void TaskGroup(int id, String groupName, Task task){
        
        this.id= id;
        this.groupName= groupName;
      
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

   


    
    
    
}
