package org.hbrs.se.ws20.uebung3.persistence;

public class ContainerException extends Exception {
	
	// Eigentlich nicht notwendig, für den Fall einer Serialisierung 
	private static final long serialVersionUID = 2656959703434537144L;
	
	private Integer id;

	public ContainerException(String s) {
		super(s);
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("Das Member-Objekt mit der ID " + this.id + " ist bereits vorhanden!"); 
	} 

	public void addID(Integer id) {
		this.id = id;
	}


}
