package zwe_rechner;

import java.util.Scanner;

public class UeberstundenZeitwertRechner {
	public static void main(String[] args) {
		rechner();
		menu();
	}

	public static void menu() {
		Scanner input;
		input = new Scanner(System.in);
		// Abfrage neue Berechnung
		System.out.print("Neue Berechnung? y/n: ");
		String antwort = input.next();
		if (antwort.equalsIgnoreCase("y")) {
			System.out.println();
			rechner();
			menu();
		} else {
			System.exit(0);
		}
	}

	public static void rechner() {
		int tagesSoll = 78;
		int kommt;
		int geht;
		int anwesend;
		int arbeitszeit = 0;
		int ueberstunden;

		Scanner input = new Scanner(System.in);
		// Abfrage wann gekommen
		System.out.print("Kommt in ZWE: ");
		kommt = input.nextInt();
		if (kommt < 0 || kommt > 135) {
			System.out.println("Fehler - Bitte Zeitwert von 0 bis 135 eingeben!");
			System.exit(0);
		}

		// Abfrage wann gehen
		System.out.print("Geht in ZWE: ");
		geht = input.nextInt();

		if (geht < 0 || geht > 135) {
			System.out.println("Fehler - Bitte Zeitwert von 0 bis 135 eingeben!");
			System.exit(0);
		}

		// Anwesendheitszeit berechnen
		anwesend = geht - kommt;

		// Arbeitszeit berechnen
		if (anwesend < 60) {
			arbeitszeit = anwesend;
		} else if (anwesend >= 60 && anwesend <= 65) {
			arbeitszeit = 60;
		} else if (anwesend > 65 && anwesend <= 95) {
			arbeitszeit = anwesend - 5;
		} else if (anwesend > 95 && anwesend <= 97) {
			arbeitszeit = 90;
		} else if (anwesend > 97 && anwesend <= 108) {
			arbeitszeit = anwesend - 8;
		} else if (anwesend > 108) {
			System.out.println("Fehler - Zu lange gearbeitet!");
			System.exit(0);
		} else {
			System.out.println("Fehler - Zeitwerteinheiten stimmen nicht!");
			System.exit(0);
		}
		// Ueberstunden Berechnung
		ueberstunden = arbeitszeit - tagesSoll;

//		// Debug Ausgabe
//		System.out.println(kommt);
//		System.out.println(geht);
//		System.out.println(anwesend);
//		System.out.println(arbeitszeit);
//		System.out.println(ueberstunden);

		// Ausgabe
		System.out.println("\nGeht \tKommt \tEinheiten ohne Üst.\n" + geht + "\t" + kommt + "\t" + ueberstunden);
	}
}