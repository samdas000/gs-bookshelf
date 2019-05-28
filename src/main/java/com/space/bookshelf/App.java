package com.space.bookshelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
 	
@ComponentScan({"com.space.bookshelf.services.book","com.space.bookshelf.services.donor","com.space.bookshelf.services.beneficiary"})
@SpringBootApplication
public class App 
{
    public static void main( String[] args)
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
}
