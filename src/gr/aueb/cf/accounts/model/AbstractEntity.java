package gr.aueb.cf.accounts.model;

public abstract class AbstractEntity implements IdentifiableEntity {
    private String  uuid;

    @Override
    public String uuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
