package gr.aueb.cf.accounts.model;

public class Account extends AbstractEntity implements IdentifiableEntity {
    private UserDetails userDetails;
    private String iban;
    private double balance;

    public Account() {
    }

    public Account(String uuid,UserDetails userDetails, String iban, double balance) {
        this.setUuid(uuid);
        this.userDetails = new UserDetails(userDetails);
        this.iban = iban;
        this.balance = balance;
    }

    public Account (Account account) {
        this.setUuid(account.getUuid());
        this.userDetails = new UserDetails(account.getUserDetails());
        this.iban = account.getIban();
    }

    public UserDetails getUserDetails() {
        return new UserDetails(userDetails);
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = new UserDetails(userDetails);
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
        return "Account{" +
                "uuid=" + getUuid() +
                "userDetails=" + userDetails +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (getUserDetails() != null ? !getUserDetails().equals(account.getUserDetails()) : account.getUserDetails() != null)
            return false;
        return getIban() != null ? getIban().equals(account.getIban()) : account.getIban() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserDetails() != null ? getUserDetails().hashCode() : 0;
        result = 31 * result + (getIban() != null ? getIban().hashCode() : 0);
        return result;
    }
}
