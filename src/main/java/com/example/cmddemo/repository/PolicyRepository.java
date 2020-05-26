package com.example.cmddemo.repository;

import java.util.Collection;
import java.util.Optional;

import com.example.cmddemo.domain.Policy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapperアノテーションがついた「Interface」は、MyBatisがDBアクセス等のprimitiveな処理を全部自動生成してくれる。
//ここではクラスにSQL直書きをしていますが、設定ファイルに諸々まとめることもできます。詳しくは公式ドキュメントを。
@Mapper
public interface PolicyRepository {
    
    //@Selectアノテーションには、実行するSQLを書いて、メソッドのシグネチャを定義します。
    @Select("select policy_no, OW, LA, S from Policy")
    Collection<Policy> findAll();

    //@Selectアノテーションには、実行するSQLを書いて、メソッドのシグネチャを定義します。
    @Select("select policy_no, OW, LA, S from Policy where policy_no = #{polNo}")
    Optional<Policy> findOne(String polNo);
}