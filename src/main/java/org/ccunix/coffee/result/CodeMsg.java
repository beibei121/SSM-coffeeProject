package org.ccunix.coffee.result;

/**
 * 消息类型      消息代号       消息内容
 */
public class CodeMsg {
	private int code;
	private String msg;
	// 创建2个静态变量
	// 通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
	// 登录模块 5002XX
	public static CodeMsg LOGIN_ERROR = new CodeMsg(500215, "用户名或者密码错误");
	public static CodeMsg SESSION_ERROR = new CodeMsg(500211, "Session不存在或者失效");
	// 注册模块 5003XX
	public static CodeMsg MOBILE_EXIST_REGISTER = new CodeMsg(500301, "手机号已经被注册");
	public static CodeMsg NIKENAME_EXIST = new CodeMsg(500302, "昵称经被使用");
	// 订单模块 5004XX
	public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");
	//咖啡类型管理模块
	public static CodeMsg COFFEETYPE_ADD_ERROR = new CodeMsg(500500, "咖啡类型添加失败");
	public static CodeMsg COFFEETYPE_UPDATE_ERROR = new CodeMsg(500501, "咖啡类型修改失败");
	public static CodeMsg COFFEETYPE_DELETE_ERROR = new CodeMsg(500502, "咖啡类型删除失败");
	//口味管理模块
	public static CodeMsg COFFEETASTE_ADD_ERROR = new CodeMsg(500600, "口味类型添加失败");
	public static CodeMsg COFFEETASTE_UPDATE_ERROR = new CodeMsg(500601, "口味类型修改失败");
	public static CodeMsg COFFEETASTE_DELETE_ERROR = new CodeMsg(500602, "口味类型删除失败");

	public CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public CodeMsg fillArgu(Object ...objects) {
		int code = this.code;
		String message = String.format(this.msg, objects) ;
		return new CodeMsg(code, message);
	}
	public static void main(String[] args) {
		String str="参数校验异常：%s";
		String formatStr=String.format(str, "手机号格式错误");
		System.out.println(formatStr);
	}

}
