package designpattern.visitor;

public interface Employee {
    <T> T accept(Visitor<T> visitor);
}