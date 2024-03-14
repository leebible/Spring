package kr.or.ddit.enumpkg;

import java.util.function.BiFunction;

public enum Operator {
	        PLUS("+", (num1, num2) -> num1 + num2),
	        MINUS("-", (num1, num2) -> num1 - num2),
	        MULTIPLY("*", (num1, num2) -> num1 * num2),
	        DIVIDE("/", (num1, num2) -> num1 / num2);

	        private String operator;
	        private BiFunction<Double, Double, Double> expression;

	        Operator(String operator, BiFunction<Double, Double, Double> expression) {
	            this.operator = operator;
	            this.expression = expression;
	        }

	        public double calculate(double num1, double num2) {
	            return this.expression.apply(num1, num2);
	        }
	        
	        //모르겠어서 블로그 찾아봤지만 할수 없엇음니다..
}




