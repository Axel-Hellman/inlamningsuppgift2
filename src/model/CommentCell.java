package model;

import expr.Environment;

// Done

public class CommentCell implements Cell {
	private String string;

	public CommentCell(String cellString) {
		string = cellString;
	}

	@Override
	public double getValue(Environment env) {
		return 0;
	}

	public String getComment() {
		return string;
	}

	public String toString(Environment e) {
		return string;
	}

	@Override
	public String savedToString() {
		return string;
	}

}
