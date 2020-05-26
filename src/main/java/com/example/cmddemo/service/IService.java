package com.example.cmddemo.service;

//トランザクション処理のインターフェース
public interface IService {
    
    //実装を強制するメソッドのシグネチャ。
    public String doService();

}