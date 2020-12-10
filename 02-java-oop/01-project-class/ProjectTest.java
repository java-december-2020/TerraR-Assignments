public class ProjectTest {
    public static void main(String[] args) {
        Project calculatorProject = new Project();
        calculatorProject.setName("Calculator");
        calculatorProject.setDescription("This project creates a calculator app");
        calculatorProject.setInitialCost(1999.99);

        Project javaProject = new Project("Java");

        Project webFunProject = new Project("WebFun", "This project covers HTML, CSS, and JavaScript.");

        calculatorProject.printProject();
        javaProject.printProject();
        webFunProject.elevatorPitch();
    }
}
