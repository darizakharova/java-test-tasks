package subsequence;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> pattern = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            list.add(i + 1);
        }
        pattern.add(1);
        pattern.add(5);
        System.out.println(search(list,pattern)); // expect true
        
        ArrayList<String> listS = new ArrayList<>();
        ArrayList<String> patternS = new ArrayList<>();
        
        listS.add("abc");
        listS.add("xyz");
        listS.add("nat");
        listS.add("car");
        listS.add("bar");
        
        patternS.add("xyz");
        patternS.add("nat");
        patternS.add("car");
        patternS.add("bar");
        System.out.println(search(listS,patternS)); // expect true
        
        patternS.add("bar");
        System.out.println(search(listS,patternS)); // expect false
    }
    static boolean search(List list, List pattern) {
        int j = 0;
        for (int i = 0; i < list.size(); ++i){
            if ( list.get(i).equals(pattern.get(j) ) ) {
                if (j == pattern.size() - 1) {
                    return true;
                }
                else { 
                    ++j;
                }
            }
        }
        return false;
    }
}