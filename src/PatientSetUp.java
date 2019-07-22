import java.util.InputMismatchException;
import java.util.Scanner;


public class PatientSetUp {
	
	static MyLinkList<Patient> patientList = new MyLinkList<Patient>(); //The LinkedList that takes in Patient objects.
	
	Patient patient; //The patient that is called by the user.

	
	/*
	 * Searches the list and returns a patient 
	 * using their Patient Identity Number (PID).
	 */
	public void getPatientByPID() {
		Scanner kB = new Scanner(System.in);
		boolean found = false;
		
		System.out.println("Please enter the PID: ");

		int pid = kB.nextInt();
	
		for(int i=0;i<patientList.size();i++) { //Iterates through the list
			patient = patientList.get(i);
			if(patient.getPID() == pid && pid < patientList.size()+1 && pid != 0) { //Checks to see if patient is in the list
				found = true;
				patient = patientList.get(i); //Sets the patient to the patient with the corresponding PID
				break;
			}	
		}
		if(found == false || pid > patientList.size() || pid <= 0) { //Reruns the method if patient is not found (does not exist)
			System.out.println("\nERROR - No Patient Exists");
			getPatientByPID();
		}	
	}
	
	/*
	 * Adds a patient to the LinkedList. 
	 */
	public void addPatient() {
		Scanner kB = new Scanner(System.in);
		
		try{
			
		Patient patient = new Patient(" "," "," "," "," ",0); //Adds a new patient with no values.
		
		System.out.println("\n----- ADD PATIENT -----");
		selectFName(patient);
		selectLName(patient);
		selectMobile(patient);
		selectEmail(patient);
		selectCity(patient);
		selectPPS(patient);
		
		System.out.println("Is it an Emergency?");
		System.out.println("1: Yes");
		System.out.println("2: No");
		
		switch (kB.nextInt()) {
		case 1: //If user selects yes to an emergency then the patient is added to the first position of the LinkedList.
			patientList.addFirst(patient);
        	System.out.println("\nNEW PATIENT ADDED!");
        	patient.displayPatient(patient);
        break;
		case 2: //If user selects no to an emergency then the patient is added to the end of the LinkedList
    		patientList.add(patient);
        	System.out.println("\nNEW PATIENT ADDED!");
    		patient.displayPatient(patient);
        break;
        default:
    		System.out.println("\nERROR - Please try again");
    	break;
		}
        }catch(InputMismatchException e){
            System.out.println("\nERROR - Please try again");
            addPatient();
        }
	}
	
	/*
	 * Updates a patietnt's personal information.
	 */
	public void updatePatientInfo() {
		Scanner kB = new Scanner(System.in);
		
		getPatientByPID();
		
		patient.displayPatient(patient); //Displays the patient the user selected.
			
		System.out.println("----- UPDATE PATIENT -----"); //Displays which field to update to the user.
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Mobile Number");
        System.out.println("4. Email Address");
        System.out.println("5. City");
        System.out.println("6. PPS Number");
        System.out.println("\n0. Cancel");
              
        int input = kB.nextInt();
        
        switch (input) {
        case 1:
        	selectFName(patient);
        	System.out.println("PATIENT UPDATED!");
        	patient.displayPatient(patient);
            break;
        case 2:
        	selectLName(patient);
        	System.out.println("PATIENT UPDATED!");
        	patient.displayPatient(patient);
            break;
        case 3:
        	selectMobile(patient);
        	System.out.println("PATIENT UPDATED!");
        	patient.displayPatient(patient);
            break;
        case 4:
        	selectEmail(patient);
        	System.out.println("PATIENT UPDATED!");
        	patient.displayPatient(patient);
            break;
        case 5:
        	selectCity(patient);
        	System.out.println("PATIENT UPDATED!");
        	patient.displayPatient(patient);
            break;
        case 6:
        	selectPPS(patient);
        	System.out.println("PATIENT UPDATE!");
        	patient.displayPatient(patient);
            break;
        case 0:
            break;
        default:
        	System.out.println("\nERROR- Please try again");
            updatePatientInfo();
            break;
        }
	}
	
	/*
	 * Returns a patient at a certain index of the LinkedList.
	 */
	public void checkPatientPos() {	
		getPatientByPID();
		
		System.out.println("\n'"+patient.getFisrtName()+" "+patient.getLastName()+"' is: "+
		(patientList.indexOf(patient)+1)+" of "+patientList.size()+"\n");
	}
	
