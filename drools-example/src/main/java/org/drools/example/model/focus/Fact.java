package org.drools.example.model.focus;

/**
 * @author : kenny
 * @since : 2023/6/30
 **/
public class Fact {
    private String name;
    private int age;

    public Fact(String name, int age) {
        this.name = name;
        this.age = age;
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
}

