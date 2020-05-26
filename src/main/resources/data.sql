-- 単体テスト時に実行されるSQL文（DML）
insert into Policy (policy_no, S, OW, LA) VALUES ('0000000001', '1000000', '契約者１','被保険者1') ;
insert into Policy (policy_no, S, OW, LA) VALUES ('0000000002', '2000000', '契約者２','被保険者２') ;
insert into Policy (policy_no, S, OW, LA) VALUES ('0000000003', '3000000', '契約者３','被保険者３') ;
insert into Policy (policy_no, S, OW, LA) VALUES ('0000000004', '4000000', '契約者４','被保険者４') ;

-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('成立', '0000000001', 'ToDo') ;
-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('保険料支払', '0000000001', 'ToDo') ;
-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('保険料支払', '0000000001', 'ToDo') ;

-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('成立', '0000000002', 'Done') ;
-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('保険料支払', '0000000002', 'ToDo') ;
-- insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('保険料支払', '0000000002', 'ToDo') ;


