package piedrapapelytijeras;

public class Colour {
    // caracteres de escape, en terminales modernas al mostrar esas cadenas al principal de cada texto, cambian el color, el reset lo reinicia al default del terminal, y dejo el menú aquí para no emborronar.
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

    // qué será
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
