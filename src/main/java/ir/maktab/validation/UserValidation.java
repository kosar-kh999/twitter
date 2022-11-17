package ir.maktab.validation;

import ir.maktab.exception.ValidationException;

import java.util.regex.Pattern;

public class UserValidation {
    public static void checkPhoneNumberValid(String phoneNumber) throws ValidationException {
        if (!Pattern.matches("^09[0|123]\\d{8}$", phoneNumber))
            throw new ValidationException("Your phone number is not valid");
    }

    public static void checkPassword(String password) throws ValidationException {
        if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$",
                password))
            throw new ValidationException("Your password is not valid");
    }

    public static void checkUsername(String username) throws ValidationException {
        if (!Pattern.matches("/^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$/", username))
            throw new ValidationException("Your password is not valid");
    }

    public static void checkFullName(String fullName) throws ValidationException {
        if (!Pattern.matches("^[A-Z]'?[- a-zA-Z]( [a-zA-Z])*$", fullName))
            throw new ValidationException("Your password is not valid");
    }
}
