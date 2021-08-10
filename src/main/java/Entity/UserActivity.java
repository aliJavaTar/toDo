package Entity;

import Entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "activity")
public class UserActivity extends BaseEntity<Long> {
    public static final String STATUS = "status";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = STATUS)
    private String status;
    @ManyToOne
    private User user;
    public UserActivity() {
    }

    public UserActivity(String status) {
        this.status = status;
    }

    public UserActivity(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Id
//    @GeneratedValue
    public Long getId() {
        return id;
    }
}
