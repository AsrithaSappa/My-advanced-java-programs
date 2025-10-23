package model;

public class user {
    private String name;

    public user(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return "Hello, " + name + "! Welcome to the MVC Web App.";
    }
}
