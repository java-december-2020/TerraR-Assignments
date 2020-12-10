package objectmaster2;

public class Ninja extends Human {
	
	private static String name = "";
	
	public Ninja() {
		super();
		setStealth(10);
		name = "Ninja";
	}
	
	public String getName() {
		return name;
	}
	
	public void steal(Human attackedHuman, String attacked) {
		this.setHealth( this.getHealth() + this.getStealth() );
		attackedHuman.setHealth( attackedHuman.getHealth() - this.getStealth() );
		System.out.printf("%n%s stole health from %s. %n%s's health is now: %d", this.getName(), attacked, attacked, attackedHuman.getHealth());
		System.out.printf("%n%s's health is now: %d%n", this.getName(), this.getHealth()); 
	}
	
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
		System.out.printf( "%n%s is a run away! %n%s's health is now: %d%n", this.getName(), this.getName(), this.getHealth() );
	}
}
