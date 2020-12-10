package zookeeper1;

public class Gorilla extends Mammal {

	// =======================================================================
    // Methods
    // =======================================================================
    public void throwSomething(int num) {
        setEnergyLevel(getEnergyLevel() + (-5 * num));
        System.out.println("\nYou looking at me!???  Take this...WHAP!!!");
    }

	public void eatBananas(int num) {
        setEnergyLevel(getEnergyLevel() + (10 * num));
        System.out.println("\nYum. Bananas are sublime.");
    }

    public void climb(int num) {
        setEnergyLevel(getEnergyLevel() + (-10 * num));
        System.out.println("\nWaaaaaah! I love climbing trees!");
    }
}
