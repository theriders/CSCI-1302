import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A person
 * @author Rohan Malik
 *
 */
public class Person implements Comparable<Person>,Serializable{

	private static final long serialVersionUID = 1L;
	
	private String first;
    private String last;
    private int id;
    private Date birth;

    /**
     * creates a person object
     * @param f first name
     * @param l last name
     * @param num id number
     * @param d date of birth
     */
    public Person(String f,String l,int num,Date d) {
        first = f;
        last = l;
        id = num;
        birth = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;

        return getId() == person.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
    	String date = new SimpleDateFormat("MM-dd-yyyy").format(birth);
    	String ID = String.format("%04d", id);
        return "" + ID + " " + first + " " + last + " " + date;
    }

    /**
     * returns first name
     * @return the first name
     */
    public String getFirst() {
        return first;
    }

    /**
     * sets first name
     * @param first to be set as the first name
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * returns the last name
     * @return last name
     */
    public String getLast() {
        return last;
    }

    /**
     * sets the last name
     * @param last last name to be set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * returns the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id
     * @param id id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the birthday
     * @return birthday
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * sets the birthday
     * @param birth Date to be set as the birthday
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int compareTo(Person a){
        return (id - a.getId());
    }
}
