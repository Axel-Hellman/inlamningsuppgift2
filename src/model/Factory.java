package model;

import java.io.IOException;

import expr.ExprParser;

public class Factory {
	
	public Cell cell(String cellString){
		ExprParser parser = new ExprParser();
		if (cellString.length() > 0){
			if (cellString.charAt(0) == '#') {
				return new CommentCell(cellString);
			} else {
				try {
					return new ExprCell(parser.build(cellString));
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
