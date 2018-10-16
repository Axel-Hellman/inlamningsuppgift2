package model;

import expr.Environment;
import util.XLException;

// Done

public class Bomb implements Cell {

	@Override
	public double getValue(Environment env) { // BOOOOOOOOOM!!!
		throw new XLException("KABOOM! (Bomb Error)");
	}

	@Override
	public String getComment() {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}

}
 