import java.util.HashMap;
import java.util.Scanner;

public class admin {
    private int id;
    private int password;
    public static HashMap<Integer, admin> adminsMap = new HashMap<>();

    //constructor
    public admin (int id, int password){
        this.id = id;
        this.password = password;
    }
    // getter method
    public int getAdminId(){
        return id;
    }
    public int getPassword(){
        return password;
    }
    //setter method
    public void setId(int id){
        this.id = id;
    }
    public void setPassword(int password){
        this.password = password;
    }
    public static void addAdmin(admin a) {
        adminsMap.put(a.getAdminId(), a);
    }

    public admin getAdmin(int id) {
        return adminsMap.get(id);
    }
    public static void adminLogin(){
        System.out.println("Enter your ID number and password below to login: ");
        System.out.println("ID:");
        Scanner scnr = new Scanner(System.in);
        int userID = scnr.nextInt();
        if (adminsMap.containsKey(userID)) {
            admin admin = adminsMap.get(userID);
            System.out.println("Enter Password: ");
            int userPass = scnr.nextInt();

            // Call the static method using the class name
            if (userPass == admin.getPassword()) {
                System.out.println("Login successful!");
                adminsView();

            } else {
                System.out.println("Incorrect password. Login failed.");
            }
        } else {
            System.out.println("Incorrect ID. Login failed.");
        }
    }
    public static void adminsView(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nHello admin, choose an option below to continue: ");
        System.out.println("\n 1- search for a patient: ");
        System.out.println("\n 2- create an account for a new patient");
        System.out.println("\n 3- update patient's profile");
        System.out.println("\n 4- Exit");
        int userInput = scnr.nextInt();
        switch(userInput){
            case 1:
                patient.patientSearch();

                break;
            case 2:
                patient.patientRegistration();
                break;
            case 3:
                patient.patientUpdate();
            case 4:
                Main.mainPage.viewMainPage();

        }
    }

 }


