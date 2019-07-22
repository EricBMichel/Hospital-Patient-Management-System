
public class Main {

	public static void main(String[] args) {

		/*
		 * Dummy Data.
		 */
		Patient p1 = new Patient("Eric","Michel","081 111 1111","em@mail.com","Dublin",123312);
		Patient p2 = new Patient("Vil","Salg","082 222 2222","vs@mail.com","Cork",552313);
		Patient p3 = new Patient("John","Loazia","083 333 3333","jl@mail.com","Galway",742348);
		Patient p4 = new Patient("Julio","Lopez","084 444 4444","jl2@mail.com","Athlone",414667);
		Patient p5 = new Patient("Nancy","Agiulera","085 555 5555","na@mail.com","Westport",644366);
		Patient p6 = new Patient("Tom","Dick","086 666 6666","td@mail.com","Dubln",234417);
		Patient p7 = new Patient("Harry","Oz","087 777 7777","ho@mail.com","Dublin",658256);

		/*
		 * Dummy Data added the LinkedList.
		 */
		PatientSetUp.patientList.add(p1);
		PatientSetUp.patientList.add(p2);
		PatientSetUp.patientList.add(p3);
		PatientSetUp.patientList.add(p4);
		PatientSetUp.patientList.add(p5);
		PatientSetUp.patientList.add(p6);
		PatientSetUp.patientList.add(p7);
		
		/*
		 * Starts the program.
		 */
		Menu m = new Menu();
		m.mainMenu();
		

	}

}
