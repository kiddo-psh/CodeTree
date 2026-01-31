import java.util.*;

class Weather implements Comparable<Weather>{
    String date, day, weather;
    public Weather(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
    @Override
    public int compareTo(Weather o) {
        return this.date.compareTo(o.date);
    }
    @Override
    public String toString() {
        return new StringBuilder()
            .append(date).append(" ")
            .append(day).append(" ")
            .append(weather).toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Weather[] w = new Weather[n];
        for (int i = 0; i < n; i++) {
            String d1 = sc.next();
            String d2 = sc.next();
            String we = sc.next();
            w[i] = new Weather(d1, d2, we);
        }
        Arrays.sort(w);
        for (int i=0; i<n; i++) {
            if (w[i].weather.equals("Rain")) {
                System.out.println(w[i]);
                return;
            }
        }
    }
}