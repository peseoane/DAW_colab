package piedrapapelytijeras;

class gameRule{

    final byte[][] whoWin = {
            {1, 2, 0},
            {0, 1, 2},
            {2, 0, 1}
    };

    final byte[][] whoWinCheat = {
            {2, 0, 1},
            {1, 2, 0},
            {0, 1, 2}
    };

    /**
     * Returns a byte from the matrix,
     * @param playerAction
     * @param pcAction
     * @param godMode
     * @return
     */
    public byte winner (byte playerAction, byte pcAction, boolean godMode) {

        if (godMode) return whoWin[playerAction][pcAction];
        else return whoWinCheat[playerAction][pcAction];
    }

    /**
     * This generates a random true or false to enable the cheat mode for the PC, but only if the player is winning,
     * also this condicition isn't always true and it's random generated (1/2 chance).
     * @param playerScore Byte that reads the player score.
     * @param pcScore Byte that reads the pc score.
     * @return Return the status of the cheat (boolean)
     */
    public boolean godMode(byte playerScore, byte pcScore) {

        if (playerScore > pcScore) return new java.util.Random().nextBoolean();
        else return false;

    }

    public byte pcAction(byte playerAction,boolean godMode){

        byte pcAction = 0;

        switch (playerAction) {
            case 0, 2 -> pcAction = 1;
            case 1 -> pcAction = 2;
        }

        return pcAction;

}

public class RCgamePSR {
    public static void main(String[] args) {

    }
}

