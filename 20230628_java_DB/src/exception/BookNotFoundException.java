package exception;

public class BookNotFoundException extends Exception{
	
	public BookNotFoundException(String msg) {
		super(msg);
	}

//throw new BookNotFoundException("해당하는 아이디 책이 없습니다. ")
}
