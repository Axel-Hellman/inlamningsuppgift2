package model;
import expr.Environment;

// Done

public interface Cell {

	public abstract double value(Environment env);
	
	public String getComment();
	
	public String toString(Environment env);
	
}
