package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
 * 2. You have to find the itinerary in order using the given list of tickets.
 *
 * Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
 *
 * Sample Input
 * 4
 * Chennai Banglore
 * Bombay Delhi
 * Goa Chennai
 * Delhi Goa
 *
 * Sample Output
 * Bombay -> Delhi -> Goa -> Chennai -> Banglore.
 *
 */
public class FindItineraryFromTickets {
    public static void main(String[] args) {
        System.out.println(FindItineraryFromTickets.find(new String[][]{
                {"Chennai", "Banglore"},
                {"Bombay", "Delhi"},
                {"Goa", "Chennai"},
                {"Delhi", "Goa"},
        })); // [Bombay, Delhi, Goa, Chennai, Banglore]
    }

    private static List<String> find(String[][] tickets) {
        var setFrom = new HashSet<String>();
        var setTo = new HashSet<String>();
        var hashMap = new HashMap<String, String>();

        for (var ticket : tickets){
            var from = ticket[0];
            var to = ticket[1];
            setFrom.add(from);
            setTo.add(to);
            hashMap.put(from, to);
        }

        String beginning = null;

        for (var from : setFrom){
           if (!setTo.contains(from)){
               beginning = from;
           }
        }

        var journey = new ArrayList<String>();
        var from = beginning;
        journey.add(from);
        while (true){
            from = hashMap.get(from);
            if (from == null) break;
            journey.add(from);
        }
        return journey;
    }
}
