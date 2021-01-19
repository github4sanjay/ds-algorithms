package designpattern.visitor;

public class SalaryCalculator implements Visitor<Integer> {

    @Override
    public Integer visit(FixedSalaryEmployee fixedSalaryEmployee) {
        return fixedSalaryEmployee.getSalary();
    }

    @Override
    public Integer visit(CommissionBasedEmployee commissionBasedEmployee) {
        return commissionBasedEmployee.getProfit() * commissionBasedEmployee.getCommissionPercent() / 100;
    }

    @Override
    public Integer visit(FixedSalaryAndCommissionBasedEmployee fixedSalaryAndCommissionBasedEmployee) {
        return fixedSalaryAndCommissionBasedEmployee.getSalary() +
                fixedSalaryAndCommissionBasedEmployee.getProfit() * fixedSalaryAndCommissionBasedEmployee.getCommissionPercent() / 100;
    }
}


