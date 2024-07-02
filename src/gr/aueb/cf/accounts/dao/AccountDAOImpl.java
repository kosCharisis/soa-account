package gr.aueb.cf.accounts.dao;

import gr.aueb.cf.accounts.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements IAccountDAO {
    private final static List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(String uuid, Account account) {
        Optional<Account> optionalAccount = accounts
                .stream()
                .filter(ac -> ac.getUuid() == uuid)
                .findFirst();
        Account ac = optionalAccount.orElse(null);
        if (ac == null) return null;

        Account accountToReturn = new Account(ac);
        ac.setUuid(account.getUuid());
        ac.setUserDetails(account.getUserDetails());
        ac.setIban(account.getIban());

        return accountToReturn;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Account get(String uuid) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public boolean ibanExists(String iban) {
        return false;
    }

    @Override
    public boolean userUuidExists(String uuid) {
        return false;
    }
}
