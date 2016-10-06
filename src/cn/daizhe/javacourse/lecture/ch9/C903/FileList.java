package cn.daizhe.javacourse.lecture.ch9.C903;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileList {
	public FileList() {
		File dir = new File("."); // 当前目录
		int count_dirs = 0, count_files = 0; // 目录数和文件数
		long byte_files = 0; // 所有文件总字节数

		System.out.println(dir.getAbsolutePath() + " 目录\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		File[] files = dir.listFiles(); // 返回当前目录中所有文件
		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i].getName() + "\t"); // 显示文件名
			if (files[i].isFile()) // 判断指定File对象是否是文件
			{
				System.out.print(files[i].length() + "B\t");// 显示文件长度
				count_files++;
				byte_files += files[i].length();
			} else if(files[i].isDirectory()) {
				System.out.print("<DIR>\t");
				count_dirs++;
			}
			System.out.println(sdf.format(new Date(files[i].lastModified())));
		}
		System.out
				.println("\r\n共有 " + count_files + " 个文件，总字节数为 " + byte_files);
		System.out.println("共有 " + count_dirs + " 个目录");

	}

	public static void main(String args[]) throws IOException {
		new FileList();
	}
}