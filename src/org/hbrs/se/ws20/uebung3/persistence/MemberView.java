package org.hbrs.se.ws20.uebung3.persistence;

import java.util.List;

public class MemberView {

    public void dump(List<Member> liste) {
        System.out.println("Ausgabe aller Member-Objekte: ");

        for ( Member p : liste ) {
            System.out.println( p.toString()  );
        }
    }
}