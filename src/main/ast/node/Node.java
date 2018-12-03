package main.ast.node;

import main.ast.Visitor;

public abstract class Node {

    public void accept(Visitor visitor) {}
}
