package com.example.cmddemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Aspectアノテーションを付けるとAOPの部品として使えます。このクラスは特定クラスのメソッド実行前後で開始、終了ログを吐いています。ExceptionがThrowされた場合の処理も記述できるので、例外処理をAOPで書くことを検討すると良いかと思います。
//@Componentアノテーションを付けると、アプリケーションコンテキストから取得できるようになります。
//@Slf4jはJavaのログ出力のFacadeライブラリ。デフォルト設定だとLobBackが利用されます（コンソール出力します）。ApplicationInsightはLogbackにも対応しているので、Logbackを使うと良いかも。
@Aspect
@Component
@Slf4j
public class LogAspect {
    
    //serviceパッケージのdoServiceメソッドを実行する前にログを吐く
    @Before("execution(* com.example.cmddemo.service.*.doService(..))")
    public void startLog(JoinPoint jp){
        log.info(jp.getSignature() + " Started.");
    }

    //serviceパッケージのdoServiceメソッドを実行した後にログを吐く
    @After("execution(* com.example.cmddemo.service.*.doService(..))")
    public void endLog(JoinPoint jp){
        log.info(jp.getSignature() + " Ended.");
    }
}