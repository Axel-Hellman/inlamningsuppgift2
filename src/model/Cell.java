package model;

import expr.Environment;

// Done

public interface Cell {

	public double getValue(Environment env);

	public String toString(Environment env);

	public String getComment();

	public String savedToString();

}
