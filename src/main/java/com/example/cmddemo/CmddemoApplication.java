package com.example.cmddemo;

import com.example.cmddemo.job.JobLauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplicationアノテーションがついたクラスはプロジェクトに一つだけ。実行時にこのクラスが起動する。
@SpringBootApplication
public class CmddemoApplication {

	//Javaのメインクラス
	public static void main(String[] args) {
		//ここでSpringbootの基盤処理が実行され、アプリケーションコンテキスト等が生成される。
		ConfigurableApplicationContext ctx = SpringApplication.run(CmddemoApplication.class, args);

		//上の処理だけではアプリの処理は何も実行されないので、アプリケーションコンテキストからこのクラスを取得し、処理用のメソッドを実行する。
		CmddemoApplication app = ctx.getBean(CmddemoApplication.class);
		app.run(ctx,args);
	}

	//実行用メソッド。JobLauncherを起動します。
	private void run(ConfigurableApplicationContext ctx,String[] args){
		//普通にインスタンス化するとSpringbootのDIコンテナが使われないので、アプリケーションコンテキストからインスタンスを取得して実行する。
		JobLauncher job = ctx.getBean(JobLauncher.class);
		job.run("Test");

	}

}
