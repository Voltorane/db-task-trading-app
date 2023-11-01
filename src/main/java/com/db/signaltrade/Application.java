package com.db.signaltrade;

import com.db.signaltrade.action.SignalAction;
import com.db.signaltrade.action.SignalActionFactory;
import com.othercompany.lib.Algo;
import com.othercompany.lib.SignalHandler;

/**
 * This is your team’s code and should be changed as you see fit.
 */
class Application implements SignalHandler {
    private final SignalActionFactory signalActionFactory;
    private final Algo algo;

    Application(SignalActionFactory signalActionFactory, Algo algo) {
        this.signalActionFactory = signalActionFactory;
        this.algo = algo;
    }

    public void handleSignal(int signal) {
        SignalAction action = signalActionFactory.create(signal);
        action.perform(algo);
        algo.doAlgo();
    }
}
