package treD ;

import java.awt.* ;
import java.util.* ;

public class Oggetto3D
    implements Posizionabile
{
	private int lung ;
	private Punto origi [] ;
	private Poligono poligoni [] ;
	private Posizione posiz ;
	private Punto correnti [] ;
        protected Oggetto3D (int nPunti , int nPoligoni) {
       	   lung = nPunti ;
	   origi = new Punto [lung] ;
           correnti = new Punto[lung] ;
	   poligoni = new Poligono [ nPoligoni] ;
        }
        protected void setValori (Punto [] originali , Poligono [] poli ,Posizione pos)
                throws PoligonoErrato
        {
           for (int i =0 ; i < lung ; i++)
             origi[i]= originali[i].clona() ;
           for ( int i =0 ; i < poligoni.length ; i++)
           {
               poli[i].controlla(lung-1) ;
               poligoni[i]=poli[i].clona() ;
	       poligoni[i].setPunti(correnti) ;
           }
	   setPosizione (pos) ;
        }

        public Posizione getPosizione () { return  new Posizione (posiz); }

	public void setPosizione ( Posizione pos ) {
	   posiz= new Posizione (pos) ;
	}

        public synchronized void ruota (float angolo )
// angolo positivo dall' asse y in
// senso orario
       {
         posiz.setAngolo (posiz.getAngolo()+angolo);
       }

	public Oggetto3D ( Punto [] originali , Poligono [] poli , Posizione pos )
             throws PoligonoErrato
	// i punti originali sono considerati relativi al centro (0,0,0)

	{
           this (originali.length , poli.length) ;
           setValori (originali , poli , pos) ;

	}

	public Oggetto3D (Oggetto3D start)
            throws PoligonoErrato
	{
	    this (start.origi, start.poligoni , start.posiz) ;
        }

	public synchronized void disegnati ( Graphics grafico )
	{
	  for ( int i = 0 ; i < poligoni.length ; i++ )
	     poligoni[i].disegnati ( grafico) ;
	}

	public Oggetto3D ( Punto [] originali , Poligono [] poli )
             throws PoligonoErrato
	{
	   this ( originali , poli , new Posizione()) ;
	}

        public synchronized void trasforma ( Telecamera camera )
        {
	   Posizione pos= camera.getPosizione () ;
	   Posizione newCentro = new Posizione (posiz) ;
	   newCentro.trasla (pos.simmeO());
           newCentro.ruota(-pos.getAngolo()) ;

           for ( int i = 0 ; i < lung ; i++ )
           {
                correnti[i]= origi[i].clona() ;
                correnti[i].rotoTrasla (newCentro) ;
           }
           for ( int i = 0 ; i < poligoni.length ; i++)
           {
                poligoni[i].calcolaDistanza() ;
           }
           Arrays.sort (poligoni) ;
	}

        void stampaCorrenti () {
             System.out.println ("Correnti :");
             stampaArraPunti (correnti) ;
        }

        void stampa () {
             System.out.println ("Origi :");
             stampaArraPunti (origi) ;
             stampaPoligoni() ;
             stampaCorrenti () ;
        }

        void stampaPoligoni () {
             for (int i = 0 ; i < poligoni.length ; i++)
             {
                System.out.println("Poligono num " + i) ;
                poligoni[i].stampa() ;
             }
        }

        void stampaArraPunti (Punto arra[] ) {
             for (int i = 0 ; i < arra.length ; i++)
             {
                System.out.print("Punto num " + i +"  ") ;
                arra[i].stampa() ;
             }
        }

        public void esegui (Posizione ogge , Posizione telePos)
// metodo di prova	
        {
                Telecamera tele = new Telecamera (telePos) ;
                setPosizione (ogge) ;
                System.out.print ("Posizione oggetto : ") ;
                posiz.stampa() ;
                System.out.print ("Posizione telecamera : ") ;
                telePos.stampa() ;
                trasforma(tele) ;
                stampa() ;
        }

	public static void main (String args[])
{
        try {
         Posizione pos1 =new Posizione(0f,5f,0f,0f) ;
         Posizione pos2= new Posizione (5f,10f,0f,(float) Math.toRadians (30.0)) ;
 	 Posizione pos3 = new Posizione ( -5f , 10f, -1f, (float) Math.toRadians (-90.0)) ;
 	 Posizione posTel = new Posizione (0.0F , -5f , 0.0F , 0.0F) ;

 	 Cubo cubo1 = new Cubo(2.0f) ;
 	 Cubo cubo2 = new Cubo (3.0f) ;
         Parallelepipedo para = new Parallelepipedo (1.0F , 2.0F , 4.0F) ;

         Cinepresa cine = new Cinepresa(posTel);

 	 cubo1.setPosizione (pos1) ;
 	 cubo2.setPosizione (pos2) ;
         para.setPosizione (pos3) ;

 	 Mondo3D mondo = new Mondo3D () ;

         OggettoAnimato anima1 = new OggettoAnimato (cubo1) ;
 	 OggettoAnimato anima3 = new OggettoAnimato (para) ;

         mondo.add (anima1) ;
 	 mondo.add (cubo2) ;
 	 mondo.add (anima3) ;

 	 cine.setMondo3D (mondo) ;
 	 FrameCine f= new FrameCine ("Cinepresa",cine) ;
         f.go() ;
        } catch (PoligonoErrato ecce ) {
	   System.err.println ("C'e' un poligono errato" );
           System.err.println (ecce.getMessage()) ;
	   System.exit(1) ;
	}
}
}











