package gr.aueb.cf.accounts.dto;

public class AccountUpdateDTO extends BaseDTO {
    private UserDetailsUpdateDTO userDetailsUpdateDTO;
    private String iban;

    public AccountUpdateDTO() {
    }

    public AccountUpdateDTO(String uuid, UserDetailsUpdateDTO userDetailsUpdateDTO, String iban) {
        setUuid(uuid);
        this.userDetailsUpdateDTO = userDetailsUpdateDTO;
        this.iban = iban;
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
}
