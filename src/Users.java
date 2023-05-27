
public class Users extends Worker<String , User> {
    private static final Users instance = new Users();

    private Users() {
        add("admin", new User("admin", "admin"));
    }
    public User check( String user , String pass){
        if (existValue(user))
            if(findValue(user).getPassword().equals(pass))
                return findValue(user);
        return null;
    }
    public static Users getInstance() {
        return instance;
    }

}

