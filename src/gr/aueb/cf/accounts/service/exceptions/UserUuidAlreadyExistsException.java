package gr.aueb.cf.accounts.service.exceptions;

import gr.aueb.cf.accounts.model.Account;

public class UserUuidAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public UserUuidAlreadyExistsException(Account account) {
        super("Account with uuid: " + account.getUuid() + " already exists");
    }
}
