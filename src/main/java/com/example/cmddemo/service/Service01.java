package com.example.cmddemo.service;

import org.springframework.stereotype.Service;

//@Serviceを付けるとアプリケーションコンテキストから読み込めるようになります。
//これがあるからJobLauncerで読みこめてます。
@Service
public class Service01 implements IService{

    //インタフェースのメソッドをOverride。サービスごとに異なる処理を実装します。
    @Override
    public String doService(){
        return "成立処理サービス";
    }
    
}