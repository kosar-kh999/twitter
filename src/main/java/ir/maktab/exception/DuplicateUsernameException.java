package ir.maktab.exception;

public class DuplicateUsernameException extends Exception {
    public DuplicateUsernameException(String errorMessage) {
        super(errorMessage);
    }
}
