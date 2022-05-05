import java.time.LocalDateTime;

public class User {

    private String name;
    private String surname;
    private long ak;

    public User(String name, String surname, long ak) {
        this.name = name;
        this.surname = surname;
        this.ak = ak;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public long getAk() {
        return ak;
    }

    public User setAk(long ak) {
        this.ak = ak;
        return this;
    }
}
