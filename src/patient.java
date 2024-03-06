import java.util.HashMap;
import java.util.Scanner;

public class patient {
    private static String firstName;
    private static String lastName;
    private static int id;
    private static int password;
    private static String insuranceName;
    private static int insurance;
    private static int weight;
    private static int bloodPressure;
    private static String report;
    private static String medicationLists;
    public static HashMap<String, patient> patientsMap = new HashMap<>();
    public static HashMap<Integer, patient> patientsLoginMap = new HashMap<>();


    //constructor
    public patient(String firstName, String lastName, int id, int password, int insurance, String insuranceName,int weight,int bloodPressure,String report, String medicationLists) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        this.insuranceName = insuranceName;
        this.insurance = insurance;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.report = report;
        this.medicationLists = medicationLists;

    }

    // getter method
    // Getter for first name
    public static String getFirstName() {
        return firstName;
    }

    // Getter for last name
    public static String getLastName() {
        return lastName;
    }

    public static String getPatientName() {
        return firstName + " " + lastName;
    }
    public static String getInsuranceName(){
        return insuranceName;
    }
    public static int getInsurance(){
        return insurance;
    }

    public static int getPatientId() {
        return id;
    }
    public static int getPassword(){
        return password;
    }
    public static int getWeight(){
        return weight;
    }
    public static int getBloodPressure(){
        return bloodPressure;
    }

    public String getDoctorReport() {
        return report;
    }

    public String getMedicationLists() {
        return medicationLists;
    }

    //setters
    public void setName(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }

    public void setPatientId(int Id) {
        this.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    public void setInsurance(int insurance){
        this.insurance = insurance;
    }
    public void setInsuranceName(String insuranceName){
        this.insuranceName = insuranceName;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setBloodPressure(int bloodPressure){
        this.bloodPressure = bloodPressure;
    }

    public void setReport(String doctorReport) {
        report = doctorReport;
    }

    public void setMedicationLists(String medicationLists) {
        this.medicationLists = medicationLists;
    }

    public void printPatientData() {
        System.out.println("\nPatient's name: " + getPatientName());
        System.out.println("\n\nID: " + getPatientId());
        System.out.println("\n\ninsurance name: " + getInsuranceName() + "\n\ninsurance number: " + getInsurance());
        System.out.println("\n\nPatient's weight: " + getWeight() + " LB" + "\n\nPatients Blood pressure: " + getBloodPressure() + "mmHg");
        System.out.println("\n\nDoctor's Report: " + getDoctorReport());
        System.out.println("\n\nMedication Lists: " + getMedicationLists());
    }

    public static void addPatient(patient p) {
        patientsMap.put(p.getFirstName() + " " + p.getLastName(), p);
    }

    // Retrieve a patient from the HashMap by  full name
    public static patient getPatient(String firstName, String lastName) {
        return patientsMap.get(firstName + " " + lastName);
    }
    public patient getPatient(int patientId) {
        return patientsMap.get(patientId);
    }
    public static void addPatientId(patient p) {
        patientsLoginMap.put(p.getPatientId(), p);
    }

    public static void patientRegistration() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("For registration answer the following questions: ");

        System.out.println("Enter patiens first name: ");

        String firstName = scnr.next();

        System.out.println("Enter patients last Name:");

        String lastname = scnr.next();

        System.out.println("Enter 9 digits for the patients ID(no spaces or characters):");
        int id = scnr.nextInt();

        System.out.println("Enter 9 digits the patients password(no spaces or characters):");

        int password = scnr.nextInt();
        System.out.println("Enter patient' insurance name: ");

        String insuranceName = scnr.next();

        System.out.println("Enter patients insurance number:");

        int insurance = scnr.nextInt();

        patient newPatient = new patient(firstName, lastname, id, password,insurance,insuranceName,0,0,null, null);
        addPatient(newPatient);
        System.out.println("Patient added successfully.");
        patientSearch();
    }

    public static void patientUpdate() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patient first name: ");
        String firstName = scnr.next();
        System.out.println("Enter patient's last name: ");
        String lastName = scnr.next();
        getPatient(firstName, lastName);
        patient patient = getPatient(firstName, lastName);
        if (patient != null) {
            System.out.println("\nFor update answer the following questions: ");

            System.out.println("Enter patiens first name: ");

            String updateFirstName = scnr.next();


            System.out.println("Enter patients last Name:");

            String updateLastName = scnr.next();
            patient.setName(updateFirstName,updateLastName);

            System.out.println("Enter patient' insurance name: ");

            String updateInsuranceName = scnr.next();

            patient.setInsuranceName(updateInsuranceName);

            System.out.println("Enter patients insurance number:");

            int updateInsurance = scnr.nextInt();
            patient.setInsurance(updateInsurance);
            patient.printPatientData();

        }
        else{
            System.out.println("patient not found");
        }
    }

    public static void patientSearch() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patient first name: ");
        String firstName = scnr.next();
        System.out.println("Enter patient's last name: ");
        String lastName = scnr.next();
        getPatient(firstName, lastName);
        patient patient = getPatient(firstName, lastName);
        if (patient != null) {
            patient.printPatientData();
        } else {
            System.out.println("Patient not found.");
            patientSearch();
        }

    }
    public static void doctorPatientSearch() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patient first name: ");
        String firstName = scnr.next();
        System.out.println("Enter patient's last name: ");
        String lastName = scnr.next();
        getPatient(firstName, lastName);
        patient patient = getPatient(firstName, lastName);
        if (patient != null) {
            patient.printPatientData();
            System.out.println("\n\nto add patient's visit summary and prescribe medications press 1.");
            System.out.println("\notherwise press 2 to exit:");
            int doctorInput = scnr.nextInt();
            if( doctorInput == 1){
                System.out.println("type your report:    ");
                scnr.nextLine();
                String report = scnr.nextLine();
                patient.setReport(report);
                System.out.println("Prescribe the necessary medications'");
                String meds = scnr.nextLine();
                patient.setMedicationLists(meds);
                patient.printPatientData();
            }
            else{
                Main.mainPage.viewMainPage();
            }

        } else {
            System.out.println("Patient not found.");
            patientSearch();
        }

    }
    public static void patientLogin(){
        System.out.println("Enter your ID number and password below to login: ");
        System.out.println("ID:");
        Scanner scnr = new Scanner(System.in);
        int userID = scnr.nextInt();
        if (patientsLoginMap.containsKey(userID)){
            patient patient = patientsLoginMap.get(userID);
            System.out.println("Enter Password: ");
            int userPass = scnr.nextInt();

            // Call the static method using the class name
            if (userPass == patient.getPassword()) {
                System.out.println("Login successful!");

            } else {
                System.out.println("Incorrect password. Login failed.");
                patientLogin();
            }
        } else {
            System.out.println("Incorrect ID. Login failed.");
            patientLogin();
        }
    }
    public static void nursePatientSearch(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter patient first name: ");
        String firstName = scnr.next();
        System.out.println("Enter patient's last name: ");
        String lastName = scnr.next();
        getPatient(firstName, lastName);
        patient patient = getPatient(firstName, lastName);
        if (patient != null) {
            patient.printPatientData();
            System.out.println("\n\nto add patient's Weight, and Blood pressure press 1.");
            System.out.println("\notherwise press 2 to exit:");
            int doctorInput = scnr.nextInt();
            if( doctorInput == 1){
                System.out.println("Enter patients weight: ");
                int weight = scnr.nextInt();
                patient.setWeight(weight);
                System.out.println("Enter patient's blood pressure: ");
                int bloodPressure = scnr.nextInt();
                patient.setBloodPressure(bloodPressure);
                patient.printPatientData();
            }
            else{
                Main.mainPage.viewMainPage();
            }

        } else {
            System.out.println("Patient not found.");
            patientSearch();
        }

    }

}
