/**  
 * @Title: ErrorInfo.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-3-27 下午4:05:08  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

/**
 * @ClassName: ErrorInfo
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-3-27 下午4:05:08
 * @version V1.0
 */
public enum ErrorInfo {

	ERROR_1001(1001, "%s=%s");
	private final Integer errorCode;
	private final String errorMsg;

	ErrorInfo(Integer errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg(Object... args) {
		String rusult = String.format(errorMsg, args);
		return rusult;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public static void main(String[] args) {
		System.out.println(ErrorInfo.ERROR_1001.getErrorMsg("key", "value"));
	}

}
