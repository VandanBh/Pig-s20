package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class PigGameState extends GameState {
    private int id;
    private int scoreP0;
    private int scoreP1;
    private int runningTotal;
    private int currentVal;
    public PigGameState() {
        id = 0;
        scoreP0 = 0;
        scoreP1 = 0;
        runningTotal = 0;
        currentVal = 0;
    }
    public PigGameState(PigGameState p){
        id = p.id;
        scoreP0 = p.scoreP0;
        scoreP1 = p.scoreP1;
        runningTotal = p.runningTotal;
        currentVal = p.currentVal;
    }
    public int getPlayerId(){
        return id;
    }
    public int getScoreP0(){
        return scoreP0;
    }
    public int getScoreP1(){
        return scoreP1;
    }
    public int getRunningTotal(){
        return runningTotal;
    }
    public int getCurrentVal(){
        return currentVal;
    }
    public void setPlayerId(int i){
        id = i;
    }
    public void setScoreP0(int score){
        scoreP0 = score;
    }
    public void setScoreP1(int score){
        scoreP1 = score;
    }
    public void setRunningTotal(int total){
        runningTotal = total;
    }
    public void setCurrentVal(int c){
        currentVal = c;
    }
}
