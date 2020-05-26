package com.example.cmddemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//このテストクラスで実行するテストではアプリケーションコンテキストはいらないので@Testアノテーションだけ使っています
public class Service01Test {

    @Test
    void doServiceTest(){
        Service01 s1 = new Service01();
        assertEquals("成立処理サービス", s1.doService());
    }
}