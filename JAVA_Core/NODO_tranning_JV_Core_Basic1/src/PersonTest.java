public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(args[0]);
        Person p2 = new Person(args[1]);
        System.out.println("Person1's name is "+p1.getName());
        System.out.println("Person2's name is "+p2.getName());
    }
}
