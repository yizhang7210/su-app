package dev.su;

public class Application {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Application().getGreeting());
    }
}
