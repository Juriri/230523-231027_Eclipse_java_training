package step11;

public class Engineer {
	private String name;
	private Notebook notebook;

	public Engineer(String name, Notebook notebook) {
		this.name = name;
		this.notebook = notebook;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Notebook getNotebook() {
		return notebook;
	}
	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	
}
