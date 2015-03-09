package treD ;

public class OggettoAnimato extends Oggetto3D
	implements Runnable
{
	private static final float DEF_ANGOLO =(float) (Math.toRadians(2.0)) ;

        public OggettoAnimato ( Oggetto3D base )
           throws PoligonoErrato
{
	super (base) ;
        Thread t = new Thread(this);
        t.start();
}

	public void run ()
{
               for(;;) {
                 ruota ( DEF_ANGOLO) ;
                try {
                  Thread.sleep(100);
                } catch(InterruptedException e) { }
              }
}
}