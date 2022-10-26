import java.util.Random;
import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Levels.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Levels
{
    Queue<String> speicherQueue = new Queue<String>();
    Queue<String> drueckQueue = new Queue<String>();
    Queue<String> blinkQueue = new Queue<String>();
    Queue<String> tempOpferQueue = new Queue<String>();
    
    Simon s = new Simon();
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    Queue q = new Queue();
    String [] farbEingabe = new String[s.level];
    
    //Levels() throws InterruptedException{
        //damit beim Klassenaufruf direkt die Queue gefüllt wird
      //  generiereZufaelligeFarbe();
    //}
    
    public void generiereZufaelligeFarbe() throws InterruptedException{
        /*
         * 1.Handlung, Zahlen werden zufällig bestimmt.
         * 0 = Grün
         * 1 = Rot
         * 2 = Gelb
         * 3 = Blau
         */    
        for(int i = 0; i < s.level; i++){    
            int zahl = r.nextInt(4);
            farbeHinzufuegen(zahl);
        }
        //farbeAusgeben();
    }
    public void farbeHinzufuegen(int pFarbe) throws InterruptedException{
        //2. Handlung, Farben werden bestimmt und in die Speicher Queue hinzugefügt
        String farbe = "";
        switch (pFarbe) {
            case 0:
                farbe = "gruen";
                break;
            case 1:
                farbe = "rot";
                break; 
            case 2:
                farbe = "gelb";
                break;
            case 3:
                farbe = "blau";
                break;
        }
        speicherQueue.enqueue(farbe);
    }
    public void kopiereQueue() throws InterruptedException{
        // 3. Handlung, Speicher Queue wird kopiert, um die Queue 2 mal zu haben
        // einmal zum ausgeben und einmal zum überprüfen 
        while (speicherQueue.isEmpty() != true){
            drueckQueue.enqueue(speicherQueue.front());
            blinkQueue.enqueue(speicherQueue.front());
            speicherQueue.dequeue();
        }
    }
    public void farbeAusgeben()throws InterruptedException{
        //4. Handlung: Farben aus der Blink Queue werden alle 
        //nacheinander ausgegeben.
        while (blinkQueue.isEmpty() != true){
            System.out.println(blinkQueue.front());
            blinkQueue.dequeue();
        }
    }
    public void farbeEingeben() throws InterruptedException{
        //5. Handlung, Spieler soll die gemerkten Farben eingeben
        System.out.println("Geben sie nun bitte unten ihre gemerkten Zahlen nacheinander ein.");
        for(int i = 0; i < s.level; i++){
            String Eingabe = sc.nextLine();
            farbEingabe[i] = Eingabe;
            if (ueberpruefeEingabe(Eingabe) == false){
                s.spielEnde(s.geschafft);
            }
        }
    }
    public boolean ueberpruefeEingabe(String pEingabe) throws InterruptedException{
        //6. Handlung, 
        //for( int i = 0; i < s.level; i++){
            if(pEingabe == drueckQueue.front()){
                drueckQueue.dequeue();
                return true;
            } else {
                s.geschafft = 1;
                return false;
            }
        //}
    }
}
