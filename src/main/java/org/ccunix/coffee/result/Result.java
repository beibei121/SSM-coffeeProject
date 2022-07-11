package org.ccunix.coffee.result;

/**
 * 前段数据返回数据信息类型
 * @param <T>
 */
public class Result<T> {
	private int code;// 状态码
	private String msg;// 信息
	private T data;// 数据
	/**
	 * 成功之后调用的方法
	 *
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}
	/**
	 * 失败之后调用的方法
	 *
	 * @return
	 */
	public static <T> Result<T> error(CodeMsg cm) {
		return new Result<T>(cm);
	}
	// 成功调用构造器
	private Result(T data) {
		this.data = data;
		this.code = 0;// 成功
		this.msg = "success";
	}

	// 失败调用构造器
	private Result(CodeMsg cm) {
		this.code = cm.getCode();// 失败
		this.msg = cm.getMsg();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
