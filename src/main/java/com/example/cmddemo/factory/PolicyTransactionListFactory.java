package com.example.cmddemo.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.example.cmddemo.domain.PolicyTransaction;
import com.example.cmddemo.domain.PolicyTransactionList;
import com.example.cmddemo.repository.PolicyRepository;
import com.example.cmddemo.repository.PolicyTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Componentアノテーションを付けると、アプリケーションコンテキストから取得できるようになります。
@Component
public class PolicyTransactionListFactory {
    
    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyRepository pRep;

    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    PolicyTransactionRepository ptRep;

    public Collection<PolicyTransactionList> getTargetPolicyTransactions(){

        HashMap<String,PolicyTransactionList> trnMap = new HashMap<String,PolicyTransactionList>();
        
        Collection<PolicyTransaction> trns = ptRep.findUnexecutedTransaction();

        Iterator<PolicyTransaction> it = trns.iterator();

        while(it.hasNext()){
            PolicyTransaction trn = it.next();
            PolicyTransactionList trnList = trnMap.get(trn.getPolicy_no());

            if(trnList == null){
                trnList = new PolicyTransactionList();
                trnList.setPolicy_no(trn.getPolicy_no());
            }

            trnList.addPolicyTransaction(trn);
            trnMap.put(trn.getPolicy_no(), trnList);
        }

        return trnMap.values();
    }

}