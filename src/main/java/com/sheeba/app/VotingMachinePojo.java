package com.sheeba.app;

import java.util.ArrayList;
import java.util.List;

public class VotingMachinePojo {
    private List<CandidatePojo> candidatePojo;

    public VotingMachinePojo(List<CandidatePojo> candidatePojo) {
        this.candidatePojo = candidatePojo;
    }

    public List<CandidatePojo> getCandidatePojo() {
        return candidatePojo;
    }

    public void voting(String name) {
        for (CandidatePojo canPojo : candidatePojo) {
            String candidateName = canPojo.getName();
            int candidateVote = canPojo.getVote();
            if (candidateName.equals(name)) {
                int vote = 0;
                vote = candidateVote + 1;
                canPojo.setVote(vote);
                break;
            }
        }

    }

    public List<String> result() {
        List<String> totalVote = new ArrayList<String>();
        for (CandidatePojo canPojo : candidatePojo) {
            int vote = canPojo.getVote();
            String name = canPojo.getName();
            totalVote.add(name + " : " + vote);
        }
        return totalVote;
    }

    //method overLoading
    public List<String> result(int pin) {
        List<String> results = new ArrayList<String>();
        for (CandidatePojo canPojo : candidatePojo) {
            String name = canPojo.getName();
            int vote = canPojo.getVote();
            if (pin == 5678) {
                results.add(name + " : " + vote);
            } else {
                return null;
            }
        }
        return results;
    }

}
