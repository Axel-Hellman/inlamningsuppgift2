package model;
import expr.Environment;

// Done

public interface Cell {

	public abstract double getValue(Environment env);
	
	public String getComment();
	
	public String toString(Environment env);

	String savedToString();
	
}
