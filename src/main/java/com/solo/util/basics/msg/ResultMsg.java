package com.solo.util.basics.msg;

import java.util.Scanner;

import com.solo.util.basics.contstant.ResultContant;



public class ResultMsg {
	
	/**数据信息**/
	private Object data;
	/**返回代码参数**/
	private String code=ResultContant.RESULT_CODE_FAIL;
	/**错误代码**/
	private String error_msg;
	/**其他信息**/
	private Object info;
	
	
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	
	/**
	 * 操作成功
	 * wkf
	 * 2017-12-29
	 *@param objData
	 */
	public void success(Object objData){
		this.data=objData;
		this.code=ResultContant.RESULT_CODE_SUCCESS;
		this.error_msg=ResultContant.RESULT_MSG_SUCCESS;
	}
	public void success(){
		this.data=ResultContant.RESULT_MSG_SUCCESS;
		this.code=ResultContant.RESULT_CODE_SUCCESS;
		this.error_msg=ResultContant.RESULT_MSG_SUCCESS;
	}
	
	/**
	 * 操作失败
	 * @param errorMsg
	 * @param code
	 */
	public void error(String errorMsg,String code){
		this.error_msg=errorMsg;
		this.code=code;
	}
	public void error(){
		this.error_msg=ResultContant.RESULT_MSG_FAIL;
		this.code=ResultContant.RESULT_CODE_FAIL;
	}
}
