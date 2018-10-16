package model;

import expr.Environment;

// Done

public interface Cell {

	public double getValue(Environment env);

	public String getStringValue(Environment env);
	
}
