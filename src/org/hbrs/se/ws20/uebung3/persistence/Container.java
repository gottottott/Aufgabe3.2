package org.hbrs.se.ws20.uebung3.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Container {
	private List<Member> liste = null;
	private static Container instance = null;

	private Container(){
		liste = new ArrayList<Member>();
	}
	/* Methode die pürft ob es schon ein Objekt Container gibt.
	/* 		- Wenn Ja, dann wird dieses zurückgegeben.
	/*		- Wenn Nein, dann wird ein Neues erstellt.
	 */
	public static Container getInstance() {
		if (instance == null) {
			instance = new Container();
		}
		return instance;
	}
	/*
	 * Methode zum Hinzufuegen einer Member.
	 * @throws ContainerException
	 */ 
	public void addMember ( Member r ) throws ContainerException {
		if ( contains( r ) == true ) {
			ContainerException ex = new ContainerException("Fehler");
			ex.addID ( r.getID() );
			throw ex;
		}
		liste.add( r );
	
	} 
	
	/*
	 * Methode zur Ueberpruefung, ob ein Member-Objekt in der Liste enthalten ist
	 * 
	 */
	private boolean contains(Member r) {
		Integer ID = r.getID();
		for ( Member rec : liste) {
			// wichtig: Check auf die Values innerhalb der Integer-Objekte!
			if ( rec.getID().intValue() == ID.intValue() ) {
				return true;
			}
		}
		return false;
		
		// liste.contains(r), falls equals-Methode in Member ueberschrieben.
	}
	/*
	 * Methode zum Loeschen einer Member
	 * 
	 */
	public String deleteMember( Integer id ) {
		Member rec = getMember( id );
		if (rec == null) return "Member nicht enthalten - ERROR"; else {
			liste.remove(rec);
			return "Member mit der ID " + id + " konnte geloescht werden";
		}
	}
	
	/*
	 * Methode zur Bestimmung der Anzahl der von Member-Objekten
	 * Aufruf der Methode size() aus List
	 * 
	 */
	public int size(){
		return liste.size();
	}

	public List<Member> getCurrentList() { return liste; }

	private Member getMember(Integer id) {
		for ( Member rec : liste) {
			if (id == rec.getID().intValue() ){
				return rec;
			}
		}
		return null;
	}

}
