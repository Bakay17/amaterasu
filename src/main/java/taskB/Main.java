package taskB;

public class Main {

    public static void main(String[] args) {
        Thread java = new Thread(new Course("Java"));
        Thread go = new Thread(new Course("Go"));
        Thread javaScript = new Thread(new Course("JavaScript"));
        Thread python = new Thread(new Course("Python"));
        Thread php = new Thread(new Course("PHP"));

        try {
            java.start();
            java.join();

            python.start();
            python.join();

            go.start();
            go.join();

            javaScript.start();
            javaScript.join();

            php.start();
            php.join();
        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
