package io.renren.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	private static Logger logger;

	static {
		logger = LoggerFactory.getLogger("my_info");
		if (logger == null) {
			logger = LoggerFactory.getLogger(LogUtil.class);
		}
	}

	/**
	 * 
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void info(String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.info(sb.toString());
		} else {
			logger.info(sb.toString(), params);
		}
	}

	/**
	 * 
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void debug(String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.debug(sb.toString());
		} else {
			logger.debug(sb.toString(), params);
		}
	}

	/**
	 * 警告信息
	 * 
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void warn(String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.warn(sb.toString());
		} else {
			logger.warn(sb.toString(), params);
		}
	}

	/**
	 * 错误信息
	 * 
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void error(String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.error(sb.toString());
		} else {
			logger.error(sb.toString(), params);
		}
	}

	/**
	 * 方法开始调用
	 * 
	 * @param operateName
	 *            业务操作名称或方法名
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void logBefore(String operateName, String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>>>>start>>>")
				.append(operateName).append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.info(sb.toString());
		} else {
			logger.info(sb.toString(), params);
		}
	}

	/**
	 * 方法结束调用
	 * 
	 * @param operateName
	 *            业务操作名称或方法名
	 * @param info
	 *            需要输出的信息 占位符为 {}
	 * @param params
	 *            若有参数，info需使用占位符 eg：logger.info("{},{},it's OK.","Hi","Jack");
	 */
	public static void logAfter(String operateName, String info, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(">>>>>>end>>>")
				.append(operateName).append(">>>").append(info);
		if (params == null || params.length == 0) {
			logger.info(sb.toString());
		} else {
			logger.info(sb.toString(), params);
		}
	}

	public static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}
}

