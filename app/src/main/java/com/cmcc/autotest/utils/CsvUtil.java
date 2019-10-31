package com.cmcc.autotest.utils;

import android.content.Context;

import com.csvreader.CsvReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvUtil {

	/**
	 * 加载测试数据
	 * @param ctx
	 * @param fileName
	 * @return
	 */
	public static List<String[]> loadData(Context ctx, String fileName) {
		List<String[]> datas = new ArrayList<>();
		try{
			InputStream mInputStream = ctx.getResources().getAssets().open(fileName);

			try {
				// 创建CSV读对象
				CsvReader csvReader = new CsvReader(mInputStream, ',', Charset.forName("UTF-8"));
				csvReader.readHeaders(); // 跳过首行
				while (csvReader.readRecord()) {
					String row = csvReader.getRawRecord();
					datas.add(row.split(","));
				}
				csvReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * 加载测试数据
	 * @param testClass
	 * @return
	 */
	public static Collection<?> loadData(Class<?> testClass) {
		String baseDir = System.getProperty("user.dir") + "/src/test/resources/".replace("/", File.separator);
		String file = baseDir + testClass.getName().toLowerCase().replace(".", File.separator) + ".csv";
		System.out.println("loadData: ---------->" + file);

		List<String[]> datas = new ArrayList<>();
		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(file, ',', Charset.forName("UTF-8"));
			csvReader.readHeaders(); // 跳过首行
			while (csvReader.readRecord()) {
				String row = csvReader.getRawRecord();
				datas.add(row.split(","));
			}
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
//        String[][] params = {{"case-001","test001","001"},{"case-002","test002","002"}};
//        return Arrays.asList(params);
	}
}
