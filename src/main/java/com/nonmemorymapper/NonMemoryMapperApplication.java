package com.nonmemorymapper;

import com.nonmemorymapper.model.domain.ECalculator;
import com.nonmemorymapper.utils.CustomMap;
import com.nonmemorymapper.utils.LazyValue;
import com.nonmemorymapper.utils.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class NonMemoryMapperApplication {

	static Map<ECalculator, LazyValue> map = new CustomMap<>();

	private static void mapperCalculate(int value1, int value2){
		map.put(ECalculator.ADD, new LazyValue(() -> addValueMap(value1, value2)));
		map.put(ECalculator.SUBTRACT, new LazyValue(() -> subtractValueMap(value1, value2)));
		map.put(ECalculator.MULTIPLY, new LazyValue(() -> multiplyValueMap(value1, value2)));
		map.put(ECalculator.DIVIDE, new LazyValue(() -> divideValueMap(value1, value2)));
	}

	public static void main(String[] args) {
		SpringApplication.run(NonMemoryMapperApplication.class, args);

		mapperCalculate(5, 5);
		Value valor = map.get(ECalculator.SUBTRACT);

		System.out.println(valor.getValue());
	}

	private static String addValueMap(int value1, int value2){
		return String.valueOf(value1 + value2);
	}

	private static String subtractValueMap(int value1, int value2){
		return String.valueOf(value1 - value2);
	}

	private static String multiplyValueMap(int value1, int value2){
		return String.valueOf(value1 * value2);
	}

	private static String divideValueMap(int value1, int value2){
		return String.valueOf(value1 / value2);
	}
}
