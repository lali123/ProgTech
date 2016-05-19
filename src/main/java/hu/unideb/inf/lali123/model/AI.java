package hu.unideb.inf.lali123.model;

/**
 * @author Lajos
 *
 */
public class AI {
    private Heuristic heuristic;
    private int supportedPlayer;

    /**
     * 
     */
    public AI() {
        heuristic = new Heuristic();
        supportedPlayer = 2;
    }

    /**
     * @param board
     * @param player
     * @return
     */
    public int getAIMove(Board board, int player) {
        return minimaxStep(board, 5, heuristic, player);
    }

    /**
     * @param state
     * @param limit
     * @param heur
     * @param turn
     * @return
     */
    private int minimaxStep(Board state, int limit, Heuristic heur, int turn) {
        int max = Integer.MIN_VALUE;
        int operator = 0;
        int v = 0;
        for (int o = 0; o < 7; o++) {
            if (state.applicable(o)) {
                state.takeDisk(o, 2);
                v = minimaxValue(state, limit - 1, heur, turn == 1 ? 2 : 1);
                if (v > max) {
                    max = v;
                    operator = o;
                }
                state.undoMove(o);
            }
        }
        return operator;
    }

    /**
     * @param state
     * @param limit
     * @param heur
     * @param turn
     * @return
     */
    private int minimaxValue(Board state, int limit, Heuristic heur, int turn) {
        if (state.isEndGame() || limit == 0) {
            if (Options.getInstance().isEasyGame()) {
                return heur.randomHeuristic();
            }else {
                return heur.heuristic(state.getTable(), 2);                
            }
        } else if (turn == supportedPlayer) {
            int max = Integer.MIN_VALUE;
            int v = 0;
            for (int o = 0; o < 7; o++) {
                if (state.applicable(o)) {
                    state.takeDisk(o, 2);
                    v = minimaxValue(state, limit - 1, heur, turn == 1 ? 2 : 1);
                    
                    max = Math.max(v, max);
                    
                    state.undoMove(o);
                }
            }
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            int v = 0;
            for (int o = 0; o < 7; o++) {
                if (state.applicable(o)) {
                    state.takeDisk(o, 1);
                    ;
                    v = minimaxValue(state, limit - 1, heur, turn == 1 ? 2 : 1);
                    
                    min = Math.min(v, min);
                    
                    state.undoMove(o);
                }
            }
            return min;
        }
    }
}
