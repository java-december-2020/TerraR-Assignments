package objectmaster1;

public class HumanTest {

	public static void main(String[] args) {
		Wizard wizard = new Wizard();
		Ninja ninja = new Ninja();
		
		wizard.attack(ninja);
		
		System.out.println("\n Wizard attacked Ninja. Wizard's health is: " + wizard.getHealth());
		System.out.println("\n Ninja was attacked. Ninja's health is: " + ninja.getHealth());
	}
}
