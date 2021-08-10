package Entity;

import Entity.base.BaseEntity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> implements Serializable {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_ID = "user_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USER_ID)
    private Long id;
    @Column(name = USERNAME, unique = true)
    private String username;
    @Column(name = PASSWORD)
    private String password;
//(mappedBy = "users")
    @OneToMany(mappedBy = "user")
   private List<UserActivity> activity;

    public List<UserActivity> getActivity() {
        return activity;
    }

    public void setActivity(List<UserActivity> activity) {
        this.activity = activity;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,UserActivity userActivity) {
        this.username = username;
        this.password = password;
        this.activity = activity;
    }


//    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setId(Long id) {
        this.id = id;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
