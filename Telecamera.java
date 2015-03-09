package treD ;

import java.awt.* ;

class Telecamera extends Canvas
    implements Posizionabile

{
      private final int DEF_LARGHE = 500 ;
      private final int DEF_ALTE = 500 ;
      private Posizione pos ;
      private Mondo3D mondo =null ;

      public void muoviX (float delta) {
             pos.setX (pos.getX() +delta) ;
      }

      public void muoviZ (float delta) {
             pos.setZ (pos.getZ() +delta) ;
      }

      public void muoviY (float delta) {
             pos.setY (pos.getY() +delta) ;
      }

      public void ruota (float angolo )
// angolo positivo dall' asse y in
// senso orario
      {
        pos.setAngolo (pos.getAngolo()+angolo);
      }

      public Posizione getPosizione () { return new Posizione (pos) ; }

      public void  setMondo3D(Mondo3D m3d) {
	mondo= m3d ;
      }

      public Mondo3D getMondo3D () {
        return mondo ;
      }

      public void setPosizione ( Posizione pos) {
             this.pos= new Posizione (pos) ;
      }


      public void paint(Graphics g) {
	if (mondo != null)
	  mondo.disegnaTutto (this , g) ;
	else
	  g.fillRect (25,25,30,30);
      }


      public Telecamera ( Posizione pos ) {
             this.pos= new Posizione (pos) ;
	     setSize (DEF_LARGHE , DEF_ALTE) ;
	     setBackground (Color.black) ;
      }

      public Telecamera ( Telecamera start) {
	 this ( start.pos) ;
	 mondo=start.mondo ;
      }	

      public Telecamera () {
             this (new Posizione() ) ;
      }
}
