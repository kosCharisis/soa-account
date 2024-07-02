package gr.aueb.cf.accounts.dto;

public class UserDetailsReadOnlyDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private String ssn;

    public UserDetailsReadOnlyDTO() {
    }

    public UserDetailsReadOnlyDTO(String uuid, String firstname, String lastname, String ssn) {
        setUuid(uuid);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
