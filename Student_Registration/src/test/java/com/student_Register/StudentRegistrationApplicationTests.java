package com.student_Register;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.context.Theme;

import com.student_Register.controller.RegisterController;
import com.student_Register.model.Registeration;
import com.student_Register.repository.RegisterRepo;

@SpringBootTest
class StudentRegistrationApplicationTests {

	calculatore theCalculatore = new calculatore();

	@Test
	void contextLoads() {
	}

	@Test
	void isShoulbeAddTwoNumbers() {

		int number1 = 20;
		int number2 = 30;

		int result = theCalculatore.add(number1, number2);

		assertThat(result).isEqualTo(50);

	}

	@Test
	void isShoubleSubtractTwoNumbers() {

		int a = 10;
		int b = 5;

		int result = theCalculatore.subtract(a, b);

		assertThat(result).isEqualTo(5);
	}
	
	
	@Test
	void isShouldMultipliedTwoNumbers() {
		
		int v = 10;
		int w = 5;
		
		int result = theCalculatore.Times(v, w);
		int expect = 50;
		assertThat(result).isEqualTo(expect);
	}
	
	
	@Test
	void isShouldDividTwoNumbers() {
		int number1 = 100;
		int number2 = 10;
		int result = theCalculatore.division(number1, number2);
		
		int expect = 10;
		assertThat(result).isEqualTo(expect);
		
	}

}

class calculatore {

	public int add(int num1, int num2) {

		return num1 + num2;

	}

	public int subtract(int x, int y) {

		return x - y;
	}

	public int Times(int num1, int num2) {

		return num1 * num2;
	}
	
	
	public int division(int number1, int numbertwo2) {
		
		return number1 / numbertwo2;
	}

}
