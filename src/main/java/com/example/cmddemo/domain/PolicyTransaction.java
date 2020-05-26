package com.example.cmddemo.domain;

import lombok.Data;

//@Dataアノテーションを付けると、lombokの機能で裏で自動的にgetterとsetterを作ってくれる。
@Data
public class PolicyTransaction {
    private Integer transaction_no;
    private String transaction_type;
    private String policy_no;
    private String stat;

}