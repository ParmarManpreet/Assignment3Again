package com.example.manpreetparmar.assignment3again;

public class Profile {

    private String name;
    private String age;
    private String ID;

    public Profile(String Name,String Age, String id){

        name=Name;
        age=Age;
        ID=id;

    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public  String getAge() {
        return age;
    }

    public  String getID() {
        return ID;
    }
}
