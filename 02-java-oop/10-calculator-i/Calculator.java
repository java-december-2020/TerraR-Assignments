package calculator1;

public class Calculator {

	// =======================================================================
	// Instance variables
	// =======================================================================	
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double results;
	
	// =======================================================================
	// Constructor
	// =======================================================================		
	public Calculator() {
		operandOne = 0;
		operation = "";
		operandTwo = 0;
	}

	// =======================================================================
	// Getters
	// =======================================================================		
	public double getOperandOne() {
		return operandOne;
	}
	public String getOperation() {
		return operation;
	}	
	public double getOperandTwo() {
		return operandTwo;
	}
	public double getResults() {
		return results;
	}	
	
	// =======================================================================
	// Setters
	// =======================================================================		
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}	
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setResults(double results) {
		this.results = results;
	}

	// =======================================================================
	// Methods
	// =======================================================================		
	
	public void performOperation(double num1, String operation, double num2) {
		
		if (operation != "+" && operation != "-") { 
			System.out.println("\nInvalid operation");
			return;
		}
		
		setOperandOne(num1);
		setOperation(operation);
		setOperandTwo(num2);
		
		if(operation == "+") {
			setResults( getOperandOne() + getOperandTwo() );
		} else if(operation == "-") {
			setResults( getOperandOne() - getOperandTwo() );
		}
		displayResults();
	}
	
	
	public void displayResults() {
		System.out.printf( "%n %.1f %s %.1f = %.1f", getOperandOne(), getOperation(), getOperandTwo(), getResults() );
	}

}
