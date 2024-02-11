import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Map<Character, String> textToMorse = new HashMap<>();
    private static final Map<String, Character> morseToText = new HashMap<>();

    static {
        // Initialize Text to Morse Code mappings
        textToMorse.put('A', ".-");
        textToMorse.put('B', "-...");
        textToMorse.put('C', "-.-.");
        textToMorse.put('D', "-..");
        textToMorse.put('E', ".");
        textToMorse.put('F', "..-.");
        textToMorse.put('G', "--.");
        textToMorse.put('H', "....");
        textToMorse.put('I', "..");
        textToMorse.put('J', ".---");
        textToMorse.put('K', "-.-");
        textToMorse.put('L', ".-..");
        textToMorse.put('M', "--");
        textToMorse.put('N', "-.");
        textToMorse.put('O', "---");
        textToMorse.put('P', ".--.");
        textToMorse.put('Q', "--.-");
        textToMorse.put('R', ".-.");
        textToMorse.put('S', "...");
        textToMorse.put('T', "-");
        textToMorse.put('U', "..-");
        textToMorse.put('V', "...-");
        textToMorse.put('W', ".--");
        textToMorse.put('X', "-..-");
        textToMorse.put('Y', "-.--");
        textToMorse.put('Z', "--..");
        textToMorse.put('0', "-----");
        textToMorse.put('1', ".----");
        textToMorse.put('2', "..---");
        textToMorse.put('3', "...--");
        textToMorse.put('4', "....-");
        textToMorse.put('5', ".....");
        textToMorse.put('6', "-....");
        textToMorse.put('7', "--...");
        textToMorse.put('8', "---..");
        textToMorse.put('9', "----.");

        // Initialize Morse Code to Text mappings
        for (Map.Entry<Character, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }

    public static String toMorseCode(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char character : text.toUpperCase().toCharArray()) {
            if (textToMorse.containsKey(character)) {
                morseCode.append(textToMorse.get(character)).append(" ");
            } else if (character == ' ') {
                morseCode.append("  "); // Separate words with double spaces
            }
        }
        return morseCode.toString();
    }

    public static String fromMorseCode(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split("  "); // Split words by double spaces
        for (String word : words) {
            for (String morseCharacter : word.split(" ")) {
                if (morseToText.containsKey(morseCharacter)) {
                    text.append(morseToText.get(morseCharacter));
                }
            }
            text.append(" "); // Add space between words
        }
        return text.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose Option:\n1. Morse to text\n2. Text to Morse");
        System.out.print("input: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after option input
        System.out.println();
        switch (option) {
        
            case 1:
                System.out.print("Enter Morse Code: ");
                String msc = scanner.nextLine();
                System.out.println("Text: " + fromMorseCode(msc));
                break;

            case 2:
                System.out.print("Enter Text: ");
                String text = scanner.nextLine();
                System.out.println("Morse Code: " + toMorseCode(text));
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}
