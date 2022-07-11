package org.ccunix.coffee.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIExcelUtil {

	public static void main(String[] args) {
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sut1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 创建一个居中格式
		style.setAlignment(HorizontalAlignment.CENTER);
		//创建第0行的   第i列的单元格  作为表头
		HSSFCell cell = row.createCell(0);//第0列
		cell.setCellValue("学号");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("年龄");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("生日");
		cell.setCellStyle(style);

		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		List list = CreateSimpleExcelToDisk.getStudent();
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			Student stu = (Student) list.get(i);
			// 第四步，创建单元格，并设置值
			HSSFCell column0 = row.createCell(0);
			column0.setCellValue(stu.getId());
			column0.setCellStyle(style);

			HSSFCell column1 = row.createCell(1);
			column1.setCellValue(stu.getName());
			column1.setCellStyle(style);

			HSSFCell column2 = row.createCell(2);
			column2.setCellValue(stu.getAge());
			column2.setCellStyle(style);

			HSSFCell column3  = row.createCell(3);
			column3.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));
			column3.setCellStyle(style);
		}
		// 第六步，将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream("d:/students.xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class CreateSimpleExcelToDisk {
	public static List<Student> getStudent() {
		List<Student> stuList = new ArrayList<Student>();
		Student s1 = new Student(1001, "魏建波1", 30, new Date());
		Student s2 = new Student(1002, "魏建波2", 30, new Date());
		Student s3 = new Student(1003, "魏建波3", 30, new Date());
		Student s4 = new Student(1004, "魏建波4", 30, new Date());
		Student s5 = new Student(1005, "魏建波5", 30, new Date());
		Student s6 = new Student(1006, "强哥", 20, new Date());
		Student s7 = new Student(1007, "胡敏楠", 21, new Date());
		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);
		stuList.add(s4);
		stuList.add(s5);
		stuList.add(s6);
		stuList.add(s7);
		return stuList;
	}
}

class Student {
	int id;
	String name;
	int age;
    Date birth;

	public Student(int id, String name, int age, Date birth) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
