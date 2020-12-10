package zookeeper2;

public class Mammal {
    // =======================================================================
    // Instance variables
    // =======================================================================
    private int energyLevel = 100;

    // =======================================================================
    // Constructor
    // =======================================================================
    public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

    // =======================================================================
    // Getters / Setters
    // =======================================================================
	public int getEnergyLevel() {
        return this.energyLevel;
    }

    public void setEnergyLevel(int num) {
        this.energyLevel = num;
    }

    // =======================================================================
    // Methods
    // =======================================================================
    public void displayEnergy() {
        System.out.println("\nMy energy level is: " + this.energyLevel);
    }

}
