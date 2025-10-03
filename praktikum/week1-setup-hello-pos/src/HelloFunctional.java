import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {
        // Paradigma fungsional: pakai fungsi murni (lambda)
        BiConsumer<String, String> sayHello = (name, nim) -> 
            System.out.println("Hello World, I am " + name + "-" + nim);

        sayHello.accept("Diva Nur Azizah", "240202859");
    }
}
