import java.util.ArrayList;

public class Users {
    ArrayList <User> users = new ArrayList<>();
    private static final Users instance = new Users();

    private Users() {
    }

    public static Users getInstance() {
        return instance;
    }

    public User findUser(String user, String pass) {
        if (user.equals("admin") && pass.equals("admin"))
            return(new User(user , pass));
        for (User user1 : users)
            if (user1.checkAccount(user, pass))
                return user1;

        return null;
    }

    public void makeUser(String user, String pass) {
        users.add(new User(user,pass));
    }
}

