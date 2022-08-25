package exercise5;

public class Exercise5 {

    public static void main(String[] args) {
        String[] my_array = {"First", "SECOND", "tHIrd", "Fourth", "fifth", "SixTh", "SEVENth", "eigTH", "NINETH", "LAST"};
        String result = "";
        
        for (String word : my_array) {
            result = result.concat(word.toLowerCase()).concat(" ");
        }
        System.out.println(result);
    }
    
}
