package com.test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstClass {
	
	public static void main(String[] args) {
		System.out.println("Hello Java World");
		
		String name = "Helloworld";
//		String result[]=name.split("");
//		System.out.println( Arrays.toString(result));
		
		Map<String, List<String>> map= Arrays.stream(name.split("")).collect(Collectors.groupingBy(s->s));
		Map<String, Long> map1=Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(map);
		System.out.println(map1);
		
		for(String s:map1.keySet()) {
			if(map1.get(s)>1) {
				System.out.print(s+" ");
			}
		
		}
		System.out.println();
		
		List<String> duplicateEle= Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		
		System.out.println(duplicateEle);
	}

}
