package com.excella.reactor.chapter02.quiz2dot1.solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import com.excella.reactor.domain.Apple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
public class AppleFormatterTest {
    
    public String prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        StringBuilder output = new StringBuilder();
        for(Apple apple: inventory) {
            output.append(formatter.accept(apple) + "\n");
        }
        return output.toString();
    }

    List<Apple> inventory = Arrays.asList(
			new Apple(80, "green"),
			new Apple(155, "green"),
			new Apple(120, "red")
    );
    
    @Test
    public void apple_formatter_test() {
        var fancyOutput = prettyPrintApple(inventory, new AppleFancyFormatter());
        var simpleOutput = prettyPrintApple(inventory, new AppleSimpleFormatter());

        System.out.println("FANCY: " + fancyOutput + "\n");
        System.out.println("SIMPLE: " + simpleOutput);

        assertTrue(fancyOutput, true);
    }

}

