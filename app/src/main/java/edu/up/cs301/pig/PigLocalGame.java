package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pGS;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        pGS = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == pGS.getPlayerId())
            return true;
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction){
            if(pGS.getPlayerId() == 0){
                pGS.setScoreP0(pGS.getScoreP0() + pGS.getRunningTotal());
                pGS.setRunningTotal(0);
                if(players.length > 1){
                    pGS.setPlayerId(1);
                }
                return true;
            } else if(pGS.getPlayerId() == 1){
                pGS.setScoreP1(pGS.getScoreP1() + pGS.getRunningTotal());
                pGS.setRunningTotal(0);
                if(players.length>1){
                    pGS.setPlayerId(0);
                }
                return true;
            }
            return false;
        } else if (action instanceof PigRollAction) {
            int dieValue = (int)(Math.random()*5) + 1;
            if(dieValue > 1){
                pGS.setRunningTotal(pGS.getRunningTotal() + dieValue);
                pGS.setCurrentVal(dieValue);
            } else {
                pGS.setRunningTotal(0);
                if(players.length > 1){
                    if(pGS.getPlayerId() == 0){
                        pGS.setPlayerId(1);
                    } else if(pGS.getPlayerId() == 1){
                        pGS.setPlayerId(0);
                    } else {
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState pCopy = pGS;
        p.sendInfo(pCopy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(pGS.getScoreP0() >= 50){
            return "Player 0 WON! Score: " + pGS.getScoreP0() + " ";
        } else if(pGS.getScoreP1() >= 50){
            return "Player 1 WON! Score: " + pGS.getScoreP1() + " ";
        }
        return null;
    }

}// class PigLocalGame
