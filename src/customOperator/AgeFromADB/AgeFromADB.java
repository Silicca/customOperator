package customOperator.AgeFromADB;

/**
 * @author Floriane
 * @version 1
 * Class that prints (yes because I don't know how it's done on hts,
 * so to test my code: print is not bad) the age according to
 * the date of administration of the test and the date of birth.
 * My code would need tests and asserts to avoid unexpected errors and
 * to be serious (the tests are so fun to do :)) but it will be fine like
 * that for now.
 * Ow ! And There is no getter and setter nor toString blablabla...
 */
public class AgeFromADB {
	// Dates format : DD/MM/YYYY
	private String administrationDate;
	private String birthDate;
	private Integer administrationDay;
	private float administrationMonth;
	private Integer administrationYear;
	private Integer birthDay;
	private float birthMonth;
	private Integer birthYear;
	private Integer ageDays;
	private float ageMonth;
	private Integer ageYears;

	/**
	 * The constructor
	 * @param R : The string corresponding to the date of administration
	 * @param R2 : The string corresponding to the date of birth
	 */
	public AgeFromADB(String R, String R2) {
		this.administrationDate = R;
		this.birthDate = R2;
		
		this.administrationDay = 1;
		this.administrationMonth = 1;
		this.administrationYear = 0;
		
		this.birthDay = 1;
		this.birthMonth = 1;
		this.birthYear = 0;
		
		this.ageDays = 0;
		this.ageMonth = 0;
		this.ageYears = 0;
	}
	
	/**
	 * Method that transforms the strings dates in Integers and floats
	 */
	public void stringDateInInteger() {
		//split() can work this "." ?
		//split the 2 dates with the "/" separator ("." is more used by french but ok)
		String[] administrationDateParts = this.administrationDate.split("/");
		String[] birthDateParts = this.birthDate.split("/");
		
		//parsing in Integer of each parts of the date of administration : day, month and year
		this.administrationDay = Integer.parseInt(administrationDateParts[0]);
		this.administrationMonth = Integer.parseInt(administrationDateParts[1]);
		this.administrationYear = Integer.parseInt(administrationDateParts[2]);
		
		//parsing in Integer of each parts of the date of birth : day, month and year
		this.birthDay = Integer.parseInt(birthDateParts[0]);
		this.birthMonth = Integer.parseInt(birthDateParts[1]);
		this.birthYear = Integer.parseInt(birthDateParts[2]);
	}
	
	/**
	 * Method that calculates the age (years and months, days are not important :
	 * bye bye leap years)
	 */
	public void age() {
		//substraction of each parts of the dates
		this.ageYears = this.administrationYear - this.birthYear;
		this.ageMonth = this.administrationMonth - this.birthMonth;
		this.ageDays = this.administrationDay - this.birthDay;
		//if the number of days are less than 0 (so negative, thx captain obvious)
		if(this.ageDays < 0) { //days are just a little important
			this.ageMonth -= 1; //we can remove one month to the total
		//if the number of months are less than 0 (so... no I stop)
		} if(this.ageMonth < 0) {
			this.ageYears -= 1; //we can remove one year to the total
			this.ageMonth = Math.abs(this.ageMonth);
			this.ageMonth = 12 - this.ageMonth; //and take 12 minus the absolute value of months
		} if(this.ageMonth < 10) { //don't know if this "if" and "else" are useful
			this.ageMonth /= 10;
		} else {
			this.ageMonth /= 100;
		}
		
	}
	
	/**
	 * Method that return the result age with years and months
	 * @return the age : format float years.months
	 */
	public float result() {
		return this.ageMonth + this.ageYears;
	}
	
	/**
	 * @param args : Date of administration & Date of birth with format DD/MM/YYYY
	 */
	public static void main(String[] args){
	      AgeFromADB happyBirthday = new AgeFromADB(args[0],args[1]);
	      happyBirthday.stringDateInInteger();
	      happyBirthday.age();
	      System.out.println(happyBirthday.result());
	}
}
