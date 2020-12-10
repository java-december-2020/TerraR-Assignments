package phone;

import java.util.Formatter;

public class IPhone extends Phone implements IRingable {
	// =======================================================================
	// Instance variables
	// =======================================================================		
	private String name = "iPhone";
	
	// =======================================================================
	// Constructor
	// =======================================================================		
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
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
    	return "Unlocking via facial recognition.";
    }
    
    // Override method from Phone abstract class
    @Override
    public void displayInfo() {
    	System.out.printf("%n%s %s from %s", getName(), getVersionNumber(), getCarrier());            
    }
}

