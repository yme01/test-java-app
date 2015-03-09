package treD ;

public class Posizione extends Punto
// angolo positivo dall' asse y in senso orario

{

	private float angolo ;

	public Posizione (Posizione start) {
	  this (start.getX() , start.getY() , start.getZ(),start.angolo) ;
	}

	public Posizione ( float x , float y , float z , float ang)
        {
         super (x ,y, z) ;
	 angolo = ang ;
	}

        public Posizione ( Punto point , float ang) {
          this (point.getX() , point.getY() , point.getZ() , ang ) ;
        }

        public Posizione () {
               this (0.0F, 0.0F , 0.0F , 0.0F ) ;
        }

	public void ruota ( float angolo )

// ritorna le coord nel vecchio sistema
// angolo positivo dall' asse y in
// senso orario

	{
           super.ruota(angolo) ;
           this.angolo+=angolo ;
	}

	public void setAngolo (float angolo ) { this.angolo=angolo ;}

	public float getAngolo () { return angolo ; }

        public String toString ()
        {
          return ( super.toString()+
" ,  angolo = " + angolo + " (" + Math.toDegrees(angolo) + " gradi)" ) ;
        }

        void stampa () {
             System.out.println ( toString()) ;
        }
}
