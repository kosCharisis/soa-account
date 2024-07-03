package gr.aueb.cf.accounts.service;

import gr.aueb.cf.accounts.dao.IAccountDAO;
import gr.aueb.cf.accounts.dto.AccountInsertDTO;
import gr.aueb.cf.accounts.dto.AccountUpdateDTO;
import gr.aueb.cf.accounts.dto.UserDetailsInsertDTO;
import gr.aueb.cf.accounts.dto.UserDetailsUpdateDTO;
import gr.aueb.cf.accounts.model.Account;
import gr.aueb.cf.accounts.model.UserDetails;
import gr.aueb.cf.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.accounts.service.exceptions.UserUuidAlreadyExistsException;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }


    @Override
    public Account insertAccount(AccountInsertDTO dto) throws IbanAlreadyExistsException, UserUuidAlreadyExistsException {
        Account account;

        try {
            account = mapAccountFromInsertDTO(dto);

            if(dao.ibanExists(account.getIban())) {
                throw new IbanAlreadyExistsException(account);
            }

            if(dao.userUuidExists(account.getUuid())) {
                throw new UserUuidAlreadyExistsException(account);
            }
            //logging for success
            return dao.insert(account);
        } catch (IbanAlreadyExistsException | UserUuidAlreadyExistsException e) {
            //e.printStackTrace();
            //logging for failure
            throw e;
        }
    }

    private Account mapAccountFromInsertDTO(AccountInsertDTO dto) {
        UserDetails userDetails = mapUserDetailsFromInsertDTO(dto.getUserDetailsInsertDTO());
        return new Account(dto.getUuid(), userDetails, dto.getIban(), dto.getBalance());
    }

    private UserDetails mapUserDetailsFromInsertDTO(UserDetailsInsertDTO dto) {
        return new UserDetails(dto.getUuid(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    private Account mapAccountFromUpdateDTO(AccountUpdateDTO dto) {
        UserDetails userDetails = mapUserDetailsFromUpdateDTO(dto.getUserDetailsUpdateDTO());
        return new Account(dto.getUuid(), userDetails, dto.getIban(), dto.getBalance());
    }

    private UserDetails mapUserDetailsFromUpdateDTO(UserDetailsUpdateDTO dto) {
        return new UserDetails(dto.getUuid(), dto.getFirstname(), dto.getLastname(), dto.getSsn());
    }

    @Override
    public Account updateAccount(String uuid, AccountUpdateDTO newdto)
            throws IbanAlreadyExistsException, UserUuidAlreadyExistsException, AccountNotFoundException {
        Account account;

        try {
            account = mapAccountFromUpdateDTO(newdto);

            if(!dao.userUuidExists(uuid)) {
                throw new AccountNotFoundException(uuid);
            }

            Account oldAccount = dao.get(uuid);

            if(dao.ibanExists(account.getIban()) && !oldAccount.getIban().equals(newdto.getIban()))  {
                throw new IbanAlreadyExistsException(account);
            }

            if(dao.userUuidExists(account.getUuid()) && !oldAccount.getUuid().equals(newdto.getUuid())) {
                throw new UserUuidAlreadyExistsException(account);
            }
            //logging
            return dao.update(uuid, account);
        } catch (IbanAlreadyExistsException | UserUuidAlreadyExistsException | AccountNotFoundException e) {
            //e.printStackTrace();
            //logging
            throw e;
        }
    }

    @Override
    public void deleteAccountByUuid(String uuid) throws AccountNotFoundException {
        try {
            if(!dao.userUuidExists(uuid)) {
                throw new AccountNotFoundException(uuid);
            }
            //logging
            dao.delete(uuid);
        } catch (AccountNotFoundException e) {
            //e.printStackTrace();
            //logging
            throw e;
        }
    }

    @Override
    public void deleteAccountByIban(String iban)
            throws AccountNotFoundException {
        try {
            if(!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            //logging
            dao.delete(iban);
        } catch (AccountNotFoundException e) {
            //e.printStackTrace();
            //logging
            throw e;
        }

    }

    @Override
    public Account getAccountByUuid(String uuid) throws AccountNotFoundException {
        Account account;

        try {
            account = dao.get(uuid);
            if (account == null) {
                throw new AccountNotFoundException(uuid);
            }
            //logging
            return account;
        } catch (AccountNotFoundException e) {
            //e.printStackTrace();
            //logging
            throw e;
        }
    }

    @Override
    public Account getAccountByIban(String iban) throws AccountNotFoundException {
        Account account;

        try {
            account = dao.get(iban);
            if (account == null) {
                throw new AccountNotFoundException(iban);
            }
            //logging
            return account;
        } catch (AccountNotFoundException e) {
            //e.printStackTrace();
            //logging
            throw e;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return dao.getAll(); //Collections.unmodifiableList(dao.getAll());
    }
}
