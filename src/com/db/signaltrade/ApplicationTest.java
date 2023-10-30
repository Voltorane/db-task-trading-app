package com.db.signaltrade;

import com.othercompany.lib.Algo;
import com.othercompany.lib.SignalHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {
    // Legacy application that should be replaced by the new application.
    private static class LegacyApplication implements SignalHandler {
        public static int signalsImplemented = 3;

        public void handleSignal(int signal) {
            Algo algo = new Algo();
            switch (signal) {
                case 1 -> {
                    algo.setUp();
                    algo.setAlgoParam(1, 60);
                    algo.performCalc();
                    algo.submitToMarket();
                }
                case 2 -> {
                    algo.reverse();
                    algo.setAlgoParam(1, 80);
                    algo.submitToMarket();
                }
                case 3 -> {
                    algo.setAlgoParam(1, 90);
                    algo.setAlgoParam(2, 15);
                    algo.performCalc();
                    algo.submitToMarket();
                }
                default -> algo.cancelTrades();
            }
            algo.doAlgo();
        }
    }

    // Test covers only signals from the legacy application.
    @Test
    void testCompareWithLegacy() {
        SignalHandler application = new Application();
        SignalHandler legacyApplication = new LegacyApplication();

        // initialize two buffers that will read the output of both applications
        ByteArrayOutputStream appBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(appBuffer));

        for (int i = 0; i < LegacyApplication.signalsImplemented; i++) {
            application.handleSignal(i);
        }

        ByteArrayOutputStream legacyBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(legacyBuffer));
        for (int i = 0; i < LegacyApplication.signalsImplemented; i++) {
            legacyApplication.handleSignal(i);
        }

        // compare the output of the two applications
        assertEquals(legacyBuffer.toString(), appBuffer.toString());
    }
}