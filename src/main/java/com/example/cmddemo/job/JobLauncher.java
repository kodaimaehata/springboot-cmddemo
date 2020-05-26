package com.example.cmddemo.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Iterator;

import com.example.cmddemo.domain.Policy;
import com.example.cmddemo.domain.PolicyTransaction;
import com.example.cmddemo.domain.PolicyTransactionList;
import com.example.cmddemo.factory.PolicyTransactionListFactory;
import com.example.cmddemo.repository.PolicyRepository;
import com.example.cmddemo.service.*;

//@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
//@Slf4jはJavaのログ出力のFacadeライブラリ。デフォルト設定だとLobBackが利用されます（コンソール出力します）。ApplicationInsightはLogbackにも対応しているので、Logbackを使うと良いかも。
@Slf4j
@Component
public class JobLauncher{

    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyRepository pRepo;

    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyTransactionListFactory ptlf;

    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    ApplicationContext ctx;


    //バッチのメイン処理
    public void run(String...strings){
        for(String s:strings){
            System.out.println(s);
        }
        
        log.info("Hello World");

        //意味は無いが契約データを読み込んでみる。
        Collection<Policy> pols = pRepo.findAll();

        //Factoryクラスから証券番号単位のトランザクションのリストを取得
        Collection<PolicyTransactionList> ptl = ptlf.getTargetPolicyTransactions();

        Iterator<PolicyTransactionList> it = ptl.iterator();
        while(it.hasNext()){
            PolicyTransactionList p = it.next();
            log.info(p.toString());
            log.info("Transactions for policy no : " + p.getPolicy_no() + " start.");

            //トランザクション単位に処理を実行（サービス名を返すだけの実装になってます。）
            for(PolicyTransaction pt : p.getTransactionList()){
                IService svc = getService(pt.getTransaction_type());
                log.info("Service " + svc.doService() + " was executed for transaction type " + pt.getTransaction_type());
            };
            log.info("Transactions for policy no : " + p.getPolicy_no() + " end.");    
        }

    }

    //トランザクションの種類に応じて実行するサービスを返す（インタフェースのIServiceとして具象クラスを返却）
    //defaultのサービスは作成していないので、書いてあるもの以外が渡ると異常終了します。
    private IService getService(String trn){

        String serviceName;
        switch(trn){
            case "成立" :
            serviceName = "service01";
            break;

            case "保険料支払" :
            serviceName = "service02";
            break;

            default:
            serviceName = "defaultService";
        }

        return (IService)ctx.getBean(serviceName);

    }
}