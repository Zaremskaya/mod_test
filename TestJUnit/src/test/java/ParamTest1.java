import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
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
}