public class App  {
    public static void main( String[] args ) {

        VersichertePerson person = new VersichertePerson("Test", 0);
        Kundenberater berater = new Kundenberater("Berater", "Deutsch");

        person.setKundenberater(berater);

        System.out.println(person.getName());
        System.out.println(berater.getName());

    }
}
