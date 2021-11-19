package com.sheeba.app;

import java.util.List;
import java.util.stream.Stream;

public class AmericanVotingBoothPojo extends VotingBoothPojo {

    public AmericanVotingBoothPojo(List<VoterPojo> voterPojo, VotingMachinePojo votingMachinePojo) {
        super(voterPojo, votingMachinePojo);
    }

    @Override
    public boolean isVotingAllowed(String id) {
        for (VoterPojo voter : voterPojo) {
            String voterID = voter.getId();
            boolean alreadyVote = voter.isAlreadyVoted();
            int age = voter.getAge();
            if (voterID.equals(id) && (!alreadyVote) && (age >= 21)) {
                return true;
            }
        }
        return false;
    }




}
