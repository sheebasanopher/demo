package com.sheeba.app;

import java.util.ArrayList;
import java.util.List;

public abstract class VotingBoothPojo {
    List<VoterPojo> voterPojo;
    VotingMachinePojo votingMachinePojo;

    public VotingBoothPojo(List<VoterPojo> voterPojo, VotingMachinePojo votingMachinePojo) {
        this.voterPojo = voterPojo;
        this.votingMachinePojo = votingMachinePojo;
    }

    public List<VoterPojo> getVoterPojo() {
        return voterPojo;
    }

    public VotingMachinePojo getVotingMachinePojo() {
        return votingMachinePojo;
    }

    public abstract boolean isVotingAllowed(String id);

    public boolean vote(String id, String candidateName) {
        if (isVotingAllowed(id)) {
            votingMachinePojo.voting(candidateName);
            for (VoterPojo voter : voterPojo) {
                String voterID = voter.getId();
                if (id.equals(voterID)) {
                    voter.setAlreadyVoted(true);
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public List<String> voted() {
        List<String> voters = new ArrayList<String>();
        for (VoterPojo vote : voterPojo) {
            String name = vote.getName();
            boolean voter = vote.isAlreadyVoted();
            if (voter) {
                voters.add(name);
            }

        }
        return voters;
    }


}
