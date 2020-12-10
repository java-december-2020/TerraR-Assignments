package objectmaster2;

public class HumanTest {
	public static void main(String[] args) {
		Wizard wizard = new Wizard();
		Ninja ninja = new Ninja();
		Samurai samurai = new Samurai();
		Samurai samurai2 = new Samurai();
		
		ninja.steal(samurai, "Samurai");
		samurai.deathBlow(ninja, "Ninja");
		wizard.heal(ninja, "Ninja");
		wizard.fireball(samurai, "Samurai");
		ninja.runAway();
		samurai.meditate();
		samurai2.deathBlow(wizard, "Wizard");
		samurai.howMany();
	}
}
