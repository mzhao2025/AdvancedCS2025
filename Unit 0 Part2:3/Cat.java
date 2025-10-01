public class Cat { // "Public" should be lowercase
	private String name;
	private String breed;
	private boolean isHungry;
	private int livesRemaining;
	
	// 2-Parameter Constructor
	public Cat(String name, String breed) { // "cat" should be "Cat" because the constructor name must match the class and file name, also missing a parameter "breed" as used in the tester class
		this.name = name; // the first "name" should be "this.name" to refer to the instance variable and not be confused with the parameter "name"
		this.breed = breed; // the first "breed" should be "this.breed" to refer to the instance variable and not be confused with the parameter "breed"
		this.isHungry = true; // yes should be "true"
		livesRemaining = 9;
	}

	public String getName() {
		return name; // cannot return a String in a void method, should either change return type to String or remove return statement, perhaps replace with a print statement
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() { // added method to get breed
		return breed; 
	}

	public void setBreed(String breed) { // added method to set breed
		this.breed = breed;
	}

	public boolean getIsHungry(){ // make method name "getIsHungry" (camelCase) to match previous naming conventions
		return isHungry; // cannot return a boolean in a void method, should either change return type to boolean or remove return statement, perhaps replace with a print statement
	}

	public void feed() { // cannot return nothing in a boolean return-type method, should return a boolean or change return type to void
		this.isHungry = false;
	}

	public boolean equals(Cat other) { // "Cat" should be "Cats" as to match the class/object name
		return this.name.equals(other.getName()) && this.breed.equals(other.getBreed()) // replace "==" with "equals" for String comparison
			&& this.livesRemaining == other.livesRemaining; // should use "==" for comparison, not "=" which assings an operator
	}

	public String toString() {
		return (name + " is of breed " + breed + " and has " + livesRemaining + " lives remaining."); // use a return statement instead of print statement
	}
}