import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        doctors newDoctor = new doctors("steph", "curry", 123456789, 123456789);
        admin newAdmin = new admin(23456789, 23456789);
        patient newPatient = new patient("sepehr","karkonan",1111, 1234, 555555555, "TUFTS",0, 0, null, null);
        nurse nurse = new nurse("Samuel","Jackson",1234,1234 );
        doctors.doctorsMap.put(123456789, newDoctor);
        admin.adminsMap.put(23456789, newAdmin);
        nurse.nurseMap.put(1234, nurse);
        patient.addPatient(newPatient);

         mainPage.viewMainPage();
    }

    public class mainPage {
        public static void viewMainPage() {
            while (true) {
                System.out.println("\n\nWelcome to patientArchive Program!");

                System.out.println("+--------------------------------------+");
                System.out.println("|                                      |");
                System.out.println("|      Welcome to patientArchive       |");
                System.out.println("|                                      |");
                System.out.println("+--------------------------------------+");


                System.out.println("\n1- Doctors");
                System.out.println("2- Admin");
                System.out.println("3- Nurse");
                System.out.println("4- exit");

                System.out.println("\nChoose an option to continue: ");
                Scanner scnr = new Scanner(System.in);


                int userInput = scnr.nextInt();
                switch (userInput) {
                    case 1:
                        doctors.viewDoctors();
                        break;
                    case 2:
                        admin.adminLogin();
                        break;
                    case 3:
                        nurse.nurseView();
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        }


        public static void viewPatients() {
            Scanner scnr = new Scanner(System.in);
            System.out.println("\n\nWelcome to the Patients Page!");
            System.out.println("Choose an option below to continue: ");
            System.out.println("\n1- Login");
            System.out.println("\n2- Registration");
            int userInput = scnr.nextInt();

            switch(userInput){
                case 1:
                    patient.patientLogin();
                case 2:
                    patient.patientRegistration();

            }
        }
    }
}