package com.example.cmddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//このテストクラスで実行するテストではアプリケーションコンテキストはいらないので@Testアノテーションだけ使っています
public class Service02Test {

    //このテストクラスで実行するテストではアプリケーションコンテキストはいらないので@Testアノテーションだけ使っています
    @Test
    void doServiceTest(){
        Service02 s2 = new Service02();
        assertEquals("保険料支払処理サービス",s2.doService());
    }
    
}