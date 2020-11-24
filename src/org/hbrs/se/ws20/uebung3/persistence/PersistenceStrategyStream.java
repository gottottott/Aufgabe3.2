package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
import java.util.List;


public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    ObjectOutputStream oos = null;
    FileOutputStream fos = null;
    ObjectInputStream ois = null;
    FileInputStream fis = null;
    List<Member> list = null;

    public final static String LOCATION = "/Users/romanott/Desktop/SE1/userstories18.ser";

    @Override
    public void openConnection() throws PersistenceException {
        try {
            oos = new ObjectOutputStream(fos);
            fos = new FileOutputStream(LOCATION);
            ois = new ObjectInputStream(fis);
            fis = new FileInputStream(LOCATION);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        if (oos != null) try {
            oos.close();
        } catch (IOException e) {
        }
        if (fos != null) try {
            fos.close();
        } catch (IOException e) {
        }
        if (ois != null) try {
            ois.close();
        } catch (IOException e) {
        }
        if (fis != null) try {
            fis.close();
        } catch (IOException e) {
        }
        System.out.println("Verbindung erfolgreich beendet!");
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {
        try {
            openConnection();
            oos.writeObject(member);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(member.size() + " User Stories wurden erfolgreich gespeichert!");
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException {
        openConnection();
        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List) obj;

            }
            System.out.println("Es wurden " + list.size() + " User Stories erfolgreich reingeladen!");
            return list;
        } catch (IOException e) {
            // Sup-Optimal, da Exeception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Verbesserung, aber Chain of Responsbility nicht erfuellt, da UI nicht
            // benachrichtigt wird unter Umstaenden. Verbesserung: siehe Methoden store!
            System.out.println("FEHLER: Liste konnte nicht extrahiert werden (ClassNotFound)!");
        } finally {
            closeConnection();
        }
        return list;
    }
}
