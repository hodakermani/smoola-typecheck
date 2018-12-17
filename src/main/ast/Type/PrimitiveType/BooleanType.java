package main.ast.Type.PrimitiveType;

import main.ast.Type.Type;

public class BooleanType extends Type {

    @Override
    public String toString() {
        return "bool";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof BooleanType;
    }
}
