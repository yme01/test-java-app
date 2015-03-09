package treD ;

public class Punto

{
	private float x ;
	private float y ;
	private float z ;

	public Punto ( float x , float y , float z) {
	  this.x = x ;
	  this.y = y ;
	  this.z = z ;
	}
	public Punto () {
	  this (0.0f , 0.0f , 0.0f );
	}
	public Punto clona() { return new Punto (x,y,z) ; }
	public void setX (float x) { this.x = x; }
	public void setY (float y ){ this.y = y ; }
	public void setZ (float z) { this.z = z ; }
	public float getX () { return x ; }
	public float getY () { return y ; }
	public float getZ () { return z ; }
	public void ruota ( float ang )
// ritorna le coord nel vecchio sistema
// angolo positivo dall' asse y in
// senso orario
	{
	   float seno= (float) Math.sin(ang) ;
	   float coseno=(float) Math.cos(ang) ;
	   float newx = (float) (x * coseno + y * seno);
	   y= (float) ((- x )* seno + y * coseno) ;
	   x=newx ;
	}
	public void trasla (Punto newCentro ) // coord nel vecchio sistema
	{
	   x+= newCentro.x ;
           y+= newCentro.y ;
	   z+= newCentro.z ;
	}
	public void rotoTrasla  (Posizione newPos)
	{
	   ruota (newPos.getAngolo ()) ;
           trasla(newPos) ;
	}
        public Punto simmeO () {
               return new Punto (-x,-y,-z) ;
        }
        public Punto simmeXZ () {
               return new Punto (x,-y,z) ;
        }
        public Punto simmeYZ () {
               return new Punto (-x,y,z) ;
        }
        public Punto simmeXY () {
               return new Punto (x,y,-z) ;
        }
        public String toString () {
          return ("x = " +x+" , y = " +y + ", z = " +z) ;
        }
        void stampa () {
             System.out.println (toString()) ;
        }
}
