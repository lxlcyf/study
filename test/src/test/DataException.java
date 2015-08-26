/**  
 * @Title: DataException.java 
 * @Package com.dangdang.common.core 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2014-10-22 下午1:41:40  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

/**
 * @ClassName: DataException
 * @Description: 自定义数据异常
 * @author lixiaoliang
 * @date 2014-10-22 下午1:41:40
 * @version V1.0
 */
public class DataException extends Exception {

	/** 
	*@Fields serialVersionUID:序列号 
	*/
	private static final long serialVersionUID = -5680430171782272075L;
	/** 
	*@Fields errorCode:错误代码 
	*/
	private String errorCode;
	/** 
	*@Fields errorDesc:错误描述 
	*/
	private String errorDesc;

	/** 
	 * @Method:getErrorCode
	 * @Description:获取错误代码 
	 * @return 错误代码
	*/
	public String getErrorCode() {
		return errorCode;
	}

	/** 
	 * @Method:setErrorCode
	 * @Description:设置错误代码 
	 * @param errorCode 错误代码
	*/
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/** 
	 * @Method:getErrorDesc
	 * @Description:获得错误描述 
	 * @return 错误描述
	*/
	public String getErrorDesc() {
		return errorDesc;
	}

	/** 
	 * @Method:setErrorDesc
	 * @Description:设置错误描述 
	 * @param errorDesc 错误描述
	*/
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/** 
	*@Description: 构造函数 
	* @param errorCode 错误代码
	* @param errorDesc 错误描述
	* @param cause 异常原因
	*/
	public DataException(String errorCode, String errorDesc, Throwable cause) {
		super(errorDesc, cause);
		setErrorCode(errorCode);
		setErrorDesc(errorDesc);
	}
	
	/** 
	*@Description: 构造函数 
	* @param errorCode 错误代码
	* @param errorDesc 错误描述
	*/
	public DataException(String errorCode, String errorDesc) {
		super(errorDesc);
		setErrorCode(errorCode);
		setErrorDesc(errorDesc);
	}


	/** 
	 * @Method:main
	 * @Description:主函数 
	 * @param args 输入参数
	*/
	public static void main(String[] args) {
		Exception e = new Exception();
		try {
			throw new DataException("100", "test DataException", e);
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println("ee.getMessage():" + ee.getMessage());
			if (ee instanceof DataException) {
				DataException eee = (DataException) ee;
				System.out.println("eee.getErrorCode():" + eee.getErrorCode());
				System.out.println("eee.getErrorDesc():" + eee.getErrorDesc());
			}
		}
	}

}
