
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class StudentTest {
	
	private static final Class<?>[] Age = null;
	private Student s = new Student();	 	   
   
      @Test
	  @Order(2)
	  @Tag("positive")
	  void testAge18() {
		int age = 18;
		s.setAge(age);
	    int expectedAge = 18;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }
	  @Test
	  @Order(1)
	  @Tag("positive")
	  void testAge45() {
		int age = 45;
		s.setAge(age);
	    int expectedAge = 45;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }
	  
	
	  @Test
	  @Tag("positive")
	  void testAge50() {
		int age = 50;
		s.setAge(age);
	    int expectedAge = 50;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }
	  
	  @Test
	  @Tag("negative")
	  void testAgeInvalidMinus8() {
		int age = -8;
		s.setAge(age);
		int expectedAge = 18;
	    int actualsAge=s.getAge(); 
	    assertEquals(expectedAge, actualsAge);
	  }
	 
	  @Test
	  @Tag("negative")
	  void testAgeInvalid51() {
		int age = 51;
		s.setAge(age);
		int expectedAge = 18;
	    int actualsAge=s.getAge(); 
	    assertEquals(expectedAge, actualsAge);
	  }
	  
	  @Test
	  @Tag("positive")
	  void testLastName() {
			String fio = "������-������";
			s.setLastName(fio);
			String expectedName = "������-������";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testLastName1() {
			String fio = "������";
			s.setLastName(fio);
			String expectedName = "������";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testLastName2() {
			String fio = "������";
			s.setLastName(fio);
			String expectedName = "������";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("negative")
	  void testLastName3() {
			String fio = " ������";
			s.setLastName(fio);
			String expectedName = " ������";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("negative")
	  void testLastName4() {
			String fio = "3������";
			s.setLastName(fio);
			String expectedName = "3������";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  	  
	  @Test
	  @Tag("positive")
	  void testFirstName() {
			String name = "���������";
			s.setFirstName(name);
			String expectedName = "���������";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testFirstName1() {
			String name = "���������";
			s.setFirstName(name);
			String expectedName = "���������";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testFirstName2() {
			String name = "����-��������";
			s.setFirstName(name);
			String expectedName = "����-��������";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
}