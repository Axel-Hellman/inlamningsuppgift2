package model;

import expr.Environment;
import expr.Expr;

public class ExprCell implements Cell {
    private Expr expr;

    public ExprCell (Expr cellExpr){
        expr = cellExpr;
    }

    @Override
    public double getValue(Environment env) {
        return expr.value(env);
    }

    public String getStringValue(Environment env){
        return Double.toString(getValue(env));
    }

    @Override
    public String toString() {
        return expr.toString();
    }
}