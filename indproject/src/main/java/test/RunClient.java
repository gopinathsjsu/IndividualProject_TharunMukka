package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RunClient {

	public static void main(String[] args) {
		args= new String[] { "hi","hello","hey" };
		Arrays.stream(args).forEach(System.out::println);
		SpringApplication.run(RunClient.class, args);
	}

}
