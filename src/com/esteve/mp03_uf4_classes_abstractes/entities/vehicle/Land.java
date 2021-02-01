package com.esteve.mp03_uf4_classes_abstractes.entities.vehicle;

public class Land extends Vehicle{
    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public int getIssuesCost() {
        return issuesCost;
    }

    public void setIssuesCost(int issuesCost) {
        this.issuesCost = issuesCost;
    }

    protected int horsePower, issues, issuesCost;

    public Land(String id) {
        super(id);
        this.type = 'T';
    }
}
