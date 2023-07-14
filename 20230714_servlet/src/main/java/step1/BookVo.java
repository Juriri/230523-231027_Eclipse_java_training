package step1;

public class BookVo {
	private int num;
	private String author;
	private String title;
	private String publisher;
	private String content;
	
	public BookVo(int num, String author, String title, String publisher, String content) {
		super();
		this.num = num;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.content = content;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "BookVo [num=" + num + ", author=" + author + ", title=" + title + ", publisher=" + publisher
				+ ", content=" + content + "]";
	}
	
	
}
