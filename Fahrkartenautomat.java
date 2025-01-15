import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);
        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        double rueckgabebetrag;
        double nochZuZahlen;
        int anzahlTickets;
        float ticketPreis;
        Enum<FahrkartentypenAB> fahrkartentypenABEnum;

        //Kartentypen
        System.out.println("Folgende Karten stehen ihnen zur Auswahl:");
        int k = 0;

        for (FahrkartentypenAB kartenTyp : FahrkartentypenAB.values())
        {
            System.out.println("Typ: " + kartenTyp.toString() + " Number: " + k);
            k++;
        }

        System.out.println("Bitte wählen Sie eine Nummer aus, die dem Ticket entspricht");

        while (true) {
            var kartenIntiger = tastatur.nextInt();
            if (kartenIntiger > FahrkartentypenAB.values().length || kartenIntiger < 0)
            {
                System.out.println(kartenIntiger + " ist nicht wählbar. Bitte wählen sie einen Wert zwischen 0 und " + FahrkartentypenAB.values().length);
                continue;
            };

            switch(kartenIntiger)
            {
                case 0:
                    fahrkartentypenABEnum = FahrkartentypenAB.Kurzstrecken;
                case 1:
                    fahrkartentypenABEnum = FahrkartentypenAB.Einzelfahrscheine;
                case 2:
                    fahrkartentypenABEnum = FahrkartentypenAB.Tageskarten;
                case 3:
                    fahrkartentypenABEnum = FahrkartentypenAB.VierFahrtenKarten;
            }
            break;
        }
        //0

        System.out.println("\n Wie groß ist der Ticketpreis?");
        ticketPreis = tastatur.nextFloat();

        if(ticketPreis > 10 || ticketPreis < 0) {
        ticketPreis = 1;
        System.out.println("Ungültige Eingabe; Ticket Preis wird auf 1 gesetzt");
        }

        System.out.printf("Der Ticket Preis beträgt %f Euro", ticketPreis);
        System.out.println("\n Wie viel Tickets wollen sie kaufen?");
        anzahlTickets = tastatur.nextInt();

        if (anzahlTickets > 10 || anzahlTickets < 0) {
        anzahlTickets = 1;
        System.out.println("\n Ungültige Eingabe. Wert wird auf 1. gesetzt");
        }

        System.out.println("Ticketanzahl entspricht " + anzahlTickets);
        zuZahlenderBetrag = anzahlTickets * ticketPreis;

        // 1
        System.out.printf("\n Zu zahlender Betrag : %f Euro", zuZahlenderBetrag );

        // 2
       eingezahlterGesamtbetrag = 0.0;
       nochZuZahlen = 0.0;

        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf(" \n Noch zu zahlen: %d Euro", (int) nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro: ");
            eingeworfeneMuenze = tastatur.nextDouble();

            if (eingeworfeneMuenze > 2.00 || eingeworfeneMuenze < 0.05) {
            System.out.print("Bitte werfen sie die Passenden Münzen ein");
            }

            eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
        }

        // 3
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
        System.out.println("\n\n");

        // 4
        rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
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

        System.out.println("\nVergessen Sie nicht, den Fahrschein \n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }

    public enum FahrkartentypenAB {
        Kurzstrecken,
        Einzelfahrscheine,
        Tageskarten,
        VierFahrtenKarten

    }
}