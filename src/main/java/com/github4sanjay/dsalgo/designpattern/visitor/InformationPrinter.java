package com.github4sanjay.dsalgo.designpattern.visitor;

public class InformationPrinter implements Visitor<String> {

  @Override
  public String visit(FixedSalaryEmployee fixedSalaryEmployee) {
    return fixedSalaryEmployee.toString();
  }

  @Override
  public String visit(CommissionBasedEmployee commissionBasedEmployee) {
    return commissionBasedEmployee.toString();
  }

  @Override
  public String visit(FixedSalaryAndCommissionBasedEmployee fixedSalaryAndCommissionBasedEmployee) {
    return fixedSalaryAndCommissionBasedEmployee.toString();
  }
}
