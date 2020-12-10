package zookeeper2;

public class Bat extends Mammal {
    // =======================================================================
    // Constructor
    // =======================================================================	
	public Bat() {
		super(300);
	}

    // =======================================================================
    // Methods
    // =======================================================================
	public void attackTown(int num) {
        setEnergyLevel(getEnergyLevel() + (-100 * num));
        System.out.println("\nAttacking a town! So much fun! Burn baby burn!");
    }

    public void eatHumans(int num) {
        setEnergyLevel(getEnergyLevel() + (25 * num));
        System.out.println("\n...I had the liver with a side of fava beans...hehehahaha");
    }

    public void fly(int num) {
        setEnergyLevel(getEnergyLevel() + (-50 * num));
        System.out.println("\nFlying! Zoom baby, I like to fly awayyyy..zoom, zoom!");
    }
}
