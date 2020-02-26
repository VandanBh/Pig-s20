package edu.up.cs301.pig;

import android.util.Log;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        //if(game instanceof PigGameState){
            Log.i("asdf", "computer received");
            PigGameState p = (PigGameState) info;
            if(playerNum == p.getPlayerId()){
                int chance = (int)(Math.random()*3) +1;
                if(chance >= 3)
                    game.sendAction(new PigHoldAction(this));
                else
                    game.sendAction(new PigRollAction(this));
            }
        //}
    }//receiveInfo

}
