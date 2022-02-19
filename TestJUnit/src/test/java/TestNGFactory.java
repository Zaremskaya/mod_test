
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGFactory {
 
	@Factory public Object[]  TestFactory() {
		return new Object [] {
				new FirstNameTest(), 
				new LastNameTest(), 
				new AgeTest(),
				new AgeAvgTest(),
				new MinAgeTest(),
				new MaxAgeTest(),
				new GetFullNameTest()};
	}
	}
class FirstNameTest {
@DataProvider (name="firstNamesProvider", parallel=true)
public Object[][] firstNamesProvider () {
	return new Object[][] {
		{"N", new Student("n","Petrow-Ivanov", 18)},
		{"Ivan", new Student("iVan", "gudKOv", 45)},
		{"Maria-Antuanetta", new Student("Maria-Antuanetta", "sidorova", 50)}
	};
}
	@Test (dataProvider="firstNamesProvider", threadPoolSize=5)
	public void firstName(String name, Student a) {
		Assert.assertEquals(name, a.getFirstName());
		long id = Thread.currentThread().getId();
		System.out.println("id тест-метода 1: " + id);
	}
}

class LastNameTest {

	@DataProvider (name="lastNameTest", parallel=true)
	public Object[][] lastNameTest () {
		return new Object[][] {
			{"Petrow-Ivanov", new Student("nicola","Petrow-Ivanov", 10)},
			{"G",new Student("iVan", "g", 45)},
			{"Sidorova", new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="lastNameTest", threadPoolSize=5)
		public void lastName(String surname, Student b) {
			Assert.assertEquals(surname, b.getLastName());
			long id = Thread.currentThread().getId();
			System.out.println("id тест-метода 2: " + id);
		}
	
}

class AgeTest {
	@DataProvider (name="ageTest", parallel=true)
	public Object[][] ageTest () {
		return new Object[][] {
			{18, new Student("nicola","Petrow-Ivanov", 10)},
			{45, new Student("iVan", "gudKOv", 45)},
			{50, new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="ageTest", threadPoolSize=5)
		public void age(int  age, Student c) {
			Assert.assertEquals(age, c.getAge());
			long id = Thread.currentThread().getId();
			System.out.println("id тест-метода 3: " + id);
		}
}
class AgeAvgTest {
	@DataProvider (name="ageAvgTest", parallel=true)
	public Object[][] ageAvgTest () {
		return new Object[][] {
            {26, new Student[] { new Student("Sergey", "Nasedkin", 20), new Student("Ivan", "Nesterov", 40),  new Student("Gleb", "Petrov", 20) }}
    };
	}
				
	@Test(dataProvider = "ageAvgTest")
    public void avgAgeTest(int expected, Student[] students) {
      assertEquals(expected, Student.avgAge(students));
      long id = Thread.currentThread().getId();
		System.out.println("id тест-метода 4: " + id);
    }
}
	class MinAgeTest {
		@DataProvider (name="minAgeTest", parallel=true)
		public Object[][] minAgeTest () {
			return new Object[][] {
	            {18, new Student[] { new Student("Sergey", "Nasedkin", 10), new Student("Ivan", "Nesterov", 40),  new Student("Gleb", "Petrov", 50) }}
	    };
		}
					
		@Test(dataProvider = "minAgeTest")
	    public void minAgeTest(int expected, Student[] students) {
	      assertEquals(expected, Student.minAge(students));
	      long id = Thread.currentThread().getId();
			System.out.println("id тест-метода 5: " + id);
	    }
	
}
	class MaxAgeTest {
		@DataProvider (name="maxAgeTest", parallel=true)
		public Object[][] maxAgeTest () {
			return new Object[][] {
	            {40, new Student[] { new Student("Sergey", "Nasedkin", 10), new Student("Ivan", "Nesterov", 40),  new Student("Gleb", "Petrov", 50) }}
	    };
		}
					
		@Test(dataProvider = "maxAgeTest")
	    public void maxAgeTest(int expected, Student[] students) {
	      assertEquals(expected, Student.maxAge(students));
	      long id = Thread.currentThread().getId();
			System.out.println("id тест-метода 6: " + id);
	    }
	}
	class GetFullNameTest {

		@DataProvider (name="getFulltNameTest", parallel=true)
		public Object[][] getFulltName () {
			return new Object[][] {
				{"Nicola Ivanov", new Student("nicola","Ivanov", 10)},
				{"Ivan Grib",new Student("iVan", "Grib", 45)},
				{"Maria Sidorova", new Student("Maria", "sidorova", 50)}
			};
		}
			@Test (dataProvider="getFulltNameTest", threadPoolSize=5)
			public void getFulltName(String fullname, Student b) {
				Assert.assertEquals(fullname, b.getFullName());
				long id = Thread.currentThread().getId();
				System.out.println("id тест-метода 7: " + id);
			}
		
	}



