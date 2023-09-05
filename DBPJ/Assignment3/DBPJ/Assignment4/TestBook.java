//TestBook class
public class TestBook{

	public static void main(String[] args) {
		Author auth = new Author("Savi Sharma", "savisharma@gmail.com",'F');
		Book b1 = new Book("Everyon has a Story", auth, 1000);

		//test getter methods
		System.out.println("\nName: " + b1.getName() + "\nAuthor" + b1.getAuthor().toString() + "\nPrice" + b1.getPrice());

		//test setter methods
			b1.setPrice(2000);
			b1.setQty(10);

			//toString after setting fields
			System.out.println(b1.toString());
			//System.out.println(b1);
	}
	
}