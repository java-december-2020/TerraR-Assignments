// import java.util.ArrayList;

public class Project {

    // =======================================================================
    // Instance variables
    // =======================================================================
    private String name;
    private String description;
    private double initialCost;

    // =======================================================================
    // Constructors
    // =======================================================================
    // Overloaded Constructor - has no parameters
    public Project() {
        this.name = "";
        this.description = "";
        this.initialCost = 0;
    }

    // Overloaded Constructor - has one parameter: name
    public Project(String name) {
        this.name = name;
        this.description = "";
        this.initialCost = 0;
    }

    // Project Constructor - has two parameters: name and description
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.initialCost = 0;
    }

    // =======================================================================
    // Getter Methods
    // =======================================================================

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getInitialCost() {
        return this.initialCost;
    }

    // =======================================================================
    // Setter Methods
    // =======================================================================

    public void setName(String name) {
        if (name.equals("")) {
            return;
        } else {
            this.name = name;
        }
    }

    public void setDescription(String description) {
        if (description.equals("")) {
            return;
        } else {
            this.description = description;
        }
    }

    public void setInitialCost(double initialCost) {
        if (initialCost <= 0) {
            return;
        } else {
            this.initialCost = initialCost;
        }
    }

    // =======================================================================
    // Other Methods
    // =======================================================================

    public void elevatorPitch() {
        String printPitch = "\n" + this.getName().concat(" : ").concat(this.getDescription());
        System.out.println(printPitch);

    }

    public void printProject() {
        String printProject = "\nProject Name:  " + this.getName() + "\nProject Description:  " + this.getDescription()
                + "\nInitial Cost:  " + this.getInitialCost();
        System.out.println(printProject);

    }

}