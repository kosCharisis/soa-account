package gr.aueb.cf.accounts.dto;

public class AccountReadOnlyDTO extends BaseDTO {
    private UserDetailsReadOnlyDTO userDetailsReadOnlyDTO;
    private String iban;

    public AccountReadOnlyDTO() {
    }

    public AccountReadOnlyDTO(String uuid, UserDetailsReadOnlyDTO userDetailsReadOnlyDTO, String iban) {
        setUuid(uuid);
        this.userDetailsReadOnlyDTO = userDetailsReadOnlyDTO;
        this.iban = iban;
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
}
