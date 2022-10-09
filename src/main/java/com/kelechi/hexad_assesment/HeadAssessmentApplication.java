package com.kelechi.hexad_assesment;
import com.kelechi.hexad_assesment.models.Book;
import com.kelechi.hexad_assesment.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HeadAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeadAssessmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(BookService bookService) {
		return (args) -> {
			bookService.addBook(new Book(1L, "Fools Die", "Mario Puzo", 2));
			bookService.addBook(new Book(2L, "Rich dad poor dad", "Robert Kiyosaki", 1));
			bookService.addBook(new Book(3L, "Gifted Hands", "Ben Carson", 3));
		};
	}

}
