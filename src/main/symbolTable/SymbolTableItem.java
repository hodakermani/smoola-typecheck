package main.symbolTable;

public abstract class SymbolTableItem {
	protected String name;

	public SymbolTableItem() {
	}

	public String getName() {
		return this.name;
	}

	public abstract String getKey();

}