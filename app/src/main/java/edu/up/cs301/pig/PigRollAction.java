package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;

public class PigRollAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PigRollAction(GamePlayer player) {
        super(player);
    }
}
