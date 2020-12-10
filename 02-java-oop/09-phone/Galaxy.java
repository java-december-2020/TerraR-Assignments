package phone;

import java.util.Formatter;

public class Galaxy extends Phone implements IRingable {
	// =======================================================================
	// Instance variables
	// =======================================================================		
	private String name = "Galaxy";
	
	// =======================================================================
	// Constructor
	// =======================================================================		
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
	// =======================================================================
	// Getter
	// =======================================================================	
    	public String getName() {
		return name;
	}
    	
	// =======================================================================
	// Methods
	// =======================================================================    	

	Formatter fmt = new Formatter();
    
	// Override method from the IRingable interface
    @Override
        public String ring() {
    	return fmt.format("%n%s %s says %s", getName(), getVersionNumber(), getRingTone()).toString();
    }
    
    // Override method from the IRingable interface
    @Override
    public String unlock() {
    	return "Unlocking via finger print";
    }
    
    // Override method from Phone abstract class
    @Override
    public void displayInfo() {
    	System.out.printf("%n%s %s from %s", getName(), getVersionNumber(), getCarrier());             
    }
}

