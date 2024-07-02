package gr.aueb.cf.accounts.service;

import gr.aueb.cf.accounts.dto.AccountInsertDTO;
import gr.aueb.cf.accounts.model.Account;

public interface IAccountService {
    Account insertAccount(AccountInsertDTO dto);
}
