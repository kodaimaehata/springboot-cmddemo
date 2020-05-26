package com.example.cmddemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.example.cmddemo.domain.Policy;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@MybatisTest
public class PolicyRepositoryTest {
    
    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyRepository repo;

    //@Testアノテーションでこれがテストメソッドであると宣言できる
    //@Sqlアノテーションで、テストデータを生成できる。ファイル読み込みも可能なので詳しくは公式ドキュメントを。
    @Test
    @Sql(statements = "insert into Policy (policy_no, S, OW, LA) VALUES ('0000000005', '5000000', '契約者５','被保険者５')")
    void testFindOne(){
        Optional<Policy> pol = repo.findOne("0000000005");
        assert(!pol.isEmpty());
        Policy p = pol.get();
        assertEquals("0000000005",p.getPolicy_no());
    }
}