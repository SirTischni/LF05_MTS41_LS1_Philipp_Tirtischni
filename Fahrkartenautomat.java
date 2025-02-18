import java.util.Scanner;

class Fahrkartenautomat {
    private static Scanner tastatur = new Scanner(System.in);
    private static final Fahrkartentyp[] Fahrkartentypen = {
            new Fahrkartentyp(3.00, "Einzelfahrschein AB"),
            new Fahrkartentyp(3.5, "Einzelfahrschein BC"),
            new Fahrkartentyp(3.8, "Einzelfahrschein ABC"),
            new Fahrkartentyp(2.0, "Kurzstrecke AB"),
            new Fahrkartentyp(8.6, "Tageskarte AB"),
            new Fahrkartentyp(9.2, "Tageskarte BC"),
            new Fahrkartentyp(10.00, "Tageskarte ABC"),
            new Fahrkartentyp(9.4, "4-Fahrten-Karte AB"),
            new Fahrkartentyp(12.6, "4-Fahrten-Karte BC"),
            new Fahrkartentyp(25.5, "Kleingruppen-Tageskarte AB"),
            new Fahrkartentyp(26.0, "Kleingruppen-Tageskarte BC"),
            new Fahrkartentyp(26.5, "Kleingruppen-Tageskarte ABC"),
    };

    public static void main(String[] args) {

        begruessung();

        fahrkartenTypen();

        var ausgewählteFahrkarte = auswahlFahrkartenTyp();

        var zuZahlenderBetrag = farhkartenbestllungErfassung(ausgewählteFahrkarte);

        var eingezahlterGesamtbetrag = fahrkartenBezahlen(zuZahlenderBetrag);

        fahkartenAusgabe();

        rueckgeldAusgabe(eingezahlterGesamtbetrag, zuZahlenderBetrag);

        System.out.println("\nVergessen Sie nicht, den Fahrschein \n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }



    public static void begruessung (){
        System.out.println("Herzlich Willkommen");
    }

    public static double farhkartenbestllungErfassung(Fahrkartentyp ausgewählteFahrkarte){


        System.out.printf("Sie haben das Ticket %s ausgewählt.", ausgewählteFahrkarte.Fahrkartenname);
        System.out.printf("Der Ticket Preis beträgt %f Euro", ausgewählteFahrkarte.Fahkartenwert);
        System.out.println("\n Wie viel Tickets wollen sie kaufen?");
        var anzahlTickets = tastatur.nextInt();

        if (anzahlTickets > 10 || anzahlTickets < 0) {
            anzahlTickets = 1;
            System.out.println("\n Ungültige Eingabe. Wert wird auf 1. gesetzt");
        }

        System.out.println("Ticketanzahl entspricht " + anzahlTickets);
        return  anzahlTickets * ausgewählteFahrkarte.Fahkartenwert;
    }


    public static void fahrkartenTypen(){
    System.out.println("Folgende Karten stehen ihnen zur Auswahl:");


    for (var i = 0; i < Fahrkartentypen.length; i++)
    {
        System.out.println("Typ: " + Fahrkartentypen[i].Fahrkartenname + " || Kosten: " + Fahrkartentypen[i].Fahkartenwert + " || Nummer: " + i);
    }
    }

    public static Fahrkartentyp auswahlFahrkartenTyp(){
        while (true) {
            System.out.println("Bitte wählen Sie eine Nummer aus, die dem Ticket entspricht");
            var kartenIntiger = tastatur.nextInt();
            if (kartenIntiger > Fahrkartentypen.length || kartenIntiger < 0)
            {
                System.out.println(kartenIntiger + " ist nicht wählbar. Bitte wählen sie einen Wert zwischen 0 und " + Fahrkartentypen.length);
                continue;
            };

            return Fahrkartentypen[kartenIntiger];
        }
    }

    public static double fahrkartenBezahlen(double zuZahlenderBetrag){

        System.out.printf("\n Zu zahlender Betrag : %f Euro", zuZahlenderBetrag );

        var eingezahlterGesamtbetrag = 0.0;
        var nochZuZahlen = 0.0;

        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf(" \n Noch zu zahlen: %d Euro", (int) nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro: ");
            var eingeworfeneMuenze = tastatur.nextDouble();

            if (eingeworfeneMuenze > 2.00 || eingeworfeneMuenze < 0.05) {
                System.out.print("Bitte werfen sie die Passenden Münzen ein");
            }

            eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
        }
        return eingezahlterGesamtbetrag;
    }

    public static void fahkartenAusgabe(){
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                System.out.println(" Error: " + e);
            }
        }
    }

    public static void rueckgeldAusgabe(double eingezahlterGesamtbetrag, double zuZahlenderBetrag){
        var rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
        while (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
            System.out.println(" wird in folgenden Münzen ausgezahlt:");

            if (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
                continue;
            }
            if (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
                continue;
            }
            if (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;
                continue;
            }
            if (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;
                continue;
            }
            if (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;
                continue;
            }
            if (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;
                continue;
            }

            System.out.println("Restbetrag kleiner als 5 cent. Betrag wird auf 0 gesetzt");
            rueckgabebetrag = 0;
        }
    }

    public enum FahrkartentypenAB {
        Kurzstrecken,
        Einzelfahrscheine,
        Tageskarten,
        VierFahrtenKarten

    }

    public static class Fahrkartentyp {
        public String Fahrkartenname;
        public Double Fahkartenwert;

        public Fahrkartentyp(Double fahkartenwert, String fahrkartenname) {
            this.Fahkartenwert = fahkartenwert;
            this.Fahrkartenname = fahrkartenname;
        }
    }



}