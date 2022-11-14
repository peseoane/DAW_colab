package piedrapapelytijeras;

/**
 * Esta clase almacena caracteres de escape y textos como constantes, se almacenan aquí porque si no
 * Java ya es un lenguaje muy boilerplate y queda totalmente ilegible.
 * A ver si Kotlin gana cuota de mercado.
 */
abstract class TerminalAux {
    public static final String ENCODING = "ISO-8859-1";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String DIALOG = """
            
            ### ROCK PAPER SCISSORS! ###
            It's your turn, what do you choose?
            0 - Rock.
            1 - Paper.
            2 - Scissors.
            """;

    public static final String NEW_GAME = "### NEW GANE ###";
    public static final String HI = "Hi ";
    public static final String ASK_NEXT_ROUND = "Play again? N to exit, press any key to continue";
    public static final String EXIT_GAME = "### EXITING GAME ###";

    public static final String KEY_TO_EXIT = "n";

    // Los elementos a continuación son un huevo de pascua, no voy a comentarlos.

    public static final String EASTER_EGG0 = secret0("6D61727461");
    public static final String EASTER_EGG1 = secret0("486F6C612070726F666521");

    private static String secret0(String secret1) {
        StringBuilder secret3 = new StringBuilder();

        for (int i = 0; i < secret1.length(); i += 2) {
            String secret2 = secret1.substring(i, i + 2);
            secret3.append((char) Integer.parseInt(secret2, 16));
        }

        return secret3.toString();
    }
}
