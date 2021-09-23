package rayboc.rayboc.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RaybocLogger {
	
	public static Logger logger = LogManager.getLogger(RaybocLogger.class);
	
	/**
	 * クラス、メソッド名を付加したログメッセージを返す
	 * @param log ログメッセージ
	 * @return クラス、メソッド名を付加したログメッセージ
	 */
	public static String getLogComMsg(String log) {
		StackTraceElement[] ste = new Throwable().getStackTrace();
		String className = "CLASS=" + ste[1].getClassName();
		String methodName = "MTHD=" + ste[1].getMethodName();
		return className + "：" + methodName + "：" + log;
	}

}
