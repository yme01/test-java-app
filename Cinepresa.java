package treD ;



public class Cinepresa extends Telecamera
    implements Runnable
{
     private boolean fermoImmagine = true;

     private synchronized void controllaStato ()
     {
	while (fermoImmagine == true)
           try {
             wait() ;
           } catch (InterruptedException e) {}		
     }	

     public Cinepresa ( Cinepresa start) {
	super (start) ;
        Thread t = new Thread(this);
	t.start();
     }		

     public Cinepresa ( Posizione pos ) {
	super (pos) ;
        Thread t = new Thread(this);
	t.start();
     }

     public Cinepresa () {
             this (new Posizione());
     }

     public synchronized void premiRecord()
     {
	fermoImmagine = false;
        notify() ;
     }

     public void premiFermoImmagine()
     {
	fermoImmagine = true;
     }

     public void run()
     {
	for(;;) {
	   controllaStato () ;
           repaint();
           try {
	     Thread.sleep(250);
	   } catch(InterruptedException e) {}
	}
     }
}
