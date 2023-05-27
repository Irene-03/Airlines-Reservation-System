
public class User {
    private String username;
    private String password;
    private int charge = 0;
    private String notify = "";

    public String getNotify() {
        return notify;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getCharge() {
        return charge;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void updateCharge(int chargeAdded) {
        charge += chargeAdded;
    }

    public boolean checkOldPass(String oldPass) {
        return oldPass.equals(password);
    }

    public void addNotify(Flight flight) {
        notify += flight + "\n";
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }
}
