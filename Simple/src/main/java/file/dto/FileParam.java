package file.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileParam {

	private String title;
	
	private MultipartFile file;
	
	private String data1;
	private String data2;
	private String data3;
	
	public FileParam() {}

	public FileParam(String title, MultipartFile file, String data1, String data2, String data3) {
		super();
		this.title = title;
		this.file = file;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

	@Override
	public String toString() {
		return "FileParam [title=" + title + ", file=" + file + ", data1=" + data1 + ", data2=" + data2 + ", data3="
				+ data3 + "]";
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}
	
}
