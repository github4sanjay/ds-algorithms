package designpattern.visitor;

public class FixedSalaryEmployee implements Employee {
    private final int id;
    private final String name;
    private final int salary;

    public FixedSalaryEmployee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "{" +
                "  \"id\":" + id + "," +
                "  \"name\":" + name + "\"," +
                "  \"salary\":" + salary + "" +
                "}";
    }
}
