package model;

public class Comment {
	int comment_num;
	int product_num;
	String user_id;
	String user_comment;
	
	
	public Comment() {
		super();
	}


	public Comment(int product_num, String user_id, String user_comment) {
		super();
		this.comment_num = 0;
		this.product_num = product_num;
		this.user_id = user_id;
		this.user_comment = user_comment;
	}


	public Comment(int comment_num, int product_num, String user_id, String user_comment) {
		super();
		this.comment_num = comment_num;
		this.product_num = product_num;
		this.user_id = user_id;
		this.user_comment = user_comment;
	}


	public int getComment_num() {
		return comment_num;
	}


	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}


	public int getProduct_num() {
		return product_num;
	}


	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_comment() {
		return user_comment;
	}


	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}


	@Override
	public String toString() {
		return "Comment [comment_num=" + comment_num + ", product_num=" + product_num + ", user_id=" + user_id
				+ ", user_comment=" + user_comment + "]";
	}
	
	
}
