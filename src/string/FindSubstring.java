package string;

import java.util.ArrayList;
import java.util.List;

public class FindSubstring {

    public static void main(String[] args) {
        System.out.println(FindSubstring.find("abcd"));
    }

    public static List<String> find(String str) {
        var list = new ArrayList<String>();
        for (int i=1; i <= str.length();i++){ // i is length of substring
            for (int j=0; j+i <= str.length();j++){
                list.add(str.substring(j, j+i));
            }
        }
        return list;
    }
}
