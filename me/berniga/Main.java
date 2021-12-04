package me.berniga;
import java.util.Random;
/**
 * @author : Christian Benriga
 * @class : 4 D
 * @created : 04/12/2021, sabato
 * @notes : cambiato metodo nella classe scaffale xche, essendo NUM_RIPIANI static final,
 *          nn avrebbe senso invocarlo su un istanza
 **/
public class Main {
    public static void main(String[] args) {
        Scaffale s1=new Scaffale();
        System.out.println("S1:\nNSHELVES: "+Scaffale.getNumRipiani()+"\tNMAXBOOKS: "+s1.getNumMaxLibri()+"\tNBOOKS: "+s1.getNumLibri());
        /*
        NO EXCEPTIONS THROWN
        */
        System.out.println("---------------------------------------\nNO EXCEPTIONS THROWN");
        try{s1.setLibro(new Libro("FirstTitle","FirstAuthor",new Random().nextInt(1000)+100),1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(PosizioneNonVuota e1){System.out.println(e1.toString());}

        try{System.out.println(s1.getLibro(1,0).toString()+"\nNBOOKS SHELF 1: "+s1.getNumLibri(1));}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(NullPointerException e1){System.out.println("NullPointerException unhandled");}   //xche nel getLibro si può verificare anche una NullPointerException

        try{s1.rimuoviLibro(1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}

        /*
        POSIZIONENONVALIDA EXCEPTIONS THROWN
        */
        System.out.println("---------------------------------------\nPOSIZIONENONVALIDA EXCEPTIONS THROWN");
        try{s1.setLibro(new Libro("SecondTitle","SecondAuthor",new Random().nextInt(1000)+100),-1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(PosizioneNonVuota e1){System.out.println(e1.toString());}

        try{ System.out.println(s1.getLibro(-1,0).toString());}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(NullPointerException e1){System.out.println("NullPointerException unhandled");}

        try{s1.rimuoviLibro(100,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}

        /*
        POSIZIONENONVUOTA EXCEPTIONS THROWN
        */
        System.out.println("---------------------------------------\nPOSIZIONENONVUOTA EXCEPTIONS THROWN");
        try{s1.setLibro(new Libro("ThirdTitle","ThirdAuthor",new Random().nextInt(1000)+100),1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(PosizioneNonVuota e1){System.out.println(e1.toString());}

        try{s1.setLibro(new Libro("FourthTitle","FourthAuthor",new Random().nextInt(1000)+100),1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(PosizioneNonVuota e1){System.out.println(e1.toString());}

        /*
        NULLPOINTEREXCEPTION EXCEPTIONS THROWN
        */
        System.out.println("---------------------------------------\nNULLPOINTEREXCEPTION EXCEPTIONS THROWN");
        try{s1.rimuoviLibro(1,0);}
        catch(PosizioneNonValida e){System.out.println(e.toString());}

        try{ System.out.println(s1.getLibro(1,0).toString());}
        catch(PosizioneNonValida e){System.out.println(e.toString());}
        catch(NullPointerException e){System.out.println("NullPointerException unhandled");}

    }
}
