package com.db.signaltrade.action;

import com.othercompany.lib.Algo;

/**
 * Default signal action that cancels trades.
 * */
public class DefaultSignalAction implements SignalAction {
    @Override
    public void perform(Algo algo) {
        algo.cancelTrades();
    }
}
