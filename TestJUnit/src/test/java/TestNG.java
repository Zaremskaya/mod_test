import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import online_tusur.unit_online_tusur.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.ArrayList;

import org.testng.annotations.*;

public class TestNG {
		
	@DataProvider(name = "students")
    public Object[][] parameterProvider() {
      return new Object[][] {
              {26, new Student[] { new Student("Sergey", "Nasedkin", 20), new Student("Ivan", "Nesterov", 40),  new Student("Gleb", "Petrov", 20) }}
      };
    }
	@Test(dataProvider = "students")
    public void avgAgeTest(int expected, Student[] students) {
      assertEquals(expected, Student.avgAge(students));
    }
	
	@Test
	 @Parameters({"s1", "s2", "s3"})
	 public void TestNG_AgeAvg(@Optional("0")int s1, @Optional("0")int s2, @Optional("0")int s3) {
	  Student p = new Student();
	  Student c = new Student();
	  Student d = new Student();
	 
	  Student [] array = {p,c,d};
	   p.setAge(s1);
	  c.setAge(s2);
	  d.setAge(s3);
	  
	  int expectedAge = 26;
	  int actualsAge = Student.avgAge(array);
	  
	  assertEquals(expectedAge, actualsAge);
	 }
	}
