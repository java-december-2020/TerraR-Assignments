package objectmaster2;

public class Wizard extends Human {
	
	private static String name = "";
	
	public Wizard() {
		super();
		setHealth(50);
		setIntelligence(8);
		name = "Wizard";
	}
	public String getName() {
		return name;
	}
		
	public void heal(Human attackedHuman, String attacked) {
		attackedHuman.setHealth(attackedHuman.getHealth() + this.getIntelligence());
		System.out.printf("%n%s healed %s. %n%s's health is now: %d%n", this.getName(), attacked, attacked, attackedHuman.getHealth() );
	}
	
	public void fireball(Human attackedHuman, String attacked) {
		attackedHuman.setHealth(attackedHuman.getHealth() - (this.getIntelligence() *3) );
		System.out.printf("%n%s hit %s with a fireball. %n%s's health is now: %d%n", this.getName(), attacked, attacked, attackedHuman.getHealth() );
	}
}
