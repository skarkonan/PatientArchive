import java.util.HashMap;
import java.util.Scanner;

public class doctors {
    private String firstName;
    private String lastName;
    private int doctorId;
    public static int phoneNumber;
    public static HashMap<Integer, doctors> doctorsMap = new HashMap<>();

    // Constructor
    public doctors(String firstName, String lastName, int doctorId, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorId = doctorId;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public static int getPhoneNumber() {
        return phoneNumber;
    }

    // setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void addDoctor(doctors d) {
        doctorsMap.put(d.getDoctorId(), d);
    }

    public doctors getDoctor(int doctorId) {
        return doctorsMap.get(doctorId);
    }

    public static void viewDoctors() {
        System.out.println("\n\nWelcome!");
        System.out.println("Choose a number below to continue");
        System.out.println("\n1- Login");
        System.out.println("\n2- Exit");
        Scanner scnr = new Scanner(System.in);
        int userInput = scnr.nextInt();
        switch (userInput) {
            case 1:
                doctorsLogin();
                break;
            case 2:
                Main.mainPage.viewMainPage();
        }
    }

    public static void doctorsLogin() {
        System.out.println("Enter your ID number and password below to login: ");
        System.out.println("ID:");
        Scanner scnr = new Scanner(System.in);
        int userID = scnr.nextInt();

        if (doctorsMap.containsKey(userID)) {
            doctors doctor = doctorsMap.get(userID);
            System.out.println("Enter Password: ");
            int userPass = scnr.nextInt();

            // Call the static method using the class name
            if (userPass == doctors.getPhoneNumber()) {
                System.out.println("Login successful!");
                doctorsView();

            } else {
                System.out.println("Incorrect password. Login failed.");
            }
        } else {
            System.out.println("Incorrect ID. Login failed.");
        }
    }
    public static void doctorsView(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome Doctors, choose an option below to continue: ");
        System.out.println("\n1- lookup patient");
        System.out.println("\n2- exit");
        int userInput = scnr.nextInt();
        switch(userInput){
            case 1:
                patient.doctorPatientSearch();
                break;
            case 2:
                Main.mainPage.viewMainPage();


        }


    }

}


