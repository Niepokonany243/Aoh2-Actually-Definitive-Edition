
package age.of.civilizations2.jakowski.lukasz.TurnThreads;

import age.of.civilizations2.jakowski.lukasz.CFG;
import age.of.civilizations2.jakowski.lukasz.NewTurn;

public class Turn_ThreadNewTurn
extends Thread {
    private boolean running = true;
    private boolean processTurn = false;

    
    @Override
    public void run() {
        if (CFG.isAndroid()) {
            try {
                Thread.currentThread().setPriority(Thread.NORM_PRIORITY - 2);
            }
            catch (Exception ex) {
            }
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Turn_ThreadNewTurn turn_ThreadNewTurn = this;
                synchronized (turn_ThreadNewTurn) {
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
            NewTurn.doAction();
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

    public final boolean getProcessTurn() {
        return this.processTurn;
    }

    
    public void stopWorker() {
        this.running = false;
        Turn_ThreadNewTurn turn_ThreadNewTurn = this;
        synchronized (turn_ThreadNewTurn) {
            this.notify();
        }
    }
}

