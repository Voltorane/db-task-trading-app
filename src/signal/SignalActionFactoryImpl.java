package signal;

/**
 * Implementation of SignalFactory.
 */
public class SignalActionFactoryImpl implements SignalActionFactory {
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
