import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
	
	PatientSetUp pSU = new PatientSetUp(); //Allows the methods to be called for patients in the LinkedList.
	
	/*
	 * The first menu to be loaded to the user when the program starts.
	 */
	public void mainMenu() {
		Scanner kB = new Scanner(System.in);
        try{
        System.out.println("----- MAIN MENU -----");
        System.out.println("1. Add Patient:");
        System.out.println("2. Update Patient:");
        System.out.println("3. Check Patient's Position:");
        System.out.println("4. Update Patient's Position:");
        System.out.println("5. Remove Patients from the List:");
        System.out.println("\n0. Exit");
        
        int input = kB.nextInt();
        
        /*
         * Displays all the patients and their data in the LinkedList if thr user enters '111'
         * in the Main Menu.
         */
        if(input == 111) {
        	for(int i=0;i<PatientSetUp.patientList.size();i++) {
	       		PatientSetUp.patientList.get(i).displayPatient(PatientSetUp.patientList.get(i));
        	}
        }
        
        switch (input) {
            case 1:
            	pSU.addPatient();
            	mainMenu();
                break;
            case 2:
            	pSU.updatePatientInfo();
                mainMenu();
                break;
            case 3:
            	pSU.checkPatientPos();
                mainMenu();
                break;
            case 4:
            	pSU.changePatientPos();
                mainMenu();
                break;
            case 5:
            	pSU.deletePatientMenu();
            	mainMenu();
                break;
            case 0:
                System.out.println("THANK YOU - GOODBYE!");
                kB.close();
                System.exit(0);
                break;
            default:
                kB.reset();
                System.out.println("\nERROR - Please try again\n");
                mainMenu();
                break;
        }
        
        }catch(InputMismatchException e){
            kB.reset();
            System.out.println("\nERROR - Please try again!");
            mainMenu();
            kB.nextInt();
        }
    }

}
