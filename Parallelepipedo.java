package treD ;

import java.awt.* ;

public class Parallelepipedo extends Oggetto3D {
       private float larghe ;
       private float prof ;
       private float alte ;
       static final int N_PUNTI = 8 ;
       static final int N_POLI = 6 ;

       public static Punto [] genPunti ( float larg , float pro , float alt)
       {
               Punto  punti [] = new Punto [N_PUNTI] ;
               punti[0]=new Punto (larg / 2.0F , pro / 2.0F , alt / 2.0F) ;
               punti[1]= punti[0].simmeYZ() ;
               punti[2]= punti[1].simmeXY() ;
               punti[3]= punti[0].simmeXY() ;
               punti[4]=punti[0].simmeXZ() ;
               punti[5]=punti[1].simmeXZ() ;
               punti[6]=punti[2].simmeXZ() ;
               punti[7]=punti[3].simmeXZ() ;
               return punti ;
       }

       private void aggiusta ()
	  throws PoligonoErrato
	{
               Punto  punti [] = genPunti (larghe , prof, alte) ; //new Punto [N_PUNTI] ;
               Poligono poli [] = new Poligono [N_POLI] ;
               poli[0]= new Poligono (0,1,2,3 , Color.blue) ;
               poli[1]=new Poligono (0,4,7,3 , Color.white) ;
               poli[2]=new Poligono (0,1,5 ,4, Color.red) ;
               poli[3]=new Poligono (4,5,6,7, Color.green) ;
               poli[4]=new Poligono (1,5,6,2 , Color.yellow) ;
               poli[5]= new Poligono (2,3,7,6, Color.pink) ;
               setValori (punti,poli, new Posizione()) ;
       }

       public Parallelepipedo (float larghe , float prof , float alte) {
          super (N_PUNTI ,N_POLI) ;
          this.larghe = larghe ;
          this.prof= prof ;
          this.alte= alte ;
	try {
          aggiusta() ;
	} catch (PoligonoErrato ecce ) {
	   System.err.println ("Poligoni errati nel Parallelepipedo" );
           System.err.println (ecce.getMessage()) ;
	   System.exit(1) ;
       }
       }
}