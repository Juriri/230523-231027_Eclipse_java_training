package board;

import java.util.List;

public interface Service {
	void write(Board b, String login_Id);

	Board getArticle(int num);

	List getArticles();

	boolean editArticle(Board b);

	void delArticle(int num);
}
