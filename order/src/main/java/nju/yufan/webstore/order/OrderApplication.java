package nju.yufan.webstore.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Timer;

@SpringBootApplication
@MapperScan("nju.yufan.webstore.order.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
		Timer timer = new Timer();
		timer.schedule(new OrderTimerTask(),OrderTimerTask.delay,OrderTimerTask.period);
	}

}
