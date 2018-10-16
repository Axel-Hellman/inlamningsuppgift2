package model;

import expr.Environment;

public interface Cell {

	public double getValue(Environment env);

	public String getStringValue(Environment env);
	
}