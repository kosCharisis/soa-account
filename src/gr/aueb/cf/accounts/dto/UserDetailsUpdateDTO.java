package gr.aueb.cf.accounts.dto;

public class UserDetailsUpdateDTO extends BaseDTO {
    private String firstname;
    private String lastname;

    public UserDetailsUpdateDTO() {

    }

    public UserDetailsUpdateDTO(String uuid, String firstname, String lastname) {
        setUuid(uuid);
        this.firstname = firstname;
        this.lastname = lastname;
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
}
