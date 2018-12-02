package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static IntJoukko[] joukkoTaulukko;

    private static IntJoukko mikaJoukko() {
        String luettu;
        Scanner lukija = new Scanner(System.in);
        luettu = lukija.nextLine();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = lukija.nextLine();
            }
        }
    }

    private static void lisaa() {
        IntJoukko joukko = valitseIntJoukko(0);
        if (joukko == null) {
            return;
        }
        System.out.println("Mikä luku lisätään?");
        joukko.lisaa(new Scanner(System.in).nextInt());
    }

    private static void yhdiste() {
        IntJoukko aJoukko = valitseIntJoukko(1);
        IntJoukko bJoukko = valitseIntJoukko(2);
        if (aJoukko == null || bJoukko == null) {
            return;
        }
        IntJoukko c = IntJoukko.yhdiste(aJoukko, bJoukko);

        System.out.println("Yhdiste= " + c.toString());
        return;
    }

    private static IntJoukko valitseIntJoukko(int numero) {
        if (numero == 0) {
            System.out.println("Valitse joukko ");
            return valitseJoukko(new Scanner(System.in).nextLine());
        } else {
            System.out.println(numero + ". joukko");
            return valitseJoukko(new Scanner(System.in).nextLine());
        }
    }

    private static void leikkaus() {
        IntJoukko aJoukko = valitseIntJoukko(1);
        IntJoukko bJoukko = valitseIntJoukko(2);
        if (aJoukko == null || bJoukko == null) {
            return;
        }
        IntJoukko c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("Leikkaus = " + c.toString());
        return;
    }

    private static void erotus() {
        IntJoukko aJoukko = valitseIntJoukko(1);
        IntJoukko bJoukko = valitseIntJoukko(2);
        if (aJoukko == null || bJoukko == null) {
            return;
        }
        IntJoukko c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("Leikkaus = " + c.toString());
        return;
    }

    private static void poista() {
        IntJoukko joukko = valitseIntJoukko(0);
        if (joukko == null) {
            return;
        }
        System.out.println("Mikä luku poistetaan?");
        joukko.poista(new Scanner(System.in).nextInt());
        System.out.println("Luku poistettu joukosta!");
        return;
    }

    private static void kuuluu() {
        int kysLuku;
        IntJoukko joukko = valitseIntJoukko(0);
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = new Scanner(System.in).nextInt();
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
        return;
    }

    public static void tervetuloa() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }

    public static IntJoukko valitseJoukko(String joukko) {
        if (joukko.equalsIgnoreCase("A")) {
            return joukkoTaulukko[0];
        } else if (joukko.equalsIgnoreCase("B")) {
            return joukkoTaulukko[1];
        } else if (joukko.equalsIgnoreCase("C")) {
            return joukkoTaulukko[2];
        }
        System.out.println("Väärä joukko");
        return null;
    }

    public static boolean menu() {
        String luettu = new Scanner(System.in).nextLine();
        if (luettu.equals("lisää") || luettu.equals("li")) {
            lisaa();
        } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
            poista();
        } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
            kuuluu();
        } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
            yhdiste();
        } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
            leikkaus();
        } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
            erotus();
        } else if (luettu.equalsIgnoreCase("A")) {
            System.out.println(A);
        } else if (luettu.equalsIgnoreCase("B")) {
            System.out.println(B);
        } else if (luettu.equalsIgnoreCase("C")) {
            System.out.println(C);
        } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
            System.out.println("Lopetetaan, moikka!");
            return false;
        } else {
            System.out.println("Virheellinen komento! " + luettu);
        }
        return true;
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        joukkoTaulukko = new IntJoukko[]{A, B, C};
        String luettu;
        tervetuloa();
        Scanner lukija = new Scanner(System.in);
        while (menu()) {
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
