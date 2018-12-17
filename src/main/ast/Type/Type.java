package main.ast.Type;

import main.ast.node.Node;

public abstract class Type extends Node {
    public abstract String toString();
    public boolean isRightValue = true;
}
