package com.example.cmddemo.domain;

import java.util.ArrayList;

import lombok.Data;

//@Dataアノテーションを付けると、lombokの機能で裏で自動的にgetterとsetterを作ってくれる。
@Data
public class PolicyTransactionList {
    private String policy_no;
    private ArrayList<PolicyTransaction> transactionList = new ArrayList<PolicyTransaction>();

    public void addPolicyTransaction(PolicyTransaction pt){
        transactionList.add(pt);
    }

}