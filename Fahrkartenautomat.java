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
        System.out.printf("\nZu zahlender Betrag : %f Euro", zuZahlenderBetrag );

        // 2
       eingezahlterGesamtbetrag = 0.0;
        nochZuZahlen = 0.0;

        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
            System.out.printf("Noch zu zahlen: %f Euro", nochZuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro: ");
            eingeworfeneMuenze = tastatur.nextDouble();
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
        if (rueckgabebetrag > 0.0) {
            System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
            System.out.println(" wird in folgenden Münzen ausgezahlt:");

            while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabebetrag = rueckgabebetrag - 2.0;
            }
            while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabebetrag = rueckgabebetrag - 1.0;
            }
            while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.5;
            }
            while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.2;
            }
            while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.1;
            }
            while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabebetrag = rueckgabebetrag - 0.05;
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein \n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wünschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }
}