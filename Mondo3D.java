package treD ;

import java.util.* ;
import java.awt.* ;

public class Mondo3D {
	private Vector oggetti ;
	public Mondo3D () {
	  oggetti= new Vector ();
	}
	public void add (Oggetto3D ogge) {
	 oggetti.add (ogge) ;
	}
	public void remove (Oggetto3D ogge) {
	  oggetti.remove (ogge) ;
	}
	public int nOggetti () {
	  return oggetti.size() ;
	}

        public void logga () {
	   int i = 0 ;
           for ( Iterator iter = oggetti.iterator () ; iter.hasNext() ; )
           {
		  System.out.println ("Solido " + i++);
		  Oggetto3D tempo = (Oggetto3D) (iter.next()) ;
                  tempo.stampaCorrenti() ;
           }
        }

	public Oggetto3D getOggetto ( int indice) {
	  return (Oggetto3D) (oggetti.get(indice)) ;
	}

        public synchronized void disegnaTutto(Telecamera quale, Graphics grafico)
        {
	   int i = 0 ;
           for ( Iterator iter = oggetti.iterator () ; iter.hasNext() ; )
           {
		  Oggetto3D tempo = (Oggetto3D) (iter.next()) ;
                  tempo.trasforma (quale) ;
                  tempo.disegnati (grafico) ;
           }
	}
}
