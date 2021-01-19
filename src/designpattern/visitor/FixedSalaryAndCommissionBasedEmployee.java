package designpattern.visitor;

public class FixedSalaryAndCommissionBasedEmployee implements Employee {
    private final int id;
    private final String name;
    private final int salary;
    private final int commissionPercent;
    private final int profit;

    public FixedSalaryAndCommissionBasedEmployee(int id, String name, int salary, int commissionPercent, int profit) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.commissionPercent = commissionPercent;
        this.profit = profit;
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

    public int getCommissionPercent() {
        return commissionPercent;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"id\":" + id + "," +
                "  \"name\":" + name + "\"," +
                "  \"salary\":" + salary + "\"," +
                "  \"commissionPercent\":" + commissionPercent + "," +
                "  \"profit\":" + profit +
                "}";
    }


    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

}