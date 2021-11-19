package com.sheeba.app;

public class CandidatePojo {
    private String name;
    private String party;
    private String education;
    private OnlySex gender;
    private int age;
    private String symbol;
    private int vote;

    public CandidatePojo(String name, String party,  String education, OnlySex gender,
                         int age,String symbol,int vote) {
        this.name = name;
        this.party = party;
        this.education = education;
        this.gender = gender;
        this.age = age;
        this.symbol=symbol;
        this.vote=vote;

    }
    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public String getEducation() {
        return education;
    }

    public OnlySex getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSymbol(){
        return symbol;

    }
    public int getVote(){
        return vote;
    }

    public void setVote(int vote){
        this.vote=vote;
    }


}
