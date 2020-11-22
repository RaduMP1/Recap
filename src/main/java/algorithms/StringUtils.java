package algorithms;

public class StringUtils {

//    public boolean areAnagramStrings(String s1, String s2){
        //s1 = "mare"
        //s2 = "rame"


        // todo: 1) implement using 2 iterations using for
        // 1. compare length
        // 2. compare strings using 2 fors
        // todo: 2) implement using 2 frequency arrays
        // todo: 3) implement using 1 frequency array
        // using ascii code for frequency array
//    }

    public boolean areCircularPermutedStrings(String s1, String s2){
        //s1 = "mare"
        //s2 = "rema"
        // todo: 1) for or frequency array
        // todo: 2) using only String methods(e.g. contains, substring, etc)
        if (s1.length() != s2.length()){
            return false;
        }
        s2 += s2;
        return s2.contains(s1);
    }
}
