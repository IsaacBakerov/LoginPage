import java.lang.reflect.Array;
import java.util.*;

public class UserProperties {
    private String id;
    private String password;
    private String email;
    private String bio;
    private ArrayList<String> inbox = new ArrayList<>();

    public UserProperties(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setInbox(ArrayList<String> inbox) {
        this.inbox = inbox;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public ArrayList<String> getInbox() {
        return inbox;
    }
}
