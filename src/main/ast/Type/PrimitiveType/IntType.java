package main.ast.Type.PrimitiveType;

import main.ast.Type.Type;

public class IntType extends Type {
    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof IntType;
    }
}
