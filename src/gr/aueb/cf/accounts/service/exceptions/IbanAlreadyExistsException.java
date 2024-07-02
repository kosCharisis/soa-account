package gr.aueb.cf.accounts.service.exceptions;

import gr.aueb.cf.accounts.model.Account;

public class IbanAlreadyExistsException extends Exception {
    private final static long serialVersionUID =1L;

    public IbanAlreadyExistsException(Account account) {
        super("Account with IBAN: " + account.getIban() + " already exists");
    }
}
