
public class Patient {
	static int lastPID = 0;
	int PID;
	String firstName;
	String lastName;
	String mobileNum;
	String email;
	String city;
	int PPS;
	
	public Patient(String fName, String lName, String mobile, String email, String city, int pps) {
		this.firstName = fName;
		this.lastName = lName;
		this.mobileNum = mobile;
		this.email = email;
		this.city = city;
		this.PPS = pps;
		PID = ++lastPID;
	}
	
	public Patient() {
		
	}

	public void setFirstName(String a) {
		this.firstName = a;
	}

	public void setLastName(String a) {
		this.lastName = a;
		
	}
	
	public void setMobileNum(String a) {
		this.mobileNum = a;
		
	}

	public void setEmail(String a) {
		this.email = a;
	
	}

	public void setCity(String a) {
		this.city = a;
	
	}

	public void setPPS(int a) {
		this.PPS = a;
		
	}
	
	public String getFisrtName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	public int getPPS() {
		return PPS;
	}

	public int getPID() {
		return PID;
	}

	/*
	 * Displays the personal information of the user 
	 * and the current position of the user in the LinkedList.
	 */
	public void displayPatient(Patient P) {
		System.out.println("--PATIENT INFO--");
		System.out.println("Pateint ID: \t"+P.getPID());
	    System.out.println("Fisrt Name: \t"+P.getFisrtName());
        System.out.println("Last Name: \t"+P.getLastName());
        System.out.println("Mobile Number: \t"+P.getMobileNum());
        System.out.println("Email Address: \t"+P.getEmail());
        System.out.println("City: \t\t"+P.getCity());
        System.out.println("PPS Number: \t"+P.getPPS());
        System.out.println("POSITION: \t"+(PatientSetUp.patientList.indexOf(P)+1)+" of "+PatientSetUp.patientList.size());
        System.out.println();
	}
}
