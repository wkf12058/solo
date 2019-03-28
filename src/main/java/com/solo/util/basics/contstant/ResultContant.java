package com.solo.util.basics.contstant;

public class ResultContant {

	/**操作成功**/
	public static final String RESULT_CODE_SUCCESS = "200";
	public static final String RESULT_MSG_SUCCESS = "成功";
	
	/**操作失败**/
	public static final String RESULT_CODE_FAIL = "500";//默认
	public static final String RESULT_MSG_FAIL = "请求失败";
	
	
	/**操作失败**/
	public static final String RESULT_CODE_FAIL_NO_PARA = "501";
	public static final String RESULT_MSG_FAIL_NO_PARA = "未获取到参数，无效的请求";
	
	/**账号不存在**/
	public static final String RESULT_CODE_USERNAME_ERROR= "220";
	public static final String RESULT_MSG_USERNAME_ERROR= "账号不存在";
	
	/**账号重复**/
	public static final String RESULT_CODE_USERNAME_REPEAT= "221";
	public static final String RESULT_MSG_USERNAME_REPEAT= "账号已被注册";
	
	
	/**密码错误**/
	public static final String RESULT_CODE_PASSWORD_ERROR= "230";
	public static final String RESULT_MSG_PASSWORD_ERROR= "密码错误";
	
	
}
