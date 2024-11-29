package dev.playground.designPatterns.structural.composite;

/**
 * Composite pattern: Composite is a structural design pattern, that lets you compose objects into tree structures and
 * then work with these structures as if they were individual objects.
 *
 * Reference: https://www.baeldung.com/java-composite-pattern
 *            https://refactoring.guru/design-patterns/composite
 *
 * It can be viewed as a tree structure made up of types that inherit a base type, and it can represent a single part or
 * a whole hierarchy of objects.
 *
 * Component – is the base interface for all the objects in the composition. It should be either an interface
 * or an abstract class with the common methods to manage the child composites.
 *
 * Leaf – implements the default behavior of the base component. It doesn't contain a reference to the other objects.
 *
 * Composite – has leaf elements. It implements the base component methods and defines the child-related operations.
 *
 */
public class Main {

	public static void main(String[] args) {
		// Creating departments
		Department salesDepartment = new SalesDepartment(1, "Sales department");
		Department financialDepartment = new FinancialDepartment(2, "Financial department");
		HeadDepartment headDepartment = new HeadDepartment(3, "Head department");

		// By using methods from composite class, we are adding departments to the list of departments
		headDepartment.addDepartment(salesDepartment);
		headDepartment.addDepartment(financialDepartment);

		headDepartment.printDepartmentName();
	}

}
