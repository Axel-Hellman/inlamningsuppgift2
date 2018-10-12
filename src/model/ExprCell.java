package model;

import expr.Environment;
import expr.Expr;

// Done

public class ExprCell implements Cell {
	private Expr expr;
	
	public ExprCell (Expr cellExpr){
		expr = cellExpr;
	}
	@Override
	public double value(Environment env) {
		return expr.value(env);
	}

	public String getComment(){
		return null;
	}
	
	public String toString(Environment e){
		return expr.toString();
	}

}
