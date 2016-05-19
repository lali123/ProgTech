package hu.unideb.inf.lali123.model;

import java.util.Random;

/**
 * Determines the heuristic of the board with a supported player.
 * 
 * @author Lajos
 *
 */
public class Heuristic {

    /**
     * Weights for the heuristic function
     */
    private int[] Weights = new int[] { 1, 5, 100, 10000, 2, 6, 200, 15000 };

    /**
     * Return line value score.
     * 
     * @param vals
     *            Line values.
     * @param player
     *            Supported player.
     * @return Line score.
     */
    private int CheckLine(int[] vals, int player) {
        int score = 0;
        for (int i = 0; i < (vals.length - 3); i++) {
            // Examine each opportunity
            int c = 0;
            int p = 0;
            for (int j = 0; j < 4; j++)
                if (vals[i + j] == player)
                    c++; // TODO Make sure that it looks at it's own identity
                else if (vals[i + j] != 0)
                    p++;
            if ((c > 0) && (p == 0)) {
                // Computer opportunity
                if (c == 4)
                    return Weights[3]; // Win
                score += ((c / 3) * Weights[2]) + ((c / 2) * Weights[1])
                        + Weights[0];
            } else if ((c == 0) && (p > 0)) {
                // Player opportunity
                if (p == 4)
                    return -1 * Weights[7]; // Win
                score -= ((p / 3) * Weights[6]) + ((p / 2) * Weights[5])
                        + Weights[4];
            }
        }
        return score;
    }

    /**
     * Determines a score for the state.
     * 
     * @param state
     *            Current state of the board.
     * @param player
     *            Supported player.
     * @return
     */
    public int heuristic(int[][] state, int player) {
        int score = 0;
        // Eval Horizontal
        for (int i = 0; i < 6; i++) {
            score += CheckLine(new int[] { state[0][i], state[1][i],
                    state[2][i], state[3][i], state[4][i], state[5][i],
                    state[6][i] }, player);
        }

        // Eval Vertical
        for (int i = 0; i < 7; i++) {
            score += CheckLine(new int[] { state[i][0], state[i][1],
                    state[i][2], state[i][3], state[i][4], state[i][5] },
                    player);
        }

        // Eval Diagonal
        score += CheckLine(new int[] { state[0][2], state[1][3], state[2][4],
                state[3][5] }, player);
        score += CheckLine(new int[] { state[0][1], state[1][2], state[2][3],
                state[3][4], state[4][5] }, player);
        score += CheckLine(new int[] { state[0][0], state[1][1], state[2][2],
                state[3][3], state[4][4], state[5][5] }, player);
        score += CheckLine(new int[] { state[1][0], state[2][1], state[3][2],
                state[4][3], state[5][4], state[6][5] }, player);
        score += CheckLine(new int[] { state[2][0], state[3][1], state[4][2],
                state[5][3], state[6][4] }, player);
        score += CheckLine(new int[] { state[3][0], state[4][1], state[5][2],
                state[6][3] }, player);

        // Eval Diagonal 2
        score += CheckLine(new int[] { state[3][0], state[2][1], state[1][2],
                state[0][3] }, player);
        score += CheckLine(new int[] { state[4][0], state[3][1], state[2][2],
                state[1][3], state[0][4] }, player);
        score += CheckLine(new int[] { state[5][0], state[4][1], state[3][2],
                state[2][3], state[1][4], state[0][5] }, player);
        score += CheckLine(new int[] { state[6][0], state[5][1], state[4][2],
                state[3][3], state[2][4], state[1][5] }, player);
        score += CheckLine(new int[] { state[6][1], state[5][2], state[4][3],
                state[3][4], state[2][5] }, player);
        score += CheckLine(new int[] { state[6][2], state[5][3], state[4][4],
                state[3][5] }, player);
        return score;
    }

    
    /**
     * Random heuristic.
     * 
     * @return Random number.
     */
    public int randomHeuristic() {
        Random random = new Random();
        return random.nextInt(7);
    }

}
