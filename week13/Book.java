import java.io.Serializable;
//등록번호 제목 저자 출판사 출판일 카테고리 등록일 가격 절판여부 ISBN 메모
public class Book implements Serializable {// 시리얼(직렬)<-->pararell(병렬)시킬 수 있는 인터페이스가 있다는 의미.
	//직렬 병렬은 어딘가에 전송시킬 때 필요하다. 직렬은 그냥 일렬로 줄 세울 수 있다는 의미.
	private String title; 		//제목
	private String author; // 저자
	private String publisher;	//출판사
	private String date;		 //출판일
	private String category;	//카테고리
	private boolean sale; 		//절판여부
	private String date_reg;	//등록일
	private String price;			// 가격
	private String isbn; 		// ISBN
	private String memo;		//메모 >> 내부 생성값
	
	public Book(String isbn, String title, String author, String publisher, String date, String category, boolean sale, String date_reg, String price, String memo){//데이터클래스라 메인 없이 그냥 생성자
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
	
	public String toString(){// 오브젝트의 메소드 toString이므로 오버라이드 가능
		return getIsbn() + "," + getTitle() + "," + getAuthor() + ","+ getPublisher() + "," + getDate() +  "," + getCategory() + ","  + getSale() + "," + getDate_reg() + "," +  getPrice() + ","  + getMemo();
	}


}
