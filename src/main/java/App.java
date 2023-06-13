import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App  {
    public static void main( String[] args ) {

        VersichertePerson person = new VersichertePerson("Manuel", 0);
        VersichertePerson person2 = new VersichertePerson("Annika", 0);

        Kundenberater berater = new Kundenberater("Max", "Deutsch");
        Kundenberater berater2 = new Kundenberater("Jean", "Französisch");

        person.setKundenberater(berater);
        person2.setKundenberater(berater2);

        List<VersichertePerson> versichertenList = new ArrayList<>();
        versichertenList.add(person);
        versichertenList.add(person2);

        for (VersichertePerson versicherte : versichertenList){
            System.out.println(versicherte.getKundenberater() + " ist Berater von " + versicherte.getName());
        }

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Wähle eine Eingabe:");
            System.out.println("1. Neue Person erfassen");
            System.out.println("2. Alle versicherten Personen ausdrucken");
            System.out.println("3. Abbruch");

            int eingabe = sc.nextInt();

            switch (eingabe) {
                case 1:
                    sc.nextLine(); // Consume the newline character
                    System.out.println("Enter the name:");
                    String name = sc.nextLine();
                    VersichertePerson newClient = new VersichertePerson(name, 0);
                    versichertenList.add(newClient);
                    System.out.println("Versicherte Person erfasst");
                    break;
                case 2:
                    System.out.println("Alle versicherten Personen:");
                    for (VersichertePerson versicherte : versichertenList) {
                        System.out.println(versicherte.getName());
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Bitte wähle etwas anderes!");
            }
        }

        sc.close();

    }
}
