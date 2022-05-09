package StudyDay1;
import java.io.*;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		read();
	}
	public static void read() {
		File file = new File("D:\\Test.txt");
		try {
			InputStream in = new FileInputStream(file);
			int len=0;
			byte[] b = new byte[1024];
			StringBuffer buffer = new StringBuffer();
			while ((len = in.read(b))!=-1) {
				String str = new String(b,0,len,"UTF-8");
				buffer.append(str);
				System.out.println(buffer.toString());
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public static void rename() {
		File src = new File("IO.jpg");
		File dst = new File("IO_2.jpg");
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b))!=-1) {
				out.write(b,0,len);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void reaname2() {
		File src = new File("IO.jpg");
		File dst = new File("IO_2.jpg");
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			int len = 0;
			byte[] b = new byte[1024];
			while((len=in.read(b))!=-1) {
				out.write(b,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out!=null) {
				try {
					out.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			if(in!=null) {
				try {
					in.close();
				}
			 catch (IOException e) {
				e.printStackTrace();
			 	}
			}
		}
	}
}
