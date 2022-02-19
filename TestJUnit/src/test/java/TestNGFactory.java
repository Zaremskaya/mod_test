
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGFactory {
 
	@Factory public Object[]  TestFactory() {
		return new Object [] {
				new FirstNameTest(), 
				new LastNameTest(), 
				new AgeTest()};
	}
	
	}
class FirstNameTest {
@DataProvider (name="firstNamesProvider", parallel=true)
public Object[][] firstNamesProvider () {
	return new Object[][] {
		{"Nicola", new Student("nicola","Petrow-Ivanov", 18)},
		{"Ivan", new Student("iVan", "gudKOv", 45)},
		{"Maria-Antuanetta", new Student("Maria-Antuanetta", "sidorova", 50)}
	};
}
	@Test (dataProvider="firstNamesProvider", threadPoolSize=5)
	public void firstName(String name, Student a) {
		Assert.assertEquals(name, a.getFirstName());
		long id = Thread.currentThread().getId();
		System.out.println("id тест-метода1: " + id);
	}
}

class LastNameTest {

	@DataProvider (name="lastNameTest", parallel=true)
	public Object[][] lastNameTest () {
		return new Object[][] {
			{"Petrow-Ivanov", new Student("nicola","Petrow-Ivanov", 18)},
			{"Gudkov",new Student("iVan", "gudKOv", 45)},
			{"Sidorova", new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="lastNameTest", threadPoolSize=5)
		public void lastName(String surname, Student b) {
			Assert.assertEquals(surname, b.getLastName());
			long id = Thread.currentThread().getId();
			System.out.println("id тест-метода2: " + id);
		}
	
}

class AgeTest {
	@DataProvider (name="ageTest", parallel=true)
	public Object[][] ageTest () {
		return new Object[][] {
			{18, new Student("nicola","Petrow-Ivanov", 18)},
			{45, new Student("iVan", "gudKOv", 45)},
			{50, new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="ageTest", threadPoolSize=5)
		public void age(int  age, Student c) {
			Assert.assertEquals(age, c.getAge());
			long id = Thread.currentThread().getId();
			System.out.println("id тест-метода3: " + id);
		}
	
}
