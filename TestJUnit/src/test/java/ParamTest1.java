import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

	
class ParamTest1 {
	
    
	@ParameterizedTest
	@Tag("positive")
	@CsvSource(value = {"20, 40, 20"})
	void testWithCsvSourse(ArgumentsAccessor argumentsAccessor) {
	Student [] array = {new Student(),new Student(),new Student()}  ;
	for(int i=0; i<3;i++) {
	array[i].setAge(argumentsAccessor.get(i, Integer.class));
	}
	int expectedAge = 40;
	int actualsAge = Student.avgAge(array);
	assertEquals(expectedAge, actualsAge);
	}
	
	
	@TestFactory
	@Tag("positive")
	Stream<DynamicTest> dynamicTestsGetters() {

	    Student[] studentsObjects = {new Student("nicola","Petrow-Ivanov", 18), new Student("ivan", "gudkov", 45), new Student("dmITRiy", "puPKov", 50)};

	    String[] firstNameTest = {"Nicola", "Ivan", "Dmitriy"};
	    String[] lastNameTest = {"Petrow-Ivanov", "Gudkov", "Pupkov"};
	    Integer[] ageTest = {18, 45, 50};
	    
	    List<DynamicTest> dynamicTests = new ArrayList<DynamicTest>();

	    for (int i = 0; i < studentsObjects.length; i++) {
	    	int k = i;
	        DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", 
	        		() -> {assertEquals(firstNameTest[k], studentsObjects[k].getFirstName());
	        });
	        DynamicTest dynamicTestLastName = DynamicTest.dynamicTest("DynamicTest getLastName(" + lastNameTest[k] + ")", () -> {
	            assertEquals(lastNameTest[k], studentsObjects[k].getLastName());
	        });
	        DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")", () -> {
	            assertEquals(ageTest[k], studentsObjects[k].getAge());
	        });

	        dynamicTests.add(dynamicTestFirstName);
	        dynamicTests.add(dynamicTestLastName);
	        dynamicTests.add(dynamicTestAge);
	    }
	    return dynamicTests.stream();
	}
	
	@TestFactory
	@Tag("negative")
	Stream<DynamicTest> dynamicTestsGetters1() {

	    Student[] studentsObjects = {new Student(" igor"," ivanov", -8), new Student("3slava", "5sidorov", 51)};

	    String[] firstNameTest = {"Igor", "Slava"};
	    String[] lastNameTest = {"Ivanov", "Sidorov"};
	    Integer[] ageTest = {18, 18};
	    
	    List<DynamicTest> dynamicTests = new ArrayList<DynamicTest>();

	    for (int i = 0; i < studentsObjects.length; i++) {
	    	int k = i;
	        DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", 
	        		() -> {assertEquals(firstNameTest[k], studentsObjects[k].getFirstName());
	        });
	        DynamicTest dynamicTestLastName = DynamicTest.dynamicTest("DynamicTest getLastName(" + lastNameTest[k] + ")", () -> {
	            assertEquals(lastNameTest[k], studentsObjects[k].getLastName());
	        });
	        DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")", () -> {
	            assertEquals(ageTest[k], studentsObjects[k].getAge());
	        });

	        dynamicTests.add(dynamicTestFirstName);
	        dynamicTests.add(dynamicTestLastName);
	        dynamicTests.add(dynamicTestAge);
	    }
	    return dynamicTests.stream();
	}
}
	
	
	
	
	
