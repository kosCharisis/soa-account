package gr.aueb.cf.accounts.model;

public class UserDetails extends AbstractEntity implements IdentifiableEntity {
    private String firstname;
    private String lastname;
    private String ssn;

    public UserDetails() {
    }

    public UserDetails(String  uuid, String firstname, String lastname, String ssn) {
        this.setUuid(uuid);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    public UserDetails(UserDetails userDetails) {
        setUuid(userDetails.getUuid());
        this.firstname = userDetails.getFirstname();
        this.lastname = userDetails.getLastname();
        this.ssn = userDetails.getSsn();
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

    @Override
    public String toString() {
        return "UserDetails{" +
                "uuid= " + getUuid() +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDetails that = (UserDetails) o;

        if (getFirstname() != null ? !getFirstname().equals(that.getFirstname()) : that.getFirstname() != null)
            return false;
        if (getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null)
            return false;
        return getSsn() != null ? getSsn().equals(that.getSsn()) : that.getSsn() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstname() != null ? getFirstname().hashCode() : 0;
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getSsn() != null ? getSsn().hashCode() : 0);
        return result;
    }
}
