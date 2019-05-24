package pers.xin.springbootscheduler;

import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {
	/**
	 * 获取当前时间以后的第一个01分或者31分，精确到毫秒
	 * @param date 当前时间
	 * @return 下一个01分或31分
	 */
	public static Date getTheNearestHourOrHalf(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		log.info(
				"转换前的时间：" + calendar.getTime().toString() + "  时间戳：" + calendar.getTimeInMillis());
		calendar.set(Calendar.SECOND, 0);
		if (calendar.get(Calendar.MINUTE) < 1) {
			calendar.set(Calendar.MINUTE, 1);
		} else {
			calendar.set(Calendar.MINUTE, 31);
		}
		calendar.set(Calendar.MILLISECOND, 0);//放在最后
		log.info(
				"转换后的时间：" + calendar.getTime().toString() + "  时间戳：" + calendar.getTimeInMillis());
		return calendar.getTime();
	}
}
