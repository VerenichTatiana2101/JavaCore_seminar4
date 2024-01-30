package domen;

public class Main {
    public static void main(String[] args) {
        String path = "Task1\\src\\domen\\except.txt";
        String file = "Task1\\src\\domen\\file.txt";

        System.out.println(PasswordReader.checkInputData(file, path));
    }
}
