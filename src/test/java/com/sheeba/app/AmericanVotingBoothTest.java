package com.sheeba.app;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AmericanVotingBoothTest {

    AmericanVotingBoothPojo americanVotingBoothPojo;

    @BeforeAll
    public static void start(){
        System.out.println("start test");
    }

    @BeforeEach
    public void setUp() {
        VoterPojo jonnyVoter = new VoterPojo("jonny", "am6898", false, 68);
        VoterPojo mibVoter = new VoterPojo("mib", "am4980", false, 18);

        List<VoterPojo> voters = new ArrayList<VoterPojo>();
        voters.add(jonnyVoter);
        voters.add(mibVoter);

        CandidatePojo mandalaCandidate = new CandidatePojo("mandala", "union", "12", OnlySex.MALE, 56, "tree", 0);
        CandidatePojo obamaCandidate = new CandidatePojo("obama", "fft", "pg", OnlySex.MALE, 45, "cap", 0);

        List<CandidatePojo> candidates = new ArrayList<CandidatePojo>();
        candidates.add(mandalaCandidate);
        candidates.add(obamaCandidate);

        VotingMachinePojo votingMachinePojo = new VotingMachinePojo(candidates);

        americanVotingBoothPojo = new AmericanVotingBoothPojo(voters, votingMachinePojo);

    }

    @Test
    @DisplayName("voting is allowed")
    public void testIsVotingAllowed() {
        boolean output = americanVotingBoothPojo.isVotingAllowed("am6898");
        assertTrue(output);
    }

    @Disabled("not proper")
    @Test
    @DisplayName("voting is not allowed")
    public void testIsVotingNotAllowed() {
        boolean output = americanVotingBoothPojo.isVotingAllowed("am4980");
        assertFalse(output);
    }

    @Test
    @Tag("development")
    public void testVote() {
        boolean output = americanVotingBoothPojo.vote("am6898", "obama");
        assertTrue(output);
    }

    @Test
    public void testNotVote() {
        boolean output = americanVotingBoothPojo.vote("mib", "mandala");
        assertFalse(output);

    }

    @Test
    public void testVoted() {
        List<String> output = americanVotingBoothPojo.voted();
        assertEquals(0, output.size());
    }

    @AfterEach
    public void cleanEach() {
        System.out.println("clean each test");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("all the  test over");
    }
}



