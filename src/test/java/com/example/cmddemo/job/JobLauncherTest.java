package com.example.cmddemo.job;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import com.example.cmddemo.service.IService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTestアノテーションを使うとSpringbootの基盤処理を行った状態でテストができます。
@SpringBootTest
public class JobLauncherTest{

    //@AutoWiredを付けると、アプリ実行時にSpringが勝手に変数をインスタンス化してくれる
    @Autowired
    JobLauncher launcher;

    //@Testアノテーションでこれがテストメソッドであると宣言できる
    @Test
    void runTest(){

        launcher.run("test");

    }

    @Test
    void getServiceTest(){
        //JavaにはApexのようなprivateメソッドテスト用のアノテーションは無いので、privateメソッドのテストには若干手間がかかります。テスト用のUtilクラスを作って使用するのが良いと思います。
        Class[] classes = new Class[1];
        classes[0] = String.class;
        Method method;
        try{
            method = launcher.getClass().getDeclaredMethod("getService", classes);
            // テスト対象メソッドへのアクセス制限を解除
            method.setAccessible(true);

            IService svc1 = (IService)method.invoke(launcher, "成立");
            assertEquals("成立処理サービス", svc1.doService());

            IService svc2 = (IService)method.invoke(launcher, "保険料支払");
            assertEquals("保険料支払処理サービス", svc2.doService());

            try{
                IService svc3 = (IService)method.invoke(launcher, "default");
                svc3.doService();
                assert(false);
            }catch (Exception e){
                assert(true);
            }

        }catch(Exception e){
            assert(false);
        }
    }

}