package gr.aueb.cf.accounts.dto;

public class AccountUpdateDTO extends BaseDTO {
    private UserDetailsUpdateDTO userDetailsUpdateDTO;
    private String iban;
    private double balance;

    public AccountUpdateDTO() {
    }

    public AccountUpdateDTO(String uuid, UserDetailsUpdateDTO userDetailsUpdateDTO, String iban, double balance) {
        setUuid(uuid);
        this.userDetailsUpdateDTO = userDetailsUpdateDTO;
        this.iban = iban;
        this.balance = balance;
    }

    public UserDetailsUpdateDTO getUserDetailsUpdateDTO() {
        return userDetailsUpdateDTO;
    }

    public void setUserDetailsUpdateDTO(UserDetailsUpdateDTO userDetailsUpdateDTO) {
        this.userDetailsUpdateDTO = userDetailsUpdateDTO;
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
