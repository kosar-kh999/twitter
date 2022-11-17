package ir.maktab.service;

import ir.maktab.exception.DuplicateUsernameException;
import ir.maktab.model.Account;
import ir.maktab.repository.AccountRepository;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();

    public void signUp(Account account) {
        accountRepository.creat(account);
    }

    public boolean checkUsername(String username) throws DuplicateUsernameException {
        return accountRepository.checkUsername(username);
    }

    public Account signIn(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    public void editAccount(Account account) {
        accountRepository.update(account);
    }

    public void signOut(Account account) {
        accountRepository.remove(account);
    }
}
