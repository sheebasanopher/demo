package com.sheeba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VotingMachineTest {
    VotingMachinePojo votingMachinePojo;

    @BeforeEach
    public void setUp() {
        CandidatePojo harryCandidatePojo = new CandidatePojo("harry", "cycle", "BE", OnlySex.MALE, 45, "cycle", 0);
        CandidatePojo nemoCandidatePojo = new CandidatePojo("nemo", "dmk", "12", OnlySex.MALE, 43, "leaf", 0);

        List<CandidatePojo> candidates = new ArrayList<CandidatePojo>();
        candidates.add(harryCandidatePojo);
        candidates.add(nemoCandidatePojo);

        votingMachinePojo = new VotingMachinePojo(candidates);

    }

    @Test
    public void testVoting() {
        votingMachinePojo.voting("nemo");
    }

    @Test
    public void testResult() {
        List<String> output = votingMachinePojo.result();
        assertEquals("harry : 0", output.get(0));
        assertEquals("nemo : 0", output.get(1));

    }

    @Test
    public void testResultWithParameter() {
        List<String> output = votingMachinePojo.result(5678);
        assertEquals("harry : 0", output.get(0));
        assertEquals("nemo : 0", output.get(1));

    }

    @Test
    public void testResultWithIncorrectParameter() {
        List<String> output = votingMachinePojo.result(9075);
        assertNull(output);

    }
}
