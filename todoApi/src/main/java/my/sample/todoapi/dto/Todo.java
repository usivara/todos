package my.sample.todoapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {


    private @Id @GeneratedValue Long id;
    private String title;
    private String desc;

    public Todo() {

    }
    public Todo(String title, String desc){
        this.title = title;
        this.desc = desc;
    }
   // public long getId(){return this.id;}
    public void setId(long id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc(){
        return desc;
    }

}
