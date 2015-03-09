package treD ;

import java.awt.* ;
import java.awt.event.* ;

public class FrameCine extends Frame
     implements ActionListener
{
        private final String Nomi [] = {
           "Destra", "Sinistra", "Alto" , "Basso", "Avanti" , "Indietro"
           , "Ruota +", "Ruota -" ,"Record", "Stop", "Nuova" ,"Chiudi",
	   "Esci" , "Logga"
	} ;
	private static final int DEF_X = 100 ;
	private static final int DEF_Y = 100 ;
	private static int numeroFrame = 1 ;
	private int startx ;
	private int starty ;
        private final float DEF_MUOVI = 1F ;
        private final float DEF_RUOTA = (float) (Math.toRadians(5.0)) ;
        private final int LUNG_TESTO = 50 ;

        private Cinepresa cine ;

        private TextField testo ;
        private Panel panne ;
        private Button bottoni [] ;

        private void aggiustaTesto () {
                testo.setText ("Posizione cinepresa: " + cine.getPosizione());
        }

        private void ricalcola ()
        {
                aggiustaTesto () ;
                cine.repaint () ;
        }

        public void actionPerformed (ActionEvent e)
        {
             String azio = e.getActionCommand () ;
             int i = 0 ;
             for (; i < Nomi.length ; i++)
               if (azio.equals (Nomi[i]))
                 break ;
             switch (i) {
               case 0 : // destra
                    cine.muoviX(DEF_MUOVI) ;
                    break ;
               case 1 : // sinistra
                    cine.muoviX(-DEF_MUOVI) ;
                    break ;
               case 2 : // alto
                    cine.muoviZ(DEF_MUOVI) ;
                    break ;
               case 3 : // basso
                    cine.muoviZ(-DEF_MUOVI) ;
                    break ;
	       case 4 : // aumenta y
		    cine.muoviY (DEF_MUOVI) ;
		    break ;
	       case 5 : // diminuisce y
	            cine.muoviY (-DEF_MUOVI) ;
		    break ;
               case 6 : // ruota in senso orario
                    cine.ruota (DEF_RUOTA) ;
                    break ;
               case 7 : // ruota in senso antiorario
                    cine.ruota ( -DEF_RUOTA) ;
                    break ;
               case 10 : // nuova
		    Cinepresa nuovaCine = new Cinepresa (cine) ;
		    numeroFrame++ ;	
		    FrameCine nuovo =
		    new FrameCine ("Cinepresa ", nuovaCine,startx+30,starty+30) ;
		    nuovo.go() ;	
		    break ;
	       case 11 : // chiudi
		    numeroFrame-- ;
		    if (numeroFrame==0) 	
		       System.exit(0) ;	
		    removeAll() ;		
	            dispose() ;		
		    break ;	
	       case 12 : // esci
		    System.exit(0) ;
		    break ;
	       case 13 :	
                    cine.getMondo3D().logga() ;
		    break ;
             }
             if (i == 8) // Record
               cine.premiRecord () ;
             else if ( i ==9) // Fermoimmagine
               cine.premiFermoImmagine() ;
	     else
               ricalcola() ; 	       	
         }

        public void go() {
          setLocation (DEF_X,DEF_Y) ;
	  setLocation (startx,starty) ;
	  setVisible(true) ;
	  cine.premiRecord() ;
        }


	public FrameCine (String titolo , Cinepresa c , int x , int y )
	{
                super (titolo) ;
		startx = x ;
		starty = y ;
                cine=c ;
                panne = new Panel() ;
                panne.setLayout ( new GridLayout (2,5));
                testo = new TextField ("",LUNG_TESTO) ;
                testo.setEditable(false) ;
                aggiustaTesto() ;
                add( testo, BorderLayout.NORTH) ;
                bottoni = new Button [Nomi.length] ;
                for ( int j = 0 ; j < 2 ; j++)
                 for ( int i = j ; i < Nomi.length ; i+=2)
/*******
        prima i pari poi i dispari
*********/
                {
                  bottoni[i]= new Button ( Nomi[i]) ;
		  bottoni[i].addActionListener (this) ;
                  panne.add (bottoni[i]);
                }
                add (cine, BorderLayout.CENTER) ;
                add (panne , BorderLayout.SOUTH);
		aggiustaTesto() ;
                pack();
        }

        public FrameCine ( String titolo , Cinepresa c)
	{
	   this (titolo , c ,DEF_X , DEF_Y) ;
	}
}
