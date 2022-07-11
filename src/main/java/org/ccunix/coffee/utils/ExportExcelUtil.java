package org.ccunix.coffee.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

@Component("exportExcelUtil")
public class ExportExcelUtil {

	// XSSFCellStyle.ALIGN_CENTER 居中对齐    
	// XSSFCellStyle.ALIGN_LEFT 左对齐    
	// XSSFCellStyle.ALIGN_RIGHT 右对齐    
	// XSSFCellStyle.VERTICAL_TOP 上对齐    
	// XSSFCellStyle.VERTICAL_CENTER 中对齐    
	// XSSFCellStyle.VERTICAL_BOTTOM 下对齐    
	// CellStyle.BORDER_DOUBLE 双边线    
	// CellStyle.BORDER_THIN 细边线    
	// CellStyle.BORDER_MEDIUM 中等边线    
	// CellStyle.BORDER_DASHED 虚线边线    
	// CellStyle.BORDER_HAIR 小圆点虚线边线    
	// CellStyle.BORDER_THICK 粗边线    
	/**    
	    *    
	    * @param response    请求    
	    * @param fileName    文件名 如："用户表"    
	    * @param excelHeader    excel表头数组，存放"管理员#admin"格式字符串，"管理员"为excel标题行， "admin"为对象字段名    
	    * @param dataList    数据集合，需与表头数组中的字段名一致，并且符合javabean规范    
	    * @return 返回一个HSSFWorkbook    
	    * @throws Exception    
	    */
	public static <T> void export(HttpServletResponse response, String fileName, String[] excelHeader,
			Collection<T> dataList) throws Exception {
		// 设置回应头  文件下载类型
		response.setContentType("application/x-download");
		// 下面三行是关键代码，处理中文表名乱码问题  
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
		// 创建一个Workbook，对应一个Excel文件    
		HSSFWorkbook wb = new HSSFWorkbook();
		// 设置标题样式    
		HSSFCellStyle titleStyle = wb.createCellStyle();
		// 设置单元格边框样式    
		titleStyle.setBorderTop(BorderStyle.THIN);
		// 上边框 细边线    
		titleStyle.setBorderBottom(BorderStyle.THIN);// 下边框 细边线    
		titleStyle.setBorderLeft(BorderStyle.THIN);// 左边框 细边线    
		titleStyle.setBorderRight(BorderStyle.THIN);// 右边框 细边线    
		// 设置单元格对齐方式    
		titleStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		// 垂直居中
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 设置字体样式    
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 15);// 字体高度    
		titleFont.setFontName("黑体");// 字体样式    
		titleStyle.setFont(titleFont);
		// 在Workbook中添加一个sheet,对应Excel文件中的sheet    
		HSSFSheet sheet = wb.createSheet(fileName);
		//excelHeader: ["主键序号#id","类别名称#name","联系方式#phone","性别#sex"]
		// 标题数组
		String[] titleArray = new String[excelHeader.length];
		// 字段名数组
		String[] fieldArray = new String[excelHeader.length];
		for (int i = 0; i < excelHeader.length; i++) {
			String[] tempArray = excelHeader[i].split("#");// 临时数组 分割#      主键序号#id
			titleArray[i] = tempArray[0];//["主键序号","类别名称","联系方式","性别"]
			fieldArray[i] = tempArray[1];//["id","name","","phone","sex"]
		}
		// 在sheet中添加标题行    
		HSSFRow row = sheet.createRow((int) 0);// 行数从0开始    
		// 需要序号才把下面注解打开
//		HSSFCell sequenceCell = row.createCell(0);// cell列 从0开始 第一列添加序号    
//		sequenceCell.setCellValue("序号");
//		sequenceCell.setCellStyle(titleStyle);
		sheet.autoSizeColumn(0);// 自动设置宽度    
		// 设置表格默认列宽度
		sheet.setDefaultColumnWidth(20);
		// 为标题行赋值    
		for (int i = 0; i < titleArray.length; i++) {
			// 需要序号就需要i+1   因为0号位被序号占用
			HSSFCell titleCell = row.createCell(i);
			titleCell.setCellValue(titleArray[i]);
			titleCell.setCellStyle(titleStyle);
			sheet.autoSizeColumn(i + 1);// 0号位被序号占用，所以需+1    
		}
		// 数据样式 因为标题和数据样式不同 需要分开设置 不然会覆盖    
		HSSFCellStyle dataStyle = wb.createCellStyle();
		// 设置数据边框
		dataStyle.setBorderBottom(BorderStyle.THIN);
		dataStyle.setBorderTop(BorderStyle.THIN);
		dataStyle.setBorderLeft(BorderStyle.THIN);
		dataStyle.setBorderRight(BorderStyle.THIN);
		// 设置居中样式
		dataStyle.setAlignment(HorizontalAlignment.CENTER);
		// 水平居中
		dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中    
		// 设置数据字体
		Font dataFont = wb.createFont();
		dataFont.setFontHeightInPoints((short) 12);// 字体高度    
		dataFont.setFontName("宋体");// 字体    
		dataStyle.setFont(dataFont);
		// 遍历集合数据，产生数据行
		Iterator<T> it = dataList.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;// 0号位被占用 所以+1  
			row = sheet.createRow(index);
			T t = (T) it.next();//单个数据对象内容
			// 利用反射，根据传过来的字段名数组，动态调用对应的getXxx()方法得到属性值
			for (int i = 0; i < fieldArray.length; i++) {
				// 需要序号就需要i+1
				HSSFCell dataCell = row.createCell(i);
				dataCell.setCellStyle(dataStyle);
				// 需要序号就需要i+1
				sheet.autoSizeColumn(i);
				String fieldName = fieldArray[i];// ["Id","name","","phone","sex"]
				String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);//取得对应getXxx()方法
				Class<? extends Object> tCls = t.getClass();// 泛型为Object以及所有Object的子类    
				Method getMethod = tCls.getMethod(getMethodName);// 通过方法名得到对应的方法    
				Object value = getMethod.invoke(t);// 动态调用方,得到属性值
				if (value != null) {
					dataCell.setCellValue(value.toString());// 为当前列赋值    
				}
			}
		}

		OutputStream outputStream = response.getOutputStream();// 打开流     网络输出流   回应流
		wb.write(outputStream);// HSSFWorkbook写入流    
		wb.close();// HSSFWorkbook关闭    
		outputStream.flush();// 刷新流    
		outputStream.close();// 关闭流    
	}

}
