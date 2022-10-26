import java.util.concurrent.TimeUnit;
public class Simon
{
    Levels l = new Levels();
    public boolean spielEnde;
    
    //zahl = 0 --> Spiel gewonnen, zahl = 1 --> spiel verloren
    public int geschafft = 0;
    
    public int level = 1;
    
    Simon() throws InterruptedException{
        erstelleLevel(level);
    }
    
    public void erstelleLevel(int momentanesLevel) throws InterruptedException{
        l.generiereZufaelligeFarbe();
        }
    
    public void spielen() throws InterruptedException {
        spielEnde = true;
        
        //Spielanleitung
        System.out.println("Spielvorgehen: ");
        System.out.println("1. Farbe(n) wird/werden angezeigt, merke sie dir! ");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("2. Gebe die Farben in der richtigen Reihenfolge ein. ");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("3. Wenn es richtig ist, gelangst du in das nächste Level, ");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("wenn nicht, dann hast du verloren ;) ");
        TimeUnit.SECONDS.sleep(3);
        
        
        while(spielEnde != true){
            erstelleLevel(level);
        }
        spielEnde(geschafft);
    }
    
    public void spielEnde(int z){
        if (geschafft == 0){
            System.out.println("Herzlichen Glückwunsch, du hast alle Level in unserem Spiel erfolgreich gemeistert!");
        } else{
            //Überlegung: Spieler soll Ja oder Nein reinschreiben jenachdem, ob 
            // er noch eine Runde spielen will und die neue Runde wird automatisch
            //gestartet
            System.out.println ("Leider verloren, starte das Spiel neu, um es noch einmal zu versuchen.");
        }
    }
}
