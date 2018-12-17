package main.ast.Type.PrimitiveType;

import main.ast.Type.Type;
import main.ast.Type.UserDefinedType.UserDefinedType;

public class StringType extends Type {

    @Override
    public String toString() {
        return "string";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof StringType;
    }
}
