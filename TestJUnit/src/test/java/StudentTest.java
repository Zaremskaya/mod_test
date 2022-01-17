
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


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
			String fio = "Петров-Иванов";
			s.setLastName(fio);
			String expectedName = "Петров-Иванов";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testLastName1() {
			String fio = "петров";
			s.setLastName(fio);
			String expectedName = "Петров";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testLastName2() {
			String fio = "пеТРов";
			s.setLastName(fio);
			String expectedName = "Петров";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("negative")
	  void testLastName3() {
			String fio = " пеТРов";
			s.setLastName(fio);
			String expectedName = " Петров";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("negative")
	  void testLastName4() {
			String fio = "3пеТРов";
			s.setLastName(fio);
			String expectedName = "3Петров";
			String actualsName=s.getLastName();
		    assertEquals(expectedName, actualsName);	
		  }
	  	  
	  @Test
	  @Tag("positive")
	  void testFirstName() {
			String name = "валентина";
			s.setFirstName(name);
			String expectedName = "Валентина";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testFirstName1() {
			String name = "валеНТина";
			s.setFirstName(name);
			String expectedName = "Валентина";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
	  
	  @Test
	  @Tag("positive")
	  void testFirstName2() {
			String name = "Алла-Виктория";
			s.setFirstName(name);
			String expectedName = "Алла-Виктория";
			String actualsName=s.getFirstName();
		    assertEquals(expectedName, actualsName);	
		  }
}