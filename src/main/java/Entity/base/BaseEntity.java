package Entity.base;

public class BaseEntity <Id>{
    private Id id ;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
