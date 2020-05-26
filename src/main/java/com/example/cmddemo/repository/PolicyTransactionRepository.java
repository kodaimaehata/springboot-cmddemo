package com.example.cmddemo.repository;

import java.util.Collection;

import com.example.cmddemo.domain.PolicyTransaction;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapperアノテーションがついた「Interface」は、MyBatisがDBアクセス等のprimitiveな処理を全部自動生成してくれる。
//ここではクラスにSQL直書きをしていますが、設定ファイルに諸々まとめることもできます。詳しくは公式ドキュメントを。
@Mapper
public interface PolicyTransactionRepository {
    
    
    //@Selectアノテーションには、実行するSQLを書いて、メソッドのシグネチャを定義します。
    @Select("select * from PolicyTransaction where stat != 'Done'")
    Collection<PolicyTransaction> findUnexecutedTransaction();
}