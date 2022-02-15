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
@DataProvider (name="firstNamesProvider")
public Object[][] firstNamesProvider () {
	return new Object[][] {
		{"Nicola", new Student("nicola","Petrow-Ivanov", 18)},
		{"Ivan", new Student("iVan", "gudKOv", 45)},
		{"Maria-Antuanetta", new Student("Maria-Antuanetta", "sidorova", 50)}
	};
}
	@Test (dataProvider="firstNamesProvider")
	public void firstName(String name, Student a) {
		Assert.assertEquals(name, a.getFirstName());
	}
}

class LastNameTest {

	@DataProvider (name="lastNameTest")
	public Object[][] lastNameTest () {
		return new Object[][] {
			{"Petrow-Ivanov", new Student("nicola","Petrow-Ivanov", 18)},
			{"Gudkov",new Student("iVan", "gudKOv", 45)},
			{"Sidorova", new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="lastNameTest")
		public void lastName(String surname, Student b) {
			Assert.assertEquals(surname, b.getLastName());
		}
	
}

class AgeTest {
	@DataProvider (name="ageTest")
	public Object[][] ageTest () {
		return new Object[][] {
			{18, new Student("nicola","Petrow-Ivanov", 18)},
			{45, new Student("iVan", "gudKOv", 45)},
			{50, new Student("Maria-Antuanetta", "sidorova", 50)}
		};
	}
		@Test (dataProvider="ageTest")
		public void age(int  age, Student c) {
			Assert.assertEquals(age, c.getAge());
		}
	
}
