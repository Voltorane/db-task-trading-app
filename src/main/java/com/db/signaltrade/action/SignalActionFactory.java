package com.db.signaltrade.action;

public interface SignalActionFactory {
    /**
     * Creates a [SignalAction] based on the specified value.
     * @param value the value of a signal to create a [SignalAction] for.
     * @return [SignalAction] for a provided signal value
     * */
    SignalAction create(int value);
}
