import java.util.HashMap;
import java.util.Scanner;

public class nurse {
    private String firstName;
    private String lastName;
    private int nurseId;
    public static int password;
    public static HashMap<Integer, nurse> nurseMap = new HashMap<>();
    // Constructor
    public nurse(String firstName, String lastName, int nurseId, int password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nurseId = nurseId;
        this.password = password;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNurseId() {
        return nurseId;
    }

    public static int getPassword() {
        return password;
    }

    // setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNusreId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public static void addNurse(nurse n) {
        nurseMap.put(n.getNurseId(), n);
    }

    public nurse getNurse(int nurseId) {
        return nurseMap.get(nurseId);
    }
    public static void nurseView(){
        System.out.println("\n\nWelcome!");
        System.out.println("Choose a number below to continue");
        System.out.println("\n1- Login");
        System.out.println("\n2- Exit");
        Scanner scnr = new Scanner(System.in);
        int userInput = scnr.nextInt();
        switch (userInput) {
            case 1:
                nurse.nurseLogin();
                break;
            case 2:
                Main.mainPage.viewMainPage();
        }
    }
    public static void nurseLogin(){
        System.out.println("Enter your ID number and password below to login: ");
        System.out.println("ID:");
        Scanner scnr = new Scanner(System.in);
        int userID = scnr.nextInt();

        if (nurseMap.containsKey(userID)) {
            nurse nurse = nurseMap.get(userID);
            System.out.println("Enter Password: ");
            int userPass = scnr.nextInt();

            // Call the static methodq using the class name
            if (userPass == nurse.getPassword()) {
                System.out.println("Login successful!");
                nurseView2();

            } else {
                System.out.println("Incorrect password. Login failed.");
                nurseLogin();

            }
        } else {
            System.out.println("Incorrect ID. Login failed.");
            nurseLogin();
        }

    }
    public static void nurseView2(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome Nurses, choose an option below to continue: ");
        System.out.println("\n1- lookup patient");
        System.out.println("\n2- exit");
        int userInput = scnr.nextInt();
        switch(userInput){
            case 1:
                patient.nursePatientSearch();
                break;
            case 2:
                Main.mainPage.viewMainPage();


        }


    }


}
