package com.example.polymorphism;

import java.util.*;

class arrayCalc {
    static int NUM_OF_CHARS = 26;

    boolean anagrams(String word1, String word2) {
        System.out.println("Inside arrayCalc's anagrams method:");

        if (word1.length() != word2.length())
            return false;
        int[] count = new int[NUM_OF_CHARS];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < NUM_OF_CHARS; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }
}

class mapCalc extends arrayCalc {
    boolean anagrams(String word1, String word2) {
        System.out.println("Inside mapCalc's anagrams method:");

        HashMap<Character, Integer> hmap1
                = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmap2
                = new HashMap<Character, Integer>();

        for (int i = 0; i < word1.length(); i++) {
            if (!hmap1.containsKey(word1.charAt(i))) {
                hmap1.put(word1.charAt(i), 1);
            } else {
                int c = (int) hmap1.get(word1.charAt(i));
                hmap1.put(word1.charAt(i), ++c);
            }
        }

        for (int j = 0; j < word2.length(); j++) {
            if (!hmap2.containsKey(word2.charAt(j))) {
                hmap2.put(word2.charAt(j), 1);
            } else {

                int d = (int) hmap2.get(word2.charAt(j));
                hmap2.put(word2.charAt(j), ++d);
            }
        }

        if (hmap1.equals(hmap2))
            return true;
        else
            return false;
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        arrayCalc a = new arrayCalc();
        mapCalc b = new mapCalc();
        arrayCalc ref;

        ref = a;
        if (ref.anagrams("whdyg", "gydhw"))
            System.out.println("The two Strings are anagrams");
        else {
            System.out.println("The two Strings are not anagrams");
        }

        ref = b;
        if (ref.anagrams("whdyg", "gydhw"))
            System.out.println("The two Strings are anagrams");
        else {
            System.out.println("The two Strings are not anagrams");
        }
    }
}
