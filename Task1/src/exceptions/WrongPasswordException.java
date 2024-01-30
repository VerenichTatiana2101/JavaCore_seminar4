package exceptions;

public class WrongPasswordException extends Exception {
    String msg;
    

    public WrongPasswordException(String msg) {
        super(msg);
    }



}
