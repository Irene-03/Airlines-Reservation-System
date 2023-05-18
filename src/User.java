public class User {
    private String username;
    private String password;
    private int charge = 0;
    private String notify="";

    public String getNotify() {
        return notify;
    }

    public User(){}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getCharge() {
        return charge;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void updateCharge(int chargeAdded){
        charge += chargeAdded;
    }
    public boolean checkAccount( String username ,String password){
        return (this.username.equals(username) && this.password.equals(password));
    }
    public boolean checkOldPass(String oldPass){
        return oldPass.equals(password);
    }
    public void addNotify(Flight flight) {
        notify+= flight+"\n";
    }
}
