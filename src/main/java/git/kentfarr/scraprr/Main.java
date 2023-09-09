package git.kentfarr.scraprr;


public class Main {
    public static void main(String[] args) {
        try {
            new menu();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

