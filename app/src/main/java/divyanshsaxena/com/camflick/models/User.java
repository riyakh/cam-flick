package divyanshsaxena.com.camflick.models;


import com.google.firebase.database.IgnoreExtraProperties;

public class User {
    public String name;
    public String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
