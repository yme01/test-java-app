package treD ;

import java.awt.* ;



public class Cubo extends Oggetto3D {
       private float lato ;
       static final int N_PUNTI = 8 ;
       static final int N_POLI = 6 ;

       private void aggiusta ()
	  throws PoligonoErrato
	{
               Punto  punti [] = Parallelepipedo.genPunti (lato,lato,lato) ; // new Punto [N_PUNTI] ;
               Poligono poli [] = new Poligono [N_POLI] ;
               poli[0]= new Poligono (0,1,2,3 , Color.white) ;
               poli[1]=new Poligono (0,4,7,3 , Color.blue) ;
               poli[2]=new Poligono (0,1,5,4, Color.green) ;
               poli[3]=new Poligono (4,5,6,7, Color.red) ;
               poli[4]=new Poligono (1,5,6,2 , Color.pink) ;
               poli[5]= new Poligono (2,3,7,6, Color.yellow) ;
               setValori (punti,poli, new Posizione()) ;
       }
       public Cubo (float lato) {
          super (N_PUNTI ,N_POLI) ;
          this.lato=lato ;
	try {
          aggiusta() ;
	} catch (PoligonoErrato ecce ) {
	   System.err.println ("Poligoni errati nel cubo" );
           System.err.println (ecce.getMessage()) ;
	   System.exit(1) ;
       }
       }
}