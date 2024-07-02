package gr.aueb.cf.accounts.dto;

public class AccountInsertDTO extends BaseDTO {
    private UserDetailsInsertDTO userDetailsInsertDTO;
    private String iban;

    public AccountInsertDTO() {
    }

    public AccountInsertDTO(String uuid, UserDetailsInsertDTO userDetailsInsertDTO, String iban) {
        setUuid(uuid);
        this.userDetailsInsertDTO = userDetailsInsertDTO;
        this.iban = iban;
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
}
