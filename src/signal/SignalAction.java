package signal;

import com.othercompany.lib.Algo;

@FunctionalInterface
public interface SignalAction {
    /**
     * Performs action on the specified algo.
     */
    void perform(Algo algo);
}
