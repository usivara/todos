package my.sample.todoapi.dto;

public class Todo {

    private int id;
    private String title;
    private String desc;

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
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
