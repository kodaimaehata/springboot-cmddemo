package com.example.cmddemo.service;

import org.springframework.stereotype.Service;

//@Serviceを付けるとアプリケーションコンテキストから読み込めるようになります。
//これがあるからJobLauncerで読みこめてます。
@Service
public class Service02 implements IService{

    //インタフェースのメソッドをOverride。サービスごとに異なる処理を実装します。
    @Override
    public String doService(){
        return "保険料支払処理サービス";
    }
    
}