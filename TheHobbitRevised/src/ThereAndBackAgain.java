/*
 * @author Aidan Lee
 * @version 2.0 2/13/2019
 * This package contains code to travel, name, and assign colors to various characters from the
 * lord of the rings series. THe code currently returns the distance each character has traveled
 * in Part 1 and Part 2.
 */
import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) 
	{
		//New Instances og Hobbit and Dwarf
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		
		//Array of Travelers with Hobbits and Dwarves
		Traveler[] party1 = {frodo, sam, gimli};
		
		//for each loop that makes the hobbits and dwarves in party1 travel a certain distance and prints that distance in a String
		for(Traveler aTraveler : party1) {
			aTraveler.travel(50);
			System.out.println(aTraveler.getName() + " has traveled " + aTraveler.getDistanceTraveled() + " miles.");
		}
		
		System.out.println();
		System.out.println("\n\n\nPART 2: \n");

		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin", 
		"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};
		
		//Array List to contain all characters
		ArrayList<Traveler> party2 = new ArrayList<Traveler>();
		
		Hobbit bilbo = new Hobbit("Bilbo");
		party2.add(bilbo);//adds Hobbit Bilbo to end of the ArrayList party2
		
		Wizard gandalf = new Wizard("Gandalf", "Grey");
		party2.add(gandalf);//adds Wizard Gandalf to end of Arraylist party2 after Bilbo
		
		//Calls create party to combine the hobbits, dwarves, and the String array of Dwarves.
		createParty(party2, dwarfNames);
		
		//Prints out the result of allTravel that returns the distance traveled of each character.
		System.out.println(allTravel(party2, 100));
	}
	
	//Adds the dwarves names to end of ArrayList party
	public static void createParty(ArrayList<Traveler> party, String[] dwarveNames) {
		
		for(String name : dwarveNames) {
			party.add(new Dwarf(name));
		}
			
	}
		
	//method that contains for loop to return the distance each character has traveled using a for loop.
	public static String allTravel(ArrayList<Traveler> party, int miles) {
		String result = "";
		
		for(int i = 0; i<party.size(); i++) {
			party.get(i).travel(miles);
			
			result+= party.get(i).getName() + " has traveled " + party.get(i).getDistanceTraveled() + " miles.\n";
			
		}
		return result;
	}
		
		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		// Make a new Hobbit called "Bilbo" and add him to party2

		// Make a new Wizard called "Gandalf" and add him to party2.


		//write createParty
		// Call the createParty method and pass it party2 and the dwarfNames array.

		// create party should add all the new dwarves to party2,

		//Write allTravel
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.

		//Make sure your code prints out the name and distances party2 has traveled.
		

	

	
}
