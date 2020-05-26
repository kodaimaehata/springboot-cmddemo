package com.example.cmddemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Iterator;

import com.example.cmddemo.domain.PolicyTransaction;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@MybatisTest
public class PolicyTransactionRepositoryTest {
    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyTransactionRepository repo;

    //@Testアノテーションでこれがテストメソッドであると宣言できる
    //@Sqlアノテーションで、テストデータを生成できる。ファイル読み込みも可能なので詳しくは公式ドキュメントを。
    @Test
    @Sql(statements="insert into PolicyTransaction (transaction_type,policy_no,stat) VALUES ('成立', '0000000002', 'Done'),('保険料支払', '0000000002', 'ToDo'),('保険料支払', '0000000002', 'ToDo')")
    void findUnexecutedTransactionTest(){
        Collection<PolicyTransaction> pts = repo.findUnexecutedTransaction();
        assertEquals(2, pts.size());
        Iterator<PolicyTransaction> it = pts.iterator();

        while(it.hasNext()){
            PolicyTransaction pt = it.next();
            assert(pt.getStat() != "Done");
        }
    }
}