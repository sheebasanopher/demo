package com.sheeba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IndianVotingBoothTest {
    IndianVotingBoothPojo indianVotingBoothPojo;


    @BeforeEach
    public void setUp() {
        VoterPojo ramVoter = new VoterPojo("ram", "in2356", false, 34);
        VoterPojo kavinVoter = new VoterPojo("kavin", "in0660", false, 23);
        VoterPojo peterVoter = new VoterPojo("peter", "in6822", false, 18);
        VoterPojo tomVoter = new VoterPojo("tom", "in7982", false, 12);
        VoterPojo jimmyVoter = new VoterPojo("jimmy", "in1209", true, 34);

        List<VoterPojo> voters = new ArrayList<VoterPojo>();
        voters.add(ramVoter);
        voters.add(kavinVoter);
        voters.add(peterVoter);
        voters.add(tomVoter);
        voters.add(jimmyVoter);

        CandidatePojo kushbooCandidate = new CandidatePojo("Kushboo", "bjp", "12", OnlySex.FEMALE, 55, "lotus", 0);
        CandidatePojo stalinCandidate = new CandidatePojo("stalin", "dmk", "pg", OnlySex.MALE, 67, "sun", 0);
        CandidatePojo gandhiCandidate = new CandidatePojo("gandhi", "congress", "pg", OnlySex.MALE, 76, "indian flag", 0);
        CandidatePojo kamalCandidate = new CandidatePojo("kamal", "mnm", "pg", OnlySex.MALE, 48, "torch", 0);
        CandidatePojo radhaCandidate = new CandidatePojo("radha", "admk", "ug", OnlySex.FEMALE, 35, "leaf", 0);

        List<CandidatePojo> candidates = new ArrayList<CandidatePojo>();
        candidates.add(kushbooCandidate);
        candidates.add(stalinCandidate);
        candidates.add(gandhiCandidate);
        candidates.add(kamalCandidate);
        candidates.add(radhaCandidate);

        VotingMachinePojo votingMachinePojo = new VotingMachinePojo(candidates);

        indianVotingBoothPojo = new IndianVotingBoothPojo(voters, votingMachinePojo);

    }

    @Test
    public void testIsVotingAllowed() {
        boolean output = indianVotingBoothPojo.isVotingAllowed("in6822");
        assertTrue(output);
    }

    @Test
    public void testIsVotingNotAllowed() {
        boolean output = indianVotingBoothPojo.isVotingAllowed("in7982");
        assertFalse(output);
    }

    @Test
    public void testVote() {
        boolean output = indianVotingBoothPojo.vote("in2356", "Kushboo");
        assertTrue(output);
    }

    @Test
    public void testNotVote() {
        boolean output = indianVotingBoothPojo.vote("in7982", "gandhi");
        assertFalse(output);
    }

    @Test
    public void testVoted() {
        List<String> output = indianVotingBoothPojo.voted();
        assertEquals("jimmy", output.get(0));

    }


}
