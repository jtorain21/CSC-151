public class Test {
    public static void main(String[] args) {

        TorainAddress ad1 = new TorainAddress("123 Sesame Street", "New York", "NY", "08330");
        TorainAddress ad2 = new TorainAddress();
        TorainAddress ad3 = new TorainAddress("Greensboro", "NC", "27455");

        System.out.println(ad1.getStreet());
        System.out.println(ad3.getCity() + " " + ad3.getState() + " " + ad3.getZip());

        TorainPerson p1 = new TorainPerson("Donald", "Duck", null, ad1);

        System.out.println(p1.toString());
    }
}
