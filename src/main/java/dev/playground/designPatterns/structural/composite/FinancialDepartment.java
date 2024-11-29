package dev.playground.designPatterns.structural.composite;

/**
 * Leaf component
 */
public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    public FinancialDepartment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implementing base component (interface)
    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

}
