import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
/**
 * Demo of Project 4
 * @author Rohan Malik
 *
 */
public class Demo {

	/**
	 * Runs the Project 4 test
	 * @param args
	 */
	public static void main(String[] args) {
		//make some Date objects
		Calendar cal = Calendar.getInstance();
	    cal.set(1990, 0, 25);
	    Date d1 = cal.getTime();
	    cal.set(2005, 1, 5);
	    Date d2 = cal.getTime();
	    
	    //make some Person
	    Person p1 = new Person("Joe","Smith",111,d1);
	    Person p2 = new Person("Person","Test",1111,d1);
	    Person p3 = new Person("Person","Two",1112,d1);
	    Person p4 = new Person("Person","Three",1150,d1);
	    
	    //make some Student
	    Student s1 = new Student("Student","One",1250,d2,"UGA");
	    Student s2 = new Student("Student","Two",1120,d2,"Art");
	    Student s3 = new Student("Student","Three",1300,d2,"Place");
	    Student s4 = new Student("Student","Four",999,d2,"Another Place");
	    
	    //make some duplicates
	    Person b1 = new Person("Joe","Dupe",111,d1);
	    Student b2 = new Student(p3,"Sci");
	    Student b3 = new Student(p1,"chem");
	    b3.setId(1300);
	    
	    SortedDblList<Person> one = new SortedDblList<Person>();
	    
	    System.out.println("add some people");
	    one.add(p1);
	    one.add(p2);
	    one.add(p3);
	    one.add(p4);
	    one.printList();
	    System.out.println();
	    System.out.println("test out get(2)");
	    System.out.println(one.get(2));
	    System.out.println();
	    System.out.println("test out remove(one.get(2))");
	    //System.out.println(one.get(1).equals(p2));
	    one.remove(one.get(2));
	    one.printList();
	    System.out.println("Empty: " + one.isEmpty());
	    System.out.println("make new list and check if it is empty");
	    one = new SortedDblList<Person>();
	    System.out.println("Empty: " + one.isEmpty());
	    
	    System.out.println("create a list of person and one of student and merge them");
	    SortedDblList<Student> two = new SortedDblList<Student>();
	    one.add(p1);
	    one.add(p2);
	    one.add(p3);
	    one.add(p4);
	    one.printList();
	    System.out.println();
	    two.add(s1);
	    two.add(s2);
	    two.add(s3);
	    two.add(s4);
	    two.printList();
	    
	    System.out.println("new merged list");
	    SortedDblList<Person> merge = one.merge(two);
	    merge.printList();
	    System.out.println();
	    System.out.println("test isPrefix (Integers)");
	    SortedDblList<Integer> intone = new SortedDblList<Integer>();
	    SortedDblList<Integer> inttwo = new SortedDblList<Integer>();
	    intone.add(8);
	    intone.add(4);
	    intone.add(2);
	    intone.printList();
	    System.out.println();
	    inttwo.add(8);
	    inttwo.add(4);
	    inttwo.add(2);
	    inttwo.add(11);
	    inttwo.add(10);
	    inttwo.printList();
	    System.out.println();
	    System.out.println("test if first list is prefix to second and then vice versa");
	    System.out.println(intone.isPrefix(inttwo));
	    System.out.println(inttwo.isPrefix(intone));
	    System.out.println("test index of in both integer lists");
	    intone.printList();
	    System.out.println("index of 4: " + intone.indexOf(4));
	    System.out.println();
	    inttwo.printList();
	    System.out.println("index of 10: " + inttwo.indexOf(10));
	    System.out.println();
	    System.out.println("serialize the merged list from before");
	    System.out.println();
	    merge.printList();
	    System.out.println();
	    
	    try {
	         FileOutputStream fileOut =
	         new FileOutputStream("mergelist.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(merge);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in mergelist.ser");
	         System.out.println();
	         System.out.println();
	      }catch(IOException i) {
	         i.printStackTrace();
	     }
	    
	    System.out.println("deserialize the merged list into a new object");
	    SortedDblList<Person> newmerge = new SortedDblList<Person>();
	    try {
	         FileInputStream fileIn = new FileInputStream("mergelist.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         newmerge = (SortedDblList<Person>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("SortedDblList class not found");
	         c.printStackTrace();
	         return;
	    }
	    System.out.println();
	    newmerge.printList();


	}

}
