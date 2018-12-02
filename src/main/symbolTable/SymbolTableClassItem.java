package main.symbolTable;

public class SymbolTableClassItem extends SymbolTableItem {

    public SymbolTableClassItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return name;
    }

}