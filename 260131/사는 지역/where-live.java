import java.util.*;

class Person implements Comparable<Person> {
    String name, address, region;
    public Person(String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }
    @Override
    public String toString() {
        return new StringBuilder()
            .append("name ").append(name).append("\n")
            .append("addr ").append(address).append("\n")
            .append("city ").append(region)
            .toString();
    }
    @Override
    public int compareTo(Person o) {
        return o.name.compareTo(this.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
        }
        Person[] p = new Person[n];
        for (int i=0; i<n; i++) {
            p[i] = new Person(names[i], addresses[i], regions[i]);
        }
        Arrays.sort(p);
        System.out.println(p[0]);
    }
}