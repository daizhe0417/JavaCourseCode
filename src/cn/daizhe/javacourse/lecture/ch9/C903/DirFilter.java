package cn.daizhe.javacourse.lecture.ch9.C903;

import java.io.*;

public class DirFilter implements FilenameFilter {
	private String prefix; // 文件名前缀
	private String extend; // 文件扩展名

	public DirFilter(String filterstr) {
		this.prefix = "";
		this.extend = "";
		filterstr = filterstr.toLowerCase();
		int i = filterstr.indexOf('*');
		if (i > 0)
			this.prefix = filterstr.substring(0, i); // 获得*之前的字符串

		int j = filterstr.indexOf('.');
		if (j > 0) {
			this.extend = filterstr.substring(j + 1); // 获得.之后的文件扩展名字符串
			if (this.extend.equals("*")) // 识别"*.*"
				this.extend = "";
		}

		File dir = new File(".", ""); // 当前目录
		System.out.println(dir.getAbsolutePath() + "目录中，" + filterstr
				+ "文件如下： ");
		String[] filenames = dir.list(this); // 获得指定目录中带过滤器的文件名列表
		for (i = 0; i < filenames.length; i++)
			System.out.println(filenames[i]);
	}

	public DirFilter() {
		this("*.*");
	}

	public boolean accept(File dir, String filename) {
		filename = filename.toLowerCase();
		return (filename.startsWith(this.prefix))
				& (filename.endsWith(this.extend));
	}

	public static void main(String args[]) {
		new DirFilter("Byte*.dat");
		// new DirFilter(); //没有参数或"*.*"都表示所有文件
	}

}
