package me.berniga;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 04/12/2021, sabato
 * @notes : cambiato metodo nella classe scaffale xche, essendo NUM_RIPIANI static final,
 *          nn avrebbe senso invocarlo su un istanza
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Scaffale s1=new Scaffale();
        String choice;
        System.out.println("S1:\nNSHELVES: "+Scaffale.getNumRipiani()+"\tNMAXBOOKS: "+s1.getNumMaxLibri()+"\tNBOOKS: "+s1.getNumLibri());
        System.out.print("-----------------------------------------\nType your choice: ");
        while(!(choice= scan.nextLine()).equalsIgnoreCase("exit")){
            try{
                switch(choice){
                    case "set":
                        System.out.println("Type the TITLE ,the AUTHOR,PAGES,the SHELF and the POSITION,separated by a comma");
                        String[] temp=scan.nextLine().split(",");
                        s1.setLibro(new Libro(temp[0],temp[1],Integer.parseInt(temp[2])),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
                        break;
                    case "remove": case "get":
                        System.out.println("  Type the shelf: ");
                        int shelf= scan.nextInt();
                        System.out.println("  Type the position: ");
                        int position= scan.nextInt();
                        scan.nextLine();        //se nn si mettesse il successico scan di CHOICHE prende la parte rimanente della linea dopo i 2 nextInt
                        if(choice.equalsIgnoreCase("remove"))
                            s1.rimuoviLibro(shelf,position);
                        else
                            System.out.println(s1.getLibro(shelf,position).toString());
                        break;
                    default: System.out.println("Invalid choice");
                }
            }
            catch(PosizioneNonValida | PosizioneNonVuota | NullPointerException e ){System.out.println(e.toString());}
            System.out.print("-----------------------------------------\nType your choice: ");
        }
    }
}
