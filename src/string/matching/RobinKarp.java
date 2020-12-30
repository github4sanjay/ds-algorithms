package string.matching;

/**
 * Like the brute force Algorithm, Rabin-Karp algorithm also slides the pattern one by one.
 * But unlike the Naive algorithm, Rabin Karp algorithm matches the hash value of the pattern with the hash value of current substring of text,
 * and if the hash values match then only it starts matching individual characters.
 *
 * So Rabin Karp algorithm needs to calculate hash values for following strings.
 * 1) Pattern itself.
 * 2) All the substrings of the text of length m.
 */
public class RobinKarp {

    public static void main(String[] args) {
        System.out.println(find("ccaccaaedba", "dba")); // true
        System.out.println(find("bacbabababacaca", "ababaca")); // true
        System.out.println(find("abcbcfgm", "bcfm")); // false
    }

    /**
     * Consider word "ccaccaaedba" and pattern "dba"
     * For simplicity we take hash value as follows
     *    _________________________________________
     *   | a | b | c | d | e | f | g | h | i | j  |
     *   | _ | _ | _ | _ | _ | _ | _ | _ | _ | ___|
     *   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
     *   | _ | _ | _ | _ | _ | _ | _ | _ | _ | ___|
     *
     *   so hash value for pattern "dba" is 4+2+1 = 7
     *   Now start comparing each window check hash matches with pattern hash
     *   c c a c c a a e d b a
     *   |___|
     *   3+3+1 = 7 == 7 here has are equal check string if not matches slide next else found
     *
     *   To calculate next hash efficiently subtract previous and add next
     *   c c a c c a a e d b a
     *     |___|
     *     7-3+3 = 7 == 7 here has are equal check string if not matches slide next else found
     *
     *   c c a c c a a e d b a
     *       |___|
     *       7-3+3 = 7 == 7 here has are equal check string if not matches slide next else found
     *
     *   c c a c c a a e d b a
     *         |___|
     *         7-1+1 = 7 == 7 here has are equal check string if not matches slide next else found
     *
     *   c c a c c a a e d b a
     *           |___|
     *           7-3+1 = 5 != 7 so slide next
     *
     *   c c a c c a a e d b a
     *             |___|
     *             5-3+5 = 7 == 7 here has are equal check string if not matches slide next else found
     *
     *
     *
     * When hash matches and string don't we call it spurious hits.
     * To avoid these hash collision Robin karp suggested this technique :-
     * 
     *        d   b   a      here m = 3
     *      p[1]*10^m-1 + p[2]*10^m-2 +  p[3]*10^m-3
     *      4*100 + 2*10 + 1*1 = 421
     *
     *     here we take base 10 as only 10 alphabets are considered
     *
     */
    public static boolean find(String word, String pattern) {
        int base = 10;
        int patternHash = hashFunction(pattern.toCharArray(), base);
        var firstWindow = new char[pattern.length()];
        for (int i=0; i<pattern.length(); i++){
            firstWindow[i] = word.charAt(i);
        }
        int wordWindowHash = hashFunction(firstWindow, base);
        for (int i=pattern.length()-1; i<word.length(); i++){
            if (patternHash == wordWindowHash){
                var found = true;
                for (int j=i-pattern.length()+1, k=0; j<=i; j++, k++){
                    if (pattern.charAt(k) != word.charAt(j)){
                        found = false;
                        break;
                    }
                }
                if (found){
                    return true;
                }
            }
            if (i+1 < word.length()){
                wordWindowHash = rollingHash(wordWindowHash, word, pattern.length(), i, base);
            }
        }
        return false;
    }

    private static int rollingHash(int wordWindowHash, String word, int windowSize, int index, int base) {
        // subtract hash contributed by previous char
        wordWindowHash = wordWindowHash - (word.charAt(index-windowSize+1))*(int)Math.pow(base, windowSize-1);

        // multiply base to other char
        wordWindowHash = wordWindowHash * base;

        // add hash of next char
        wordWindowHash = wordWindowHash + word.charAt(index+1);
        return wordWindowHash;
    }


    // character hash is taken as its ascii
    private static int hashFunction(char[] str, int base){
        int sum = 0;
        for (int i=0; i<str.length; i++){
            sum = sum + (str[i])*(int)Math.pow(base, str.length-i-1);;
        }
        return sum;
     }
}
