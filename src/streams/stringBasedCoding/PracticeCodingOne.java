package streams.stringBasedCoding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeCodingOne {

    public static void main(String[] args) {
        solutionSix();
        solutionSeven();
        solutionEight();
        solutionNine();
        solutionTen();
    }
    /*
     * 6. Check whether two Strings are anagrams
     * 7. Count vowels in a String
     * 8. Find the first repeated character
     * 9. Find the longest word in a String
     * 10. Count the frequency of each word
     */

    // 6. Check whether two Strings are anagrams
    public static void solutionSix() {
        String s1 = "listen";
        String s2 = "silent";

        /* Incase of Dynamic input scenario */
        if (s1.length() != s2.length()) {
            System.out.println("::Solution-6-A :: " + false);
        }

        String a = s1.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        String b = s1.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

        System.out.println("::Solution-6 :: " + a.equals(b));
    }

    // 7. Count vowels in a String
    public static void solutionSeven() {
        String str = "Hello World";
        Long res = str
                .toLowerCase()
                .chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();

        System.out.println("::Solution-7 :: " + res);
    }

    // 8. Find the first repeated character
    public static void solutionEight() {
        String str = "programming";

        HashSet<Character> set = new HashSet<>();

        char res = str
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !set.add(c))
                .findFirst()
                .orElseThrow(null);

        System.out.println("::Solution-8 :: " + res);
    }

    // 9. Find the longest word in a String
    public static void solutionNine() {
        String str = "Java is very powerful";

        String res = Arrays.stream(str.split("\\s+")) // [Java, is, very, powerful]
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(null);

        System.out.println("::Solution-9 :: " + res);

    }

    // 10. Count the frequency of each word
    public static void solutionTen() {
        String str = "java spring java sql spring java";

        Map<String, Long> res = Arrays.stream(str.split("\\s+"))
                .collect(
                        Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()));

        System.out.println("::Solution-10 :: " + res);
        solutionEleven();
    }

    // 10A. Count the frequency of each word in the List
    public static void solutionEleven() {
        String[] str = { "Can", "You", "Bring", "A", "Glass", "Of", "Water", "But", "Water", "shold", "be", "clean" };

        Map<String, Long> res = Arrays.stream(str)
                .map(String::toLowerCase)
                .collect(
                        Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()));

        System.out.println("::Solution-10A :: " + res);
    }

}
