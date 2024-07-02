package gr.aueb.cf.accounts.dao;

import gr.aueb.cf.accounts.model.Account;

import java.util.List;

public interface IAccountDAO {
    Account insert(Account account);
    Account update(String uuid, Account account);
    void delete(String uuid);
    //void delete(String iban);
    Account get(String uuid);
    List<Account> getAll();

    //Account get(String iban);
    boolean ibanExists(String iban);
    boolean userUuidExists(String uuid);
}
