package com.example.cmddemo.domain;

import lombok.Data;

//@Dataアノテーションを付けると、lombokの機能で裏で自動的にgetterとsetterを作ってくれる。
@Data
public class Policy {
    private String policy_no ;
    private String S;
    private String OW;
    private String LA;
}