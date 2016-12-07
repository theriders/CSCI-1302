import java.util.Date;
/**
 * A college student
 * @author Rohan Malik
 *
 */
public class Student extends Person {

	private static final long serialVersionUID = 1L;
	
	private String college;
	
	/**
	 * creates a student object
	 * @param f first name
	 * @param l last name
	 * @param num id number
	 * @param d the date of birth
	 * @param c college
	 */
	public Student(String f, String l, int num, Date d,String c) {
		super(f, l, num, d);
		college = c;
	}
	
	/**
	 * creates a student object
	 * @param person a person
	 * @param college college
	 */
	public Student(Person person,String college){
		super(person.getFirst(),person.getLast(),person.getId(),person.getBirth());
		this.college = college;
	}
	
	/**
	 * returns college
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	
	/**
	 * sets the college
	 * @param college string to be set as the college
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * returns a string representation of a student
	 * @return string representation of a student
	 */
	public String toString() {
		return super.toString() + " [" + college + "]";
	}
	

}
