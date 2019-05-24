package pers.xin.springbootscheduler.scheduler;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.xin.springbootscheduler.DateUtils;

@Component
@Slf4j
public class DemoScheduler {

	ExecutorService service = Executors.newFixedThreadPool(10);

	/*@Async
	@Scheduled(cron = "0/1 * * * * ? ")// 0秒开始，每秒执行一次。
	public void printSingleThread() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"----"+new Date());
		Thread.sleep(5000);
	}*/

	@Async
	@Scheduled(cron = "0 0/30 * * * ?")// 0秒开始，每秒执行一次。
	public void test1() throws InterruptedException {
		Date fromTime = DateUtils.getTheNearestHourOrHalf(new Date());
		Date toTime = new Date(fromTime.getTime() + 30 * 60 * 1000);
		log.info(Thread.currentThread().getName()+"fromTime: " + fromTime.toString() + " toTime: " + toTime);
		Thread.sleep(35 * 60 * 1000);//睡35分钟
	}

	/*@Scheduled(cron = "0/5 * * * * ? ")// 0秒开始，每秒执行一次。
	public void printMultiThread(){
		service.execute(() -> {
			System.out.println(Thread.currentThread().getName()+"----"+new Date());
			try {
				Thread.sleep(1000 * 50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}*/
}
