package model;

import expr.Environment;

public class CommentCell implements Cell {
	private String string;

	
	public CommentCell(String cellString){
		string = cellString.substring(1);
	}

	@Override
	public double getValue(Environment env) {
		return 0;
	}
	
	public String getStringValue(Environment env){
		return string;
	}

	@Override
	public String toString() {
		return "#" + string;
	}
}