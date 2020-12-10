package objectmaster2;

public class Samurai extends Human {
	private static int counter = 0;
	private static String name = "";
	
	public Samurai() {
		super();
		setHealth(200);
		counter++;
		name = "Samurai";
	}
	
	public String getName() {
		return name;
	}
	
	public void deathBlow(Human attackedHuman, String attacked) {
		attackedHuman.setHealth(0);
		this.setHealth(this.getHealth() / 2);
		System.out.printf( "%n%s dealth a death blow to %s. %n%s's health is now: %d", this.getName(), attacked, attacked, attackedHuman.getHealth() ); 
		System.out.printf( "%n%s's health is now: %d%n", this.getName(), this.getHealth() );
	}
	
	public void meditate() {
		this.setHealth(this.getHealth() + (this.getHealth()/2) );
		System.out.printf( "%n%s meditated to heal. %n%s's health is now: %d%n", this.getName(), this.getName(), this.getHealth() );
	}
	
	public void howMany() {
		System.out.printf( "%nThe number of %s is: %d%n", this.getName(), counter );
	}
}
