package com.db.signaltrade;

import com.db.signaltrade.action.SignalAction;
import com.db.signaltrade.action.SignalActionFactory;
import com.db.signaltrade.action.SignalActionFactoryImpl;
import com.othercompany.lib.Algo;
import com.othercompany.lib.SignalHandler;

/**
 * This is your team’s code and should be changed as you see fit.
 */
class Application implements SignalHandler {
    private final SignalActionFactory signalActionFactory = new SignalActionFactoryImpl();

    public void handleSignal(int signal) {
        Algo algo = new Algo();
        SignalAction action = signalActionFactory.create(signal);
        action.perform(algo);
        algo.doAlgo();
    }
}
