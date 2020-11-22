package advanced.optional;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {

        //ex 1 - cream un Optional si ii printam valoarea doar daca exista
        Optional<String> optionalEx = Optional.of("abc");  // creare Optional
        if (optionalEx.isPresent()) {
            String result = optionalEx.get();  //stringul result ia valoarea din Optional
            System.out.println(result);   // si apoi il printam
        }

        //ex 2 cu ofNullable
//        Optional<String> optionalExx = Optional.ofNullable(null);
//        if (optionalEx.isPresent()) {
//            String resultx = optionalExx.get();
//            System.out.println(resultx);
//        }

        //next ex - cu empty
        Optional<String> optionalEx2 = Optional.empty(); // daca vrei sa creezi un optional gol se face asa si nu cu .ofNullable(null)
        System.out.println(optionalEx2.isPresent());     // afiseaza 'false'

        //cu orElse
        Optional<String> optionalEx3 = Optional.ofNullable(null);  //daca pun in paranteza altceva in loc de null va afisa ce pun aici
        String result = optionalEx3.orElse("def");            // daca sus e null, va afisa ce e aici la orElse
        System.out.println(result);

        // cu orElse in continuarea lui .ofNullable
        //cu cast la String (din cauza valorii null)
        String optionalEx4 = (String) Optional.ofNullable(null).orElse("def2"); //Obs. aici optionalEx4 e String NU Optional<String>
        System.out.println(optionalEx4);                                              //Obs2. daca dupa .ofNullable(null) atunci insista sa facem cast la (String)

        // fara cast la String (din cauza valorii "abc")
        String optionalEx5 = Optional.ofNullable("abc").orElse("xyz");   // Obs3. daca dupa .ofNullable este ("abc") si nu null, atunci nu e nevoie de cast la (String)
        System.out.println(optionalEx5);                                       // pt ca recunoaste ca si "abc" e tot String

    }
}
