package org.toephy.blog.util;

import java.io.*;

public class FileUtil {
	
	/**
	 * 将文件读取为二进制数组
	 * @param fileLocation
	 * 			文件存储的路径
	 * @return byte[]
	 * 			返回文件的二进制数组
	 */
	public static byte[] fileToByte(String fileLocation) {
		ByteArrayOutputStream out = null;
		InputStream is = null;
		try {
			is = new FileInputStream(fileLocation);
			out = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = is.read(b)) != -1) {
				out.write(b, 0, n);
			}
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {}	
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {}
			}
		}
		return null;
	}

	public static String readFile(String filepath, boolean isclasspath, String charset) {
		StringBuilder stringBuilder = new StringBuilder("");
		try {
			File file;
			if (isclasspath) {
				file = ResourcesUtils.getResourceAsFile(filepath);
			} else {
				file = new File(filepath);
			}
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),charset);
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt;
			while((lineTxt = bufferedReader.readLine()) != null){
				stringBuilder.append(lineTxt);
			}
			read.close();
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * 向文件中写内容
	 * @param fileName
	 * 			被写的文件路径
	 * @param content
	 * 			待写入的内容
	 * @throws IOException 
	 */
	public static void writeFile(String filepath, String content, boolean isclasspath, String charset) {
		try {
			File file;
			if (isclasspath) {
				file = ResourcesUtils.getResourceAsFile(filepath);
			} else {
				file = new File(filepath);
			}
			if (!file.exists()) {
				createdirAndFile(file);
			}

			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file, false), charset);
			BufferedWriter writer = new BufferedWriter(write);
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createdirAndFile(File file) throws IOException {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		file.createNewFile();
	}
	
	/**
	 * 删除指定文件
	 * @param fileLocation
	 */
	public static void removeFile(String fileLocation) {
		try {
			File file = new File(fileLocation);
			if (file.exists())
				file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getClassPath() {
		String path = FileUtil.class.getClassLoader().getResource("/log4j.xml").getPath();
		//webapps/siling-web/WEB-INF/classes/log4j.xml
		return path.substring(0, path.lastIndexOf("/"));
	}
	
	public static String getClassPath(String url) {
		return FileUtil.class.getClassLoader().getResource(url).getPath();
	}
	
	public static void main(String[] args) {
		// writeFile("E:\\test\\ll.txt", "t");
		// removeFile("E:\\log\\resin-books\\words\\access.log");
		//String s = readFile("C:\\Users\\Administrator\\.m2\\settings.xml", "UTF-8");
		//System.out.println(s);
	}
}
