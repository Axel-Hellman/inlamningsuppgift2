package model;

public class CurrentCell {
	
	private Cell cell;
	private String address;

	public void setCurrentCell(String address){
		this.address = address;
		// cell = Sheet.getCell(address);
	}
	
	public Cell getCell(){
		return cell;
	}
	
	public String getAddress(){
		return address;
	}
	
}
