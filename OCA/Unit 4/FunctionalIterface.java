@FunctionalInterface
interface Greetings {
    void greet(String name);
}

class Gr1eetings {
    String greets(String name) {
        return "Hello " + name;
    }
}

public class FunctionalIterface {
    public static void main(String[] args) {
        String b = "Me";
        Greetings greet = (String name) -> {
            System.out.println("fsfsdf" + name);// return "Hello, " + name;
        };
        Gr1eetings g1 = new Gr1eetings();
        System.out.println(g1.greets(b));
        // Optionally, print the result of the lambda:
        greet.greet(b);
    }
}