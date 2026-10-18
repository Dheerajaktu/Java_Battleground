package streams.stringBasedCoding;

import java.util.Map;
import java.util.stream.Collectors;

/*
1. Find the frequency of each character
2. Find the first non-repeating character
3. Find duplicate characters
4. Remove duplicate characters
5. Reverse a String using Streams
6. Check whether two Strings are anagrams
7. Count vowels in a String
8. Find the first repeated character
9. Find the longest word in a String
10. Count the frequency of each word
*/
public class PracticeCoding {
    public static void main(String[] args) {
        solutionOne();
        solutionTwo();

    }

    // 1. Find the frequency of each character
    public static void solutionOne() {
        String str = "banana";

        Map<Character, Long> res = 
        str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("::Solution-1 :: "+ res);
    }

    //2. Find the first non-repeating character
    public static void solutionTwo() {
        String str = "swiss";

        char res = 
        str.chars()
        .mapToObj(c -> (char) c)
        .filter(s -> str.indexOf(s) == str.lastIndexOf(s))
        .findFirst()
        .orElseThrow(null);
        
        System.out.println("::Solution-2 :: "+ res);
    }


}