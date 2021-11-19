package com.sheeba.app;

import java.util.List;

public class IndianVotingBoothPojo extends VotingBoothPojo {

    public IndianVotingBoothPojo(List<VoterPojo> voterPojo, VotingMachinePojo votingMachinePojo) {
        super(voterPojo, votingMachinePojo);
    }

    @Override
    public boolean isVotingAllowed(String id) {
        for (VoterPojo voter : voterPojo) {
            String voterID = voter.getId();
            boolean alreadyVote = voter.isAlreadyVoted();
            int age = voter.getAge();
            if (voterID.equals(id) && (!alreadyVote) && (age >= 18)) {
                return true;
            }
        }
        return false;
    }


}
