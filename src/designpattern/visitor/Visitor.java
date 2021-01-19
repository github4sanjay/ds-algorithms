package designpattern.visitor;

interface Visitor<T> {
   
    T visit(FixedSalaryEmployee fixedSalaryEmployee);
    T visit(CommissionBasedEmployee commissionBasedEmployee);
    T visit(FixedSalaryAndCommissionBasedEmployee fixedSalaryAndCommissionBasedEmployee);
}