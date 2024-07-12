package data.InfoObjetcs;

import java.util.Date;

public class Ticket {

    private int id;
    private String name;
    private int age;
    private Date creationTime;
    private Date attentionTime;
    private String procedure;
    private char type;


    public Ticket(int id, String name, int age, String procedure, char type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.creationTime = new Date();
        this.attentionTime = null;
        this.procedure = procedure;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }
    

    public void setAge(int age) {
        this.age = age;
    }


    public Date getCreationTime() {
        return creationTime;
    }

    
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }


    public Date getAttentionTime() {
        return attentionTime;
    }

    
    public void setAttentionTime(Date attentionTime) {
        this.attentionTime = attentionTime;
    }


    public String getProcedure() {
        return procedure;
    }

    
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }


    public char getType() {
        return type;
    }


    public void setType(char type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Tiquete [id=" + id + ", name=" + name + ", age=" + age + ", creationTime=" + creationTime
                + ", attentionTime=" + attentionTime + ", procedure=" + procedure + ", type=" + type + "]";
    }  

}
