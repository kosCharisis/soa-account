package gr.aueb.cf.mobilecontacts.dto;

public class UserDetailsUpdateDTO extends BaseDTO{
    private String firstname;
    private String lastname;

    public UserDetailsUpdateDTO(){

    }

    public UserDetailsUpdateDTO(long id, String firstname, String lastname) {
        setId(id);
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
