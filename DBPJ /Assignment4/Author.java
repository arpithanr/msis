//	Author class
class Author{

	private String name;
	private String email;
	private char gender;

	//default constructor
	Author(){}

	Author(String name, String email, char gender){
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	//to string method
	@Override
	public String toString()
	{
		return "\n----------"+"\nName:" + name + "\nEmail:" + email + "\nGender:" + gender ;
	}
}