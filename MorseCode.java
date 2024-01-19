import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class MorseCode {

    private static Map<Character, String> charToMorseMap = new HashMap<>();
    private static Map<String, Character> morseToCharMap = new HashMap<>();
        static {
            // Inicializando o mapa de caracteres para Morse
            charToMorseMap.put('A', ".-");
            charToMorseMap.put('B', "-...");
            charToMorseMap.put('C', "-.-.");
            charToMorseMap.put('D', "-..");
            charToMorseMap.put('E', ".");
            charToMorseMap.put('F', "..-.");
            charToMorseMap.put('G', "--.");
            charToMorseMap.put('H', "....");
            charToMorseMap.put('I', "..");
            charToMorseMap.put('J', ".---");
            charToMorseMap.put('K', "-.-");
            charToMorseMap.put('L', ".-..");
            charToMorseMap.put('M', "--");
            charToMorseMap.put('N', "-.");
            charToMorseMap.put('O', "---");
            charToMorseMap.put('P', ".--.");
            charToMorseMap.put('Q', "--.-");
            charToMorseMap.put('R', ".-.");
            charToMorseMap.put('S', "...");
            charToMorseMap.put('T', "-");
            charToMorseMap.put('U', "..-");
            charToMorseMap.put('V', "...-");
            charToMorseMap.put('W', ".--");
            charToMorseMap.put('X', "-..-");
            charToMorseMap.put('Y', "-.--");
            charToMorseMap.put('Z', "--..");
        
            // Números
            charToMorseMap.put('0', "-----");
            charToMorseMap.put('1', ".----");
            charToMorseMap.put('2', "..---");
            charToMorseMap.put('3', "...--");
            charToMorseMap.put('4', "....-");
            charToMorseMap.put('5', ".....");
            charToMorseMap.put('6', "-....");
            charToMorseMap.put('7', "--...");
            charToMorseMap.put('8', "---..");
            charToMorseMap.put('9', "----.");
        
            // Inicializando o mapa de Morse para caracteres
            for (Map.Entry<Character, String> entry : charToMorseMap.entrySet()) {
                morseToCharMap.put(entry.getValue(), entry.getKey());
            }
        }
        
    

    static {
        // Inicializando o mapa de Morse para caracteres
        for (Map.Entry<Character, String> entry : charToMorseMap.entrySet()) {
            morseToCharMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static String toMorse(String input) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            if (charToMorseMap.containsKey(c)) {
                morseCode.append(charToMorseMap.get(c)).append(" ");
            }
        }
        return morseCode.toString();
    }

    public static String fromMorse(String morseCode) {
        StringBuilder text = new StringBuilder();
        for (String morseChar : morseCode.split(" ")) {
            if (morseToCharMap.containsKey(morseChar)) {
                text.append(morseToCharMap.get(morseChar));
            }
        }
        return text.toString();
    }


    public static char getRandomLetter() {
        Random rand = new Random();
        return (char) ('A' + rand.nextInt(26)); // Gera uma letra aleatória de A a Z
    }

    public static String getRandomMorseCode() {
        Random rand = new Random();
        List<String> morseCodes = new ArrayList<>(charToMorseMap.values());
        return morseCodes.get(rand.nextInt(morseCodes.size())); // Retorna um código Morse aleatório
    }

}
