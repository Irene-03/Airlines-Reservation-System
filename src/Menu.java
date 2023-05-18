import java.util.Scanner;

public class Menu {
    protected Scanner scanner = new Scanner(System.in);
    protected Flights flights = Flights.getInstance();
    protected Users users = Users.getInstance();


    public int input (){
        String input =scanner.nextLine();
        switch (input){
            case "1","2","3","4","5","6","7","8","9","10" -> {return Integer.parseInt(input);}
            default -> System.out.println("Incorrect input!!");
        }
        return 0;
    }


    public void printInputMenu() {

        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                           WELCOME TO AIRLINE RESERVATION SYSTEM
                ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
                ..........................MENU OPTIONS........................
                                
                    <1> Sign in
                    <2> Sign up
                    <3> Exist
                """);
    }

    public void startMenu() {
        label:
        while (true) {
            printInputMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    signIn();
                }
                case "2" ->{
                    signUp();
                }
                case "3" -> {
                    break label;
                }
                default -> System.out.println("Incorrect input!!");
            }
        }
    }

    private void signUp() {
        String user = inputProcess("username:");
        String pass = inputProcess("password :");
        if(users.findUser(user,pass) == null)
            users.makeUser(user,pass);
        else
            System.out.println("An account with submitted username and password currently existed");

    }

    private void signIn() {
        String user = inputProcess("username:");
        String pass = inputProcess("password :");
        User result =  users.findUser(user, pass);
        if(result == null)
            System.out.println("Incorrect input !!");
        else if (result.getUsername().equals("admin"))
            new AdminMenu();
        else
            new UserMenu(result);
    }

    protected void scheduleProcess() {
        flights.flightSchedule();
        inputProcess("Enter to continue...");
    }

    protected Flight makeFlight() {
        String origin = inputProcess("Origin :");
        String destination = inputProcess("Destination :");
        String date = getDate();
        String time = getTime();
        System.out.println("Price :");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Seats : ");
        int seats = Integer.parseInt(scanner.nextLine());
        Flight flight = new Flight(origin, destination, date, time, price, seats);
        return flight;
    }
    protected String getTime(){
        String tempDate= inputProcess("Enter the time  (like hh:mm)");
        while ((!tempDate.matches("^[0-2]\\d:[0-5]\\d$") && (!tempDate.equals("0")))) {
            System.out.println("incorrect input!!");
            tempDate= inputProcess("Enter the time  (like hh:mm)");
        }
        return tempDate;
    }
    protected String getDate() {
        String tempDate= inputProcess("Enter the date (like: YYYY-MM-DD)");
        while ((!tempDate.matches("^\\d\\d\\d\\d-[0-1]\\d-[0-3]\\d$") &&(!tempDate.equals("0")))) {
            System.out.println("incorrect input!!");
            tempDate= inputProcess("Enter the date (like: YYYY-MM-DD)");
        }
        return tempDate;
    }

    public String inputProcess(String text){
        System.out.println(text);
        return scanner.nextLine();
    }
}
