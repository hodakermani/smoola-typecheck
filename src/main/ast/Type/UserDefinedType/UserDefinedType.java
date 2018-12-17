package main.ast.Type.UserDefinedType;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import main.ast.Type.Type;
import main.ast.node.declaration.ClassDeclaration;
import main.ast.node.expression.Identifier;

public class UserDefinedType extends Type {
    private ClassDeclaration classDeclaration;

    public ClassDeclaration getClassDeclaration() {
        return classDeclaration;
    }

    public UserDefinedType() {};

    public UserDefinedType(Identifier identifier) {
        this.setName(identifier);
    }

    public void setClassDeclaration(ClassDeclaration classDeclaration) {
        this.classDeclaration = classDeclaration;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    private Identifier name;

    @Override
    public String toString() {
        //return classDeclaration.getName().getName();
        return this.getName().getName();
    }

    @Override
    public boolean equals(Object other) {
        UserDefinedType other1 = (UserDefinedType)other;
        return other1.name.getName().equals(this.name.getName());
    }
}