	/*
	 * Sets a patient to a certain position in the LinkedList based
	 * on what index the user chooses.
	 */
	public void changePatientPos() {
		Scanner kB = new Scanner(System.in);

		getPatientByPID();

		System.out.println("\n'"+patient.getFisrtName()+" "+patient.getLastName()+"' is: "+
		(patientList.indexOf(patient)+1)+" of "+patientList.size()+"\n");
		
		System.out.println("Enter New Position? "+ "(OUT OF "+patientList.size()+")");
		
		int newPos = kB.nextInt();
		
		if(newPos == patientList.indexOf(patient) || newPos > patientList.size() || newPos <= 0) { //Checks to see if users input is within the LinkedLists boundary.
			System.out.println("\nERROR - Please Try Again!");
		}else {
			newPos = newPos-1; //Set the position to match the index of the LinkedList.
			
			Patient temp = patient; //Sets a temporary Patient variable to the patient that is being changed.
			patientList.remove(patient); //Removes the patient from the LinkedList.
			patientList.add(newPos, temp); //Adds the temporary patient to the LinkedList at the index the user chose.
			
			System.out.println("\nPATIENT UPDATED!");
			System.out.println("'"+patient.getFisrtName()+" "+patient.getLastName()+"' is: "+
					(patientList.indexOf(patient)+1)+" of "+patientList.size()+"\n");
			
		}
	}
	
	/*
	 * Displays options to remove patients from the LinkedList.
	 */
	public void deletePatientMenu() {
		Scanner kB = new Scanner(System.in);
	
		System.out.println("\n----- DELETE PATIENT -----"); //Displays the menu options to the user.
        System.out.println("1. Remove Single Patient");
        System.out.println("2. Remove Multiple Patients From the End (OUT OF " +patientList.size()+")");

        System.out.println("\n0. Cancel");
        
        int input = kB.nextInt();
        
        switch (input) {
        case 1:
        	deleteSinglePatient();
            break;
        case 2:
        	deleteMultiplePatient();
            break;
        case 0:
            break;
        default:
        	System.out.println("\nERROR - Not A Valid Option");
        	deletePatientMenu();
            break;
        }
	}
	
	/*
	 * Removes a single patient based on what PID the user chooses.
	 */
	public void deleteSinglePatient() {
		Scanner kB = new Scanner(System.in);
		
		getPatientByPID();
			
		patient.displayPatient(patient);
	
		System.out.println("DELETE THIS PATIENT?"); //Checks if user is committed to the deletion of the patient.
        System.out.println("1. Yes");
        System.out.println("2. No");
        
       int input = kB.nextInt();
        
        switch (input) {
        case 1:
        	System.out.println("\nPATIENT '"+patient.getFisrtName()+" "+patient.getLastName()+"' REMOVED!\n");
        	patientList.remove(patient);
            break;
        case 2:
        	deletePatientMenu();
            break;
        default:
        	System.out.println("\nERROR - Not A Valid Option");
            deleteSinglePatient();
            break;
        }
	}
	
	/*
	 * Removes multiple patients from the end of the list based on
	 * how many the user chooses.
	 */
	public void deleteMultiplePatient() {
		Scanner kB = new Scanner(System.in);
		
		System.out.println("How many patients would you like to remove?");
		
		
		int num = kB.nextInt();
		
		if(num > patientList.size() || num <= 0) { //Checks to see if users input is outside the LinkedList boundary
			System.out.println("\nERROR - There are only "+patientList.size()+" patients");
			deleteMultiplePatient();
		}else {
			System.out.println("\nDELETE THE LAST "+num+" PATIENT(S)?");
	        System.out.println("1. Yes");
	        System.out.println("2. No");
	        
	        int input = kB.nextInt();
	        
	        switch (input) {
	        case 1:
	        	System.out.println("\nTHE LAST FOLLOWING "+num+" PATIENT(S) REMOVED!");
				for(int i=0;i<num;i++) {
					System.out.println("-- '"+patientList.getLast().firstName+" "+patientList.getLast().lastName+"'");
					patientList.removeLast();
				}
				System.out.println();
	            break;
	        case 2:
	        	deletePatientMenu();
	            break;
	        default:
	        	System.out.println("\nERROR - Not A Valid Option");
	            deleteMultiplePatient();
	            break;
	        }
		}

		
	}
	
	/*
	 * Used to set the patient's first name.
	 */
	public void selectFName(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String fname = kB.next();
        P.setFirstName(fname);
        System.out.println();
    }
	
	/*
	 * Used to set the patient's first name.
	 */
	public void selectLName(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter Last Name:");
        String lname = kB.next();
        P.setLastName(lname);
        System.out.println();     
    }
	
	/*
	 * Used to set the patient's last name.
	 */
	public void selectMobile(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter Mobile Number:");
        String mobile = kB.next();
        P.setMobileNum(mobile);
        System.out.println();
    }
	
	/*
	 * Used to set the patient's email address.
	 */
	public void selectEmail(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter Email Address:");
        String email = kB.next();
        P.setEmail(email);
        System.out.println();
    }
	
	/*
	 * Used to set the patient's city.
	 */
	public void selectCity(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter City:");
        String city = kB.next();
        P.setCity(city);
        System.out.println(); 
    }
	
	/*
	 * Used to set the patient's PPS number.
	 */
	public void selectPPS(Patient P){
		Scanner kB = new Scanner(System.in);
        System.out.println("Enter PPS Number:");
        int pps = kB.nextInt();
        P.setPPS(pps);
        System.out.println();      
    }
}


