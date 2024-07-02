package gr.aueb.cf.accounts.service;

import gr.aueb.cf.accounts.dto.AccountInsertDTO;
import gr.aueb.cf.accounts.dto.AccountUpdateDTO;
import gr.aueb.cf.accounts.model.Account;
import gr.aueb.cf.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.accounts.service.exceptions.UserUuidAlreadyExistsException;

import java.util.List;

public interface IAccountService {
    Account insertAccount(AccountInsertDTO dto)
        throws IbanAlreadyExistsException, UserUuidAlreadyExistsException;

    Account updateAccount(String uuid, AccountUpdateDTO dto)
        throws IbanAlreadyExistsException, UserUuidAlreadyExistsException, AccountNotFoundException;

    void deleteAccountByUuid(String uuid) throws AccountNotFoundException;

    void deleteAccountByIban(String iban) throws AccountNotFoundException;

    Account getAccountByUuid(String uuid) throws AccountNotFoundException;

    Account getAccountByIban(String iban) throws AccountNotFoundException;

    List<Account> getAllAccounts();
}
