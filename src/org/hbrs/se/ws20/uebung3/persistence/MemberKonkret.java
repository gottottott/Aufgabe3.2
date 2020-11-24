package org.hbrs.se.ws20.uebung3.persistence;

public class MemberKonkret implements Member {
	
	private Integer id = null;
	
	public MemberKonkret( Integer id ){
		this.id = id;  
	}

	public Integer getID() { 
		return this.id;
	}
	
	public void setID ( Integer id ) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MemberKonkret [id=" + id + "]";
	} 
	
	

}
