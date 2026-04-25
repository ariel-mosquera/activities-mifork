
package es.uvigo.esei.aed1.activity5;

import static java.util.Objects.requireNonNull;

import es.uvigo.esei.aed1.activity6.implementation.EmptyException;
import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Activity5 {

  // Exercise 1
  public static String reverseWords(String text) {

    LinkedStack<Character> stack = new LinkedStack<>();
    StringBuilder reverse = new StringBuilder();

    for (int i = 0; i < text.length(); i++)
      stack.push(text.charAt(i));

    while (!stack.isEmpty())
      reverse.append(stack.pop());

    return reverse.toString();
  }

  // Exercise 2 i
  public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {
    requireNonNull(stack1);
    requireNonNull(stack2);

    if (stack1.size() != stack2.size())
      return false;

    boolean areEqual = true;
    Stack<T> auxStack1 = new LinkedStack<>();
    Stack<T> auxStack2 = new LinkedStack<>();

    while (!stack1.isEmpty()) {
      if (!stack1.top().equals(stack2.top()))
        areEqual = false;

      auxStack1.push(stack1.pop());
      auxStack2.push(stack2.pop());
    }

    while (!auxStack1.isEmpty()) {
      stack1.push(auxStack1.pop());
      stack2.push(auxStack2.pop());
    }

    return areEqual;
  }

  // Exercise 2 ii
  public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {
    requireNonNull(stack);

    Stack<T> copy = new LinkedStack<>();
    Stack<T> auxCopy = new LinkedStack<>();

    while (!stack.isEmpty())
      auxCopy.push(stack.pop());

    while (!auxCopy.isEmpty()) {
      stack.push(auxCopy.top());
      copy.push(auxCopy.pop());
    }

    return copy;
  }

  public static <T> Stack<T> copyRecursive(Stack<T> stack) throws NullPointerException {
    requireNonNull(stack);

    if (stack.isEmpty())
      return new LinkedStack<T>();

    T top = stack.pop();
    Stack<T> result = copy(stack);
    stack.push(top);
    result.push(top);

    return result;
  }

  // Exercise 3
  public static String fromBase10ToBase2(int numberBase10) {
    if (numberBase10 == 0)
      return "0";

    Stack<Integer> remainderStack = new LinkedStack<>();

    while (numberBase10 != 0) {
      remainderStack.push(numberBase10 % 2);
      numberBase10 /= 2;
    }

    StringBuilder binario = new StringBuilder();

    while (!remainderStack.isEmpty())
      binario.append(remainderStack.pop());

    return binario.toString();
  }

  // Exercise 4
  public static int getNumDiamonds(String sand) {

    int size = sand.length();
    int counter = 0;
    Stack<Character> diamonds = new LinkedStack<>();

    for (int i = 0; i < size; i++) {
      if (sand.charAt(i) == '<')
        diamonds.push(sand.charAt(i));
      if (sand.charAt(i) == '>' && !diamonds.isEmpty()) {
        counter++;
        diamonds.pop();
      }
    }

    return counter;
  }

  // Exercise 5
  public static String codifyMessage(String message) {
    return null;
  }

  // Exercise 6
  public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {
    requireNonNull(stack);

    if (index <= 0 || index > stack.size())
      throw new IllegalArgumentException("this index is out of bounds");

    Stack<T> auxStack = new LinkedStack<>();
    int pos = 0;

    while (pos < index) {
      auxStack.push(stack.pop());
      pos++;
    }

    T removedElement = auxStack.pop();

    while (!auxStack.isEmpty())
      stack.push(auxStack.pop());

    return removedElement;
  }

  // Exercice 7
  public static boolean isWellParentized(String mathExpression) {
    Stack<Character> controlStack = new LinkedStack<>();
    boolean wellParentized = true;

    mathExpression = mathExpression.trim();

    for (int i = 0; i < mathExpression.length(); i++) {

      if ("{[(".indexOf(mathExpression.charAt(i)) != -1) {
        controlStack.push(mathExpression.charAt(i));

      } else if (")]}".indexOf(mathExpression.charAt(i)) != -1) {

        if (controlStack.isEmpty() || "{[(".indexOf(controlStack.top()) != "}])".indexOf(mathExpression.charAt(i))) {
          wellParentized = false;
          break;
        } else {
          controlStack.pop();
        }
      }
    }

    if (!controlStack.isEmpty())
      wellParentized = false;

    return wellParentized;
  }

  // Exercise 8
  public static String addDigits(int number) throws IllegalArgumentException {
    if (number < 0)
      throw new IllegalArgumentException();

    Stack<Integer> digitStack = new LinkedStack<>();
    int quotient = number;
    int sum = 0;

    while (quotient != 0) {
      digitStack.push(quotient % 10);
      quotient /= 10;
    }

    StringBuilder expression = new StringBuilder();

    while (!digitStack.isEmpty()) {
      sum += digitStack.top();
      expression.append(digitStack.pop());

      if (!digitStack.isEmpty())
        expression.append(" + ");
      else
        expression.append(" = ");
    }
    expression.append(sum);

    return expression.toString();
  }

  // Exercise 9
  public static String removeCharDuplicated(String text) {

    return null;
  }

  // Exercise 10
  public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {
    requireNonNull(stack);

    Stack<T> auxStack = new LinkedStack<>();

    while (!stack.isEmpty()) {
      if (stack.top().equals(oldValue)) // if the value on the top is the old value, we push the new value to the
                                        // auxiliar stack instead
        auxStack.push(newValue);
      else
        auxStack.push(stack.top()); // if it's not the old value we push the top value to the auxiliar stack nomarlly

      stack.pop(); // erasing the top element of the original stack
    }

    while (!auxStack.isEmpty()) // pushing the auxiliar stack values with changes into the original stack
      stack.push(auxStack.pop());
  }

  // Exercise 11
  public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {
    requireNonNull(stack);

    stack.push(value);

    if (stack.size() > 10) {
      Stack<T> auxStack = new LinkedStack<>();

      while (!stack.isEmpty())
        auxStack.push(stack.pop());

      auxStack.pop();

      while (!auxStack.isEmpty())
        stack.push(auxStack.pop());
    }
  }

  // exercise 10
  public static int calculateScore(String mathExpression) throws NullPointerException {
    requireNonNull(mathExpression);

    mathExpression = mathExpression.trim();

    Stack<Integer> auxStack = new LinkedStack<>();
    int sum = 0;
    int currentNum = 0;

    for (int i = 0; i < mathExpression.length(); i++) {
      char current = mathExpression.charAt(i);

      if (Character.isDigit(current)) {
        currentNum = current - '0';
      } else if (current == '+') {
        sum += currentNum;
      } else if (current == '(') {
        auxStack.push(sum);
        sum = 0;
      } else if (current == ')') {
        sum += currentNum;
        currentNum = 0;
        sum *= 2;
        sum += auxStack.pop();
      }
    }

    sum += currentNum;

    return sum;
  }
}
