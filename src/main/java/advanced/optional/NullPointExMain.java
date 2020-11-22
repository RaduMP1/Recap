package advanced.optional;

import java.util.Optional;


//                             EXEMPLU CUM SE EVITA (TRATEAZA) NULLPOINTEREXCEPTION


public class NullPointExMain {

    public static final String ABC = "abc";

    public static void main(String[] args) {
        String example1 = null;
        System.out.println(isAbc(example1)); // apel pt versiunea 1 - fara Optional
        System.out.println(isAbc2(Optional.ofNullable(example1))); //apel pt versiunea 2 - cu Optional / Obs. daca pui .of in loc de .ofNullable o sa crape cu NullPointerException
    }

    // varianta 1 - fara Optional
    public static boolean isAbc(String s){
        if (s != null) {          // linie adaugata ulterior / in varianta asta pot sa rulez si cu linie 14 si NU va da NullPointerException
//        return s.equals(ABC);   // in genul asta e cea mai frecventa problema din java: incerci sa apelezi equals pe o instanta nula (una din cele 2 valori e nula)
            return ABC.equals(s);    // daca inversez ordinea si am in stanga lui equals stringul care NU e null, atunci nu voi mai primi NullPointerException
        }
        return false;
    }

    // varianta 2 - cu Optional
    public static boolean isAbc2(Optional<String> s){
        if (s.isPresent()){
            return s.get().equals(ABC);
        }
        return false;
    }
}
