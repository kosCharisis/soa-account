package gr.aueb.cf.accounts.service.exceptions;

import gr.aueb.cf.accounts.model.Account;
import gr.aueb.cf.accounts.model.UserDetails;

public class AccountNotFoundException extends Exception {
    private static final long serialVersionUID = 45654L;

    public AccountNotFoundException(String iban) {
        super("Account with IBAN: " + iban + " not found");
    }

    public AccountNotFoundException(Account account) {
        super("Account with uuid: " + account.getUuid() + " not found");
    }

    public AccountNotFoundException(UserDetails userDetails) {
        super("Account with ssn: " + userDetails.getSsn() + " not found");
    }

}
