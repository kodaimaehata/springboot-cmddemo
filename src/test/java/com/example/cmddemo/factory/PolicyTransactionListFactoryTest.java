package com.example.cmddemo.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Iterator;

import com.example.cmddemo.domain.PolicyTransactionList;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

//結合テストをするときには@SpringbootTestを使うとSpringbootのアプリケーションコンテキストを諸々読み込んでくれる。
@SpringBootTest
public class PolicyTransactionListFactoryTest {
    
    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyTransactionListFactory fa;

    //@Testアノテーションでこれがテストメソッドであると宣言できる
    //@Sqlアノテーションで、テストデータを生成できる。テストクラスの存続期間中は投入したデータが残存する様子なので、テストが終わったら消しています。ファイル読み込みも可能なので詳しくは公式ドキュメントを。
    @Test
    @Sql(statements="insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('成立', '0000000001', 'ToDo') , ('保険料支払', '0000000001', 'ToDo') , ('保険料支払', '0000000001', 'ToDo') , ('成立', '0000000002', 'Done') , ('保険料支払', '0000000002', 'ToDo') , ('保険料支払', '0000000002', 'ToDo') ")
    @Sql(
        statements="delete from PolicyTransaction",
        executionPhase = ExecutionPhase.AFTER_TEST_METHOD
        )
    void getTargetPolicyTransactionsTest01(){
        Collection<PolicyTransactionList> ptList = fa.getTargetPolicyTransactions();
        ptList = fa.getTargetPolicyTransactions();
        assertEquals(2, ptList.size());
    }

    @Test
    @Sql(statements="insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('成立', '0000000001', 'ToDo') , ('保険料支払', '0000000001', 'ToDo') , ('保険料支払', '0000000001', 'ToDo') , ('成立', '0000000002', 'Done') , ('保険料支払', '0000000002', 'ToDo') , ('保険料支払', '0000000002', 'ToDo') ")
    @Sql(
        statements="delete from PolicyTransaction",
        executionPhase = ExecutionPhase.AFTER_TEST_METHOD
        )
    void getTargetPolicyTransactionsTest02(){
        Collection<PolicyTransactionList> ptList = fa.getTargetPolicyTransactions();
        assertEquals(2, ptList.size());
        Iterator<PolicyTransactionList> it = ptList.iterator();

        while(it.hasNext()){
            PolicyTransactionList ptl = it.next();
            if(ptl.getPolicy_no().equals("0000000001")) {
                assertEquals(3, ptl.getTransactionList().size());
            }else if(ptl.getTransactionList().equals("0000000002")){
                assertEquals(2, ptl.getTransactionList().size());
            }else{
                assert(false);
            }
        }
    }
}