package com.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
	private static String basePath = PathUtil.getImgBasePath();


	public static String generateThumbnail(InputStream thumbnail, String fileName,String targetAddr) {
		String realFileName = PathUtil.getRandomFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}

	//创建目标路径涉及到的目录
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}

	//获取扩展名
	private static String getFileExtension(String fileName) {
		return  fileName.substring(fileName.lastIndexOf("."));
	}

	//storePath是目录路径还是文件路径
	public static void deleteFileOrPath(String storePath){
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if(fileOrPath.exists()){
			//是目录
			if(fileOrPath.isDirectory()){
				File[] files = fileOrPath.listFiles();
				for (int i=0; i<files.length; i++){
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
