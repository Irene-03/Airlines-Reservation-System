import java.util.Scanner;

public class Menu {
    protected Scanner scanner = new Scanner(System.in);
    protected Flights flights = Flights.getInstance();
    protected Tickets tickets = Tickets.getInstance();
    protected Users users = Users.getInstance();


    public int inputNumber (){
        while (true) {
            String input =scanner.nextLine();
            if (input.matches("\\d+")) return Integer.parseInt(input);
            else System.out.println("Incorrect input!!");
        }
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
                case "1" -> signIn();
                case "2" ->signUp();
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
        if(!users.existValue(user))
            users.add(user,new User(user,pass));
        else
            System.out.println("An account with submitted username and password currently existed");

    }

    private void signIn() {
        String user = inputProcess("username:");
        String pass = inputProcess("password :");
        User result =  users.check(user, pass);
        if(result == null)
            System.out.println("Incorrect input !!");
        else if (result.getUsername().equals("admin"))
            new AdminMenu();
        else
            new UserMenu(result);
    }

    public static void printFlight(String flight){
        System.out.println(flight);
    }

    protected Flight makeFlight() {
        String origin = inputProcess("Origin :");
        String destination = inputProcess("Destination :");
        String date = getDate();
        String time = getTime();
        System.out.println("Price :");
        int price = inputNumber();
        System.out.println("Seats : ");
        int seats = inputNumber();
        return new Flight(origin, destination, date, time, price, seats);
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
