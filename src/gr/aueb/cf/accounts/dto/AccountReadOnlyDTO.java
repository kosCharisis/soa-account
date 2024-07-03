package gr.aueb.cf.accounts.dto;

public class AccountReadOnlyDTO extends BaseDTO {
    private UserDetailsReadOnlyDTO userDetailsReadOnlyDTO;
    private String iban;
    private double balance;

    public AccountReadOnlyDTO() {
    }

    public AccountReadOnlyDTO(String uuid, UserDetailsReadOnlyDTO userDetailsReadOnlyDTO, String iban, double balance) {
        setUuid(uuid);
        this.userDetailsReadOnlyDTO = userDetailsReadOnlyDTO;
        this.iban = iban;
        this.balance = balance;
    }

    public UserDetailsReadOnlyDTO getUserDetailsReadOnlyDTO() {
        return userDetailsReadOnlyDTO;
    }

    public void setUserDetailsReadOnlyDTO(UserDetailsReadOnlyDTO userDetailsReadOnlyDTO) {
        this.userDetailsReadOnlyDTO = userDetailsReadOnlyDTO;
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

    @Override
    public String toString() {
        return " UUID: " + getUuid()
                + ", κωδ. χρήστη: " + userDetailsReadOnlyDTO.getUuid()
                + ", Firstname: " + userDetailsReadOnlyDTO.getFirstname()
                + ", Lastname: " + userDetailsReadOnlyDTO.getLastname()
                + ", SSN: " + userDetailsReadOnlyDTO.getSsn()
                + ", IBAN: " + getIban()
                + ", Balance: " + getBalance();
    }
}
