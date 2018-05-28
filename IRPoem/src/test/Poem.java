package test;

public class Poem {
	private int id;
	private String name,destiny,author,content;
	public Poem(int id,String name,String destiny,String author,String content){
		this.id = id;
		this.name = name;
		this.destiny = destiny;
		this.author = author;
		this.content = content;
		
	}
	public Poem(){
		
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestiny() {
		return destiny;
	}

	public  void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

