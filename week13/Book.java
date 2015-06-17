import java.io.Serializable;
//��Ϲ�ȣ ���� ���� ���ǻ� ������ ī�װ� ����� ���� ���ǿ��� ISBN �޸�
public class Book implements Serializable {// �ø���(����)<-->pararell(����)��ų �� �ִ� �������̽��� �ִٴ� �ǹ�.
	//���� ������ ��򰡿� ���۽�ų �� �ʿ��ϴ�. ������ �׳� �Ϸķ� �� ���� �� �ִٴ� �ǹ�.
	private String title; 		//����
	private String author; // ����
	private String publisher;	//���ǻ�
	private String date;		 //������
	private String category;	//ī�װ�
	private boolean sale; 		//���ǿ���
	private String date_reg;	//�����
	private String price;			// ����
	private String isbn; 		// ISBN
	private String memo;		//�޸� >> ���� ������
	
	public Book(String isbn, String title, String author, String publisher, String date, String category, boolean sale, String date_reg, String price, String memo){//������Ŭ������ ���� ���� �׳� ������
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.category = category;
		this.sale = sale;
		this.date_reg = date_reg;
		this.price = price;
		this.isbn = isbn;
		this.memo = memo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public String getDate(){
		return date;
	}
	
	public boolean getSale(){
		return sale;
	}

	public String getDate_reg(){
		return date_reg;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getPrice(){
		return price;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setTitle(String title){
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public void setSale(boolean sale) {
		this.sale = sale;
	}

	public void setDate_reg(String date_reg) {
		this.date_reg = date_reg;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setMEMO(String memo) {
		this.memo = memo;
	}
	
	public String toString(){// ������Ʈ�� �޼ҵ� toString�̹Ƿ� �������̵� ����
		return getIsbn() + "," + getTitle() + "," + getAuthor() + ","+ getPublisher() + "," + getDate() +  "," + getCategory() + ","  + getSale() + "," + getDate_reg() + "," +  getPrice() + ","  + getMemo();
	}


}
