package com.github4sanjay.dsalgo.designpattern.visitor;

public class CommissionBasedEmployee implements Employee {
  private final int id;
  private final String name;
  private final int commissionPercent;
  private final int profit;

  public CommissionBasedEmployee(int id, String name, int commissionPercent, int profit) {
    this.id = id;
    this.name = name;
    this.commissionPercent = commissionPercent;
    this.profit = profit;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCommissionPercent() {
    return commissionPercent;
  }

  public int getProfit() {
    return profit;
  }

  @Override
  public String toString() {
    return "{"
        + "  \"id\":"
        + id
        + ","
        + "  \"name\":"
        + name
        + "\","
        + "  \"commissionPercent\":"
        + commissionPercent
        + ","
        + "  \"profit\":"
        + profit
        + "}";
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
