//Book class
class Book{
	private String name;
	private Author author;
	private double price;
	private int qty;

	//constructors
	Book(){}

	public Book(String name, Author author, double price){
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Book (String name, Author author, double price, int qty) { 
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}

	//getter method for name
	public String getName(){
		return name;
	}

	//getter method for author
	public Author getAuthor(){
		return author;
	}

	//getter method for price
	public double getPrice(){
		return price;
	}

	//setter method for price
	public void setPrice(double price){
		this.price = price;
	}

	//getter method for quantity
	public int getQty(){
		return qty;
	}

	//setter method for quantity
	public void setQty(int qty){
		this.qty = qty;
	}

	//toString method
	@Override
	public String toString()
	{
		return "\n----------"+"\nBook[Name:" + name + "\nAuthor[Name:"+ author + "]\nPrice:"+price + "\nQuantity:" + qty;

	}
}