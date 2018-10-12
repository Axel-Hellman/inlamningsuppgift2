package model;

import expr.Environment;
import util.XLException;

public class Bomb implements Cell {

	@Override
	public double value(Environment env) { // BOOOOOOOOOM!!!
		throw new XLException("KABOOM! (Bomb Error)");
	}

	@Override
	public String getComment() {
		return null;
	}

	@Override
	public String toString(Environment env) {
		throw new XLException("KABOOM! (Bomb Error)");
	}

}
 