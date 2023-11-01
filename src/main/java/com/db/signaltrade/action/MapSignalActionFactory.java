package com.db.signaltrade.action;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a [SignalActionFactory] that utilizes the HashMap to store signals with their
 * respective actions. However, it creates an overhead on the startup to register all the signals -
 * during runtime, all signal creations happen in O(1) time.
 * */
public class MapSignalActionFactory implements SignalActionFactory {
    private final Map<Integer, SignalAction> map;

    public MapSignalActionFactory() {
        this.map = new HashMap<>();
        registerAllActions();
    }

    @Override
    public SignalAction create(int value) {
        return map.getOrDefault(value, new DefaultSignalAction());
    }

    /**
     * Initializes the signal action map.
     * All signal actions are registered here.
     * */
    private void registerAllActions() {
        registerAction(1, (algo) -> {
            algo.setUp();
            algo.setAlgoParam(1, 60);
            algo.performCalc();
            algo.submitToMarket();
        });
        registerAction(2, (algo) -> {
            algo.reverse();
            algo.setAlgoParam(1, 80);
            algo.submitToMarket();
        });
        registerAction(3, (algo) -> {
            algo.setAlgoParam(1, 90);
            algo.setAlgoParam(2, 15);
            algo.performCalc();
            algo.submitToMarket();
        });
    }

    private void registerAction(int signal, SignalAction action) {
        if (map.containsKey(signal)) {
            throw new IllegalArgumentException("Signal already registered - " + signal);
        }
        map.put(signal, action);
    }
}
