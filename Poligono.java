package treD ;

import java.awt.* ;

public class Poligono
    implements Comparable
{
	public final int N_VERTICI = 4 ;
	private int vertici [] ;
	private Color colore ;
        private Punto verticiPoligono [] = null ;
        private float distanza = 0.0F ;
        private void controlla () throws PoligonoErrato
        {
                for (int i =0 ; i < N_VERTICI ; i++)
                  if (vertici[i] < 0)
                    throw new PoligonoErrato ("Vertice < 0") ;
        }

        public Poligono clona()
        {
	   Poligono a =null;
	   try {
		  a =new  Poligono ( vertici , colore) ;
	   } catch (PoligonoErrato ecce ) { }
	   return a ;
        }

        public boolean tuttoNega () {
          for ( int i = 0 ; i < N_VERTICI ; i++)
            if (verticiPoligono [vertici[i]].getY() > 0.0F)
              return false ;
          return true ;
        }

        public void disegnati ( Graphics g)
	{
           if (tuttoNega())
             return ;
           Rectangle r = g.getClipBounds();
	   int x [] = new int [N_VERTICI] ;
	   int z [] = new int [N_VERTICI] ;
	   for ( int i = 0 ; i < N_VERTICI ; i++)
	   {
		Punto corr=verticiPoligono [vertici[i]] ;
		x[i]=(int) ((r.width * corr.getX()) / corr.getY()) ;
		x[i]+= r.width / 2 ;
		z[i] = (int) (( r.height* corr.getZ()) / corr.getY()) ;
		z[i] = r.height / 2 - z [i] ;
	   }
	   g.setColor (colore );
           g.fillPolygon(x, z,N_VERTICI);
        }


	public void setPunti (Punto [] arra) {
	   verticiPoligono=arra ;
	}

        public void calcolaDistanza() {
          distanza = 0.0F ;
          if (verticiPoligono == null)
            return ;
         for ( int i = 0 ; i < N_VERTICI ; i++)
           distanza+=verticiPoligono[vertici[i]].getY() ;
        }

        public int compareTo (Object o)
        {
	   float temp = distanza - ((Poligono) o).distanza ;
           if (temp >0.0f)
  	     return -1 ;
	   else if ( temp < 0.0f)
  	     return 1 ;
	   else
	     return 0 ;
	}	    	

        public void controlla (int maxVertice ) throws PoligonoErrato
        {
                for (int i =0 ; i < N_VERTICI ; i++)
                  if (vertici[i] > maxVertice)
                    throw new PoligonoErrato ("Vertice fuori range") ;
        }

        public Poligono ( int a , int b, int c , int d , Color col)
                 throws PoligonoErrato
        {
                vertici = new int [N_VERTICI] ;
                vertici[0] =a ;
                vertici[1]= b ;
                vertici[2]= c ;
                vertici[3]= d ;
                controlla() ;
                colore = new Color (col.getRed() , col.getGreen(), col.getBlue());
        }

	public Poligono ( int vert [] , Color col)
                 throws PoligonoErrato
        {
	   vertici= new int [N_VERTICI] ;
           System.arraycopy ( vert , 0, vertici , 0 , N_VERTICI );
           controlla() ;
	   colore = new Color (col.getRed() , col.getGreen(), col.getBlue()) ;
	}

	public  int vertice (int indice) {
		return vertici[indice] ;
	}

        public Color getColore () {
		return new Color
		(colore.getRed() , colore.getGreen(), colore.getBlue()) ;
        }

        void stampa ()
        {
             for ( int i = 0 ; i < N_VERTICI ; i++ )
              System.out.println ("Vertice n " + i + " = " + vertice(i));
             System.out.print ("Colore : ") ;
              System.out.println ("Red = " + colore.getRed()
	       +" Green = " +colore.getGreen() + " Blue = " +colore.getBlue()
	       ) ;
        }
}