package by.artempvn.les04t01.service;

public class NumberService {
	private static final int START_NUMBER = 2;

	public boolean isPrimeNumber(int number) {
		boolean isPrime = true;
		if (number > 1) {
			int i = START_NUMBER;
			while (isPrime && i < number) {
				if (number % i == 0) {
					isPrime = false;
				} else {
					i++;
				}
			}
		} else {
			isPrime = false;
		}
		return isPrime;
	}

	public boolean isFibonacciNumber(int number) {
		boolean isFibonacciNumber = false;
		int previousNumber1 = 0;
		int previousNumber2 = 1;
		int actualNumber = 0;
		if (number != 0) {
			while (!isFibonacciNumber && actualNumber <= number) {
				actualNumber = previousNumber1 + previousNumber2;
				if (actualNumber == number) {
					isFibonacciNumber = true;
				} else {
					previousNumber1 = previousNumber2;
					previousNumber2 = actualNumber;
				}
			}
		} else {
			isFibonacciNumber = true;
		}
		return isFibonacciNumber;
	}

	public boolean hasNumberUniqueDigits(int number) {
		boolean hasNumberUniqueDigits = true;
		char[] charDigits = Integer.toString(number).toCharArray();
		int i = 0;
		while (hasNumberUniqueDigits && i < charDigits.length - 1) {
			for (int j = i + 1; j < charDigits.length; j++) {
				if (charDigits[i] == charDigits[j]) {
					hasNumberUniqueDigits = false;
				}
			}
			i++;
		}
		return hasNumberUniqueDigits;
	}

	public boolean hasNumberRequiredLength(int number, int length) {
		return (Integer.toString(number).length() == length);
	}

	public boolean isNumberSomeCondition(int number, boolean isFibonacci,
			boolean isPrime, boolean isUniqueDigits, int numberOfDigits) {
		boolean isCompareCondition = false;
		if (isFibonacci || isPrime || isUniqueDigits || numberOfDigits > 0) {
			boolean conditionFibonacci = isFibonacci ? isFibonacciNumber(number)
					: true;
			boolean conditionPrime = isPrime ? isPrimeNumber(number) : true;
			boolean conditionUniqueDigits = isUniqueDigits
					? hasNumberUniqueDigits(number)
					: true;
			boolean conditionNumberOfDigits = numberOfDigits > 0
					? hasNumberRequiredLength(number, numberOfDigits)
					: true;
			isCompareCondition = (conditionFibonacci && conditionPrime
					&& conditionUniqueDigits && conditionNumberOfDigits);
		}
		return isCompareCondition;
	}
}