package com.o2o.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Configuration
public class PathUtil {
	private static String separator = System.getProperty("file.separator");
	private static final SimpleDateFormat sDateFormat =
			new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();

	private static String winPath;
	private static String linuxPath;
	private static String shopPath;

	@Value("${win.base.path}")
	public void setWinPath(String winPath) {
		PathUtil.winPath = winPath;
	}

	@Value("${linux.base.path}")
	public void setLinuxPath(String linuxPath) {
		PathUtil.linuxPath = linuxPath;
	}

	@Value("${shop.relevant.path}")
	public void setShopPath(String shopPath) {
		PathUtil.shopPath = shopPath;
	}

	// 项目图片的根路径
	public static String getImgBasePath(){
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")){
			basePath = winPath;
		}else{
			basePath = linuxPath;
		}
		basePath = basePath.replace("/",separator);
		return basePath;
	}

	// 返回项目图片的子路径
	public static String getShopImagePath(long shopId){
		String imagePath =shopPath + shopId + separator;
		return imagePath.replace("/", separator);
	}

	//生成随机文件名，当前年月日时分秒+随机五位数
	public static String getRandomFileName() {
		//获取五位随机数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}
}
