-- 単体テスト時に実行されるSQL文（DDL）
create table Policy(
    policy_no VARCHAR(10) PRIMARY KEY,
    S VARCHAR(10),
    OW VARCHAR(30),
    LA VARCHAR(30)
);

create table PolicyTransaction(
    transaction_no int IDENTITY PRIMARY KEY,
    transaction_type VARCHAR(20) NOT NULL,
    policy_no VARCHAR(10) NOT NULL,
    stat VARCHAR(10) NOT NULL
);
