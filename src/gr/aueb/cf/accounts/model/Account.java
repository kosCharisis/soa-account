package gr.aueb.cf.accounts.model;

public class Account extends AbstractEntity implements IdentifiableEntity {
    private UserDetails userDetails;
    private String iban;
    private double balance;

    public Account() {
    }

    public Account(UserDetails userDetails, String iban, double balance) {
        this.userDetails = new UserDetails(userDetails);
        this.iban = iban;
        this.balance = balance;
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

        if (Double.compare(getBalance(), account.getBalance()) != 0) return false;
        if (getUserDetails() != null ? !getUserDetails().equals(account.getUserDetails()) : account.getUserDetails() != null)
            return false;
        return getIban() != null ? getIban().equals(account.getIban()) : account.getIban() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getUserDetails() != null ? getUserDetails().hashCode() : 0;
        result = 31 * result + (getIban() != null ? getIban().hashCode() : 0);
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
