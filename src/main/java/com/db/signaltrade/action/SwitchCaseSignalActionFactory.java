package com.db.signaltrade.action;

/**
 * Implementation of SignalFactory that use switch casing on action creation.
 * Involves no startup overhead, however creating each new [SignalAction] is O(n) complex
 * w. n - amount of registered signals
 */
public class SwitchCaseSignalActionFactory implements SignalActionFactory {
    @Override
    public SignalAction create(int value) {

        return switch (value) {
            case 1 -> (algo) -> {
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
            };
            case 2 -> (algo) -> {
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
            };
            case 3 -> (algo) -> {
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
            };
            default -> new DefaultSignalAction();
        };
    }
}
