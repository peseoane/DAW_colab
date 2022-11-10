package piedrapapelytijeras;

class GameOLD {

    /**
     * Returns a byte from the matrix, paper
     * @param playerAction loads the byte for the row value [0:paper,1:scissors,2:rock]
     * @param pcAction loads the byte for the column value
     *      *                 [0:paper,1:scissors,2:rock]
     * @return a byte with a byte, 0: wins the PC, 1: DRAW and 2: wins the player
     */
    public byte winner(byte playerAction,byte pcAction)  {
        final byte[][] whoWin = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        return whoWin[playerAction][pcAction];
    }

    /**
     * This generates a random true or false to enable the cheat mode for the PC,
     * but only if the player is winning,
     * also this condicition isn't always true and it's random generated (1/2
     * chance).
     *
     * @param playerScore Byte that reads the player score.
     * @param pcScore     Byte that reads the pc score.
     * @return Return the status of the cheat (boolean)
     */
    

    /**
     * If godMode is true, this will output a action that always will win
     * @param playerAction
     * @param godMode
     * @return
     */
    private byte pcAction(byte playerAction, boolean godMode) {

        byte pcAction = 0;

        if (godMode) {
            switch (playerAction) {
                case 0, 2 -> pcAction = 1;
                case 1 -> pcAction = 2;
            }
        }
        else pcAction = (byte) (new java.util.Random().nextInt(3));
        return  pcAction;
    }
}