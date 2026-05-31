/*
 * Decompiled with CFR 0.152.
 */
package age.of.civilizations2.jakowski.lukasz.TurnThreads;

import age.of.civilizations2.jakowski.lukasz.Actions;
import age.of.civilizations2.jakowski.lukasz.CFG;

public class Turn_ThreadActions
extends Thread {
    private boolean running = true;
    private boolean processTurn = false;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Turn_ThreadActions turn_ThreadActions = this;
                synchronized (turn_ThreadActions) {
                    try {
                        while (!this.processTurn && this.running) {
                            this.wait();
                        }
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (!this.running) continue;
                this.performTurnLogic();
                this.processTurn = false;
            }
            catch (Exception ex) {
                CFG.exceptionStack(ex);
            }
        }
    }

    private void performTurnLogic() {
        try {
            Actions.doActions();
        }
        catch (Exception ex) {
            CFG.exceptionStack(ex);
        }
        finally {
            this.processTurn = false;
        }
    }

    public synchronized void triggerTurn() {
        this.processTurn = true;
        this.notify();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stopWorker() {
        this.running = false;
        Turn_ThreadActions turn_ThreadActions = this;
        synchronized (turn_ThreadActions) {
            this.notify();
        }
    }
}

