package it.unibo.oop.lab.collections1;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	public static final int ELEMS = 100_000;
	public static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	List<Integer> a = new ArrayList<>();
    	for (int i = 1000; i < 2000; i++) {
    		a.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	List<Integer> l = new LinkedList<>();
    	l.addAll(a);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int tmp = a.get(0);
    	a.set(0, a.get(a.size() - 1));
    	a.set(a.size() - 1, tmp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (int el : a) {
    		System.out.println(el);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	for (int i = 2000; i <= ELEMS; i++) {
    		a.add(i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Inserting " + ELEMS + " items in an ArrayList took " + time / TO_MS + " ms");
    	
    	time = System.nanoTime();
    	for (int i = 2000; i <= ELEMS; i++) {
    		l.add(i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Inserting " + ELEMS + " items in a LinkedList took " + time / TO_MS + " ms");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	time = System.nanoTime();
    	for (int i = 0; i < 1000; i++) {
    		a.get(a.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading the item in the middle of an ArrayList 1000 times took " + time / TO_MS + " ms");
    	
    	time = System.nanoTime();
    	for (int i = 0; i < 1000; i++) {
    		l.get(l.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Reading the item in the middle of a LinkedList 1000 times took " + time / TO_MS + " ms");
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String, Long> m = new HashMap<>();
    	m.put("Africa", 110_635_000L);
    	m.put("Americas", 972_005_000L);
    	m.put("Antartica", 0L);
    	m.put("Asia", 4_298_723_000L);
    	m.put("Europe", 742_752__000L);
    	m.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long population = m.get("Africa") + m.get("Americas") + m.get("Antartica") + m.get("Asia") + m.get("Europe") + m.get("Oceania");
    	System.out.println("There are " + population + " people in the world");
    	
    }
}
