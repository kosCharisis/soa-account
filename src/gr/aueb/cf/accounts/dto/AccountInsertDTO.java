package gr.aueb.cf.accounts.dto;

public class AccountInsertDTO extends BaseDTO {
    private UserDetailsInsertDTO userDetailsInsertDTO;
    private String iban;

    private double balance;

    public AccountInsertDTO() {
    }

    public AccountInsertDTO(String uuid, UserDetailsInsertDTO userDetailsInsertDTO, String iban, double balance) {
        setUuid(uuid);
        this.userDetailsInsertDTO = userDetailsInsertDTO;
        this.iban = iban;
        this.balance = balance;
    }

    public UserDetailsInsertDTO getUserDetailsInsertDTO() {
        return userDetailsInsertDTO;
    }

    public void setUserDetailsInsertDTO(UserDetailsInsertDTO userDetailsInsertDTO) {
        this.userDetailsInsertDTO = userDetailsInsertDTO;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
