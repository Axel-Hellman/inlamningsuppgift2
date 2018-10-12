package model;

import java.util.HashMap;
import java.util.Observable;

import expr.Environment;
import gui.SlotLabels;

public class Sheet extends Observable implements Environment, Cell {

	private HashMap<String,Cell> sheet;
	private Factory factory;
	private SlotLabels slotLabels;
	
	public Sheet(){
		super(); 
		sheet = new HashMap<String,Cell>();
		factory = new Factory();
	}
	
	public Sheet(HashMap<String,Cell> sheet){
		this.sheet = sheet;
		
	}
	
	public String getComment(){
		return null;
	}
	
	public String toString(Environment e){
		return null;
	}


	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}


	
	
	
	
