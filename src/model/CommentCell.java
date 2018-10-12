package model;

import expr.Environment;

public class CommentCell implements Cell {
	private String string;
	
	public CommentCell(String cellString){
		this.string = cellString;
	}
	
	@Override
	public double value(Environment env) {
		return 0;
	}
	
	public String getComment(){
		return string;
	}
	
	public String toString(Environment e){
		return string;
	}

}
