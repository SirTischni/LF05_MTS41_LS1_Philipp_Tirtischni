import java.util.Scanner;

class Fahrkartenautomat {
    private static Scanner tastatur = new Scanner(System.in);

    public static void main(String[] args) {
        Enum<FahrkartentypenAB> fahrkartentypenABEnum;

        begruessung();

        fahrkartenTypen();

        fahrkartentypenABEnum = auswahlFahrkartenTyp();

        var zuZahlenderBetrag = farhkartenbestllungErfassung();

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

    public static double farhkartenbestllungErfassung(){
        System.out.println("\n Wie groß ist der Ticketpreis?");
        var ticketPreis = tastatur.nextFloat();

        if(ticketPreis > 10 || ticketPreis < 0) {
            ticketPreis = 1;
            System.out.println("Ungültige Eingabe; Ticket Preis wird auf 1 gesetzt");
        }

        System.out.printf("Der Ticket Preis beträgt %f Euro", ticketPreis);
        System.out.println("\n Wie viel Tickets wollen sie kaufen?");
        var anzahlTickets = tastatur.nextInt();

        if (anzahlTickets > 10 || anzahlTickets < 0) {
            anzahlTickets = 1;
            System.out.println("\n Ungültige Eingabe. Wert wird auf 1. gesetzt");
        }

        System.out.println("Ticketanzahl entspricht " + anzahlTickets);
        return  anzahlTickets * ticketPreis;
    }


    public static void fahrkartenTypen(){
    System.out.println("Folgende Karten stehen ihnen zur Auswahl:");

    int k = 0;

    for (FahrkartentypenAB kartenTyp : FahrkartentypenAB.values())
    {
        System.out.println("Typ: " + kartenTyp.toString() + " Number: " + k);
        k++;
    }
    }

    public static FahrkartentypenAB auswahlFahrkartenTyp(){
        while (true) {
            System.out.println("Bitte wählen Sie eine Nummer aus, die dem Ticket entspricht");
            var kartenIntiger = tastatur.nextInt();
            if (kartenIntiger > FahrkartentypenAB.values().length || kartenIntiger < 0)
            {
                System.out.println(kartenIntiger + " ist nicht wählbar. Bitte wählen sie einen Wert zwischen 0 und " + FahrkartentypenAB.values().length);
                continue;
            };

            switch(kartenIntiger)
            {
                case 0:
                    return FahrkartentypenAB.Kurzstrecken;
                case 1:
                    return FahrkartentypenAB.Einzelfahrscheine;
                case 2:
                    return FahrkartentypenAB.Tageskarten;
                case 3:
                    return FahrkartentypenAB.VierFahrtenKarten;
                default:
                    return FahrkartentypenAB.Kurzstrecken;
            }
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


}