package streams.stringBasedCoding;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
1. Find the frequency of each character
2. Find the first non-repeating character
3. Find duplicate characters
4. Remove duplicate characters
5. Reverse a String using Streams
*/
public class PracticeCodingZero {
    public static void main(String[] args) {
        solutionOne();
        solutionTwo();
        solutionThree();
        solutionFour();
        solutionFive();

    }

    // 1. Find the frequency of each character
    public static void solutionOne() {
        String str = "banana";

        Map<Character, Long> res = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("::Solution-1 :: " + res);
    }

    // 2. Find the first non-repeating character
    public static void solutionTwo() {
        String str = "swiss";

        char res = str.chars()
                .mapToObj(c -> (char) c)
                .filter(s -> str.indexOf(s) == str.lastIndexOf(s))
                .findFirst()
                .orElseThrow(null);

        System.out.println("::Solution-2 :: " + res);
    }

    // 3. Find duplicate characters
    public static void solutionThree() {
        String str = "programming";
        Set<Character> seen = new HashSet<>();

        Set<Character> res = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .collect(Collectors.toSet());

        System.out.println("::Solution-3 :: " + res);
    }

    // 4. Remove duplicate characters
    public static void solutionFour() {
        String str = "programming";
        Set<Character> seen = new HashSet<>();
        System.out.println("==>" + str.chars());
        String res = str.chars()
                .mapToObj(c -> (char) c)
                .filter(e -> seen.add(e))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("::Solution-4 :: " + res);

        /* Another Solution */
        String res1 = str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("::Solution-4-A:: " + res1);
    }

    // 5. Reverse a String using Streams
    public static void solutionFive() {
        String str = "Java";

        String res = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (a, b) -> b + a);

        System.out.println("::Solution-5 :: " + res);

    }

}