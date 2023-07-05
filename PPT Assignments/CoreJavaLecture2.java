public class CoreJavaLecture2 {
    public static void main(String[] args) {
        
        /*
        
        Q1. What are the Conditional Operators in Java?
        Ans - 
            1. Ternary Operator (?:)
                Shorthand for an if-else statement.
                Takes three operands: condition, expression1, and expression2.
                Evaluates the condition and returns expression1 if true, otherwise returns expression2.
            2. Logical AND Operator (&&)
                Evaluates two boolean expressions.
                Returns true if both expressions are true.
                Short-circuits: if the first expression is false, the second expression is not evaluated.
            3. Logical OR Operator (||)
                Evaluates two boolean expressions.
                Returns true if at least one expression is true.
                Short-circuits: if the first expression is true, the second expression is not evaluated.
        
        Q.2 - What are the types of operators based on the number of operands?
        Ans - 
            1. Unary Operators:
            Unary operators work with a single operand. They perform operations on a single value or variable. Examples of unary operators 
            include increment (e.g., ++), decrement (e.g., --), logical negation (e.g., !), and unary minus (e.g., -).

            2. Binary Operators:
            Binary operators work with two operands. They perform operations between two values or variables. Examples of binary operators 
            include arithmetic operators (e.g., +, -, *, /), assignment operators (e.g., =, +=, -=), comparison operators 
            (e.g., ==, !=, >, <), logical operators (e.g., &&, ||), and bitwise operators (e.g., &, |, ^).

            3. Ternary Operator:
            The ternary operator is the only operator in Java that takes three operands. It is a conditional operator that evaluates a 
            condition and returns one of two expressions based on the result. The syntax of the ternary operator is:
             condition ? expression1 : expression2.


        Q3.What is the use of Switch case in Java programming?
        Ans - 

            The switch case statement in Java is used to make decisions based on multiple possible values of a variable or expression.
            Its main uses are:

            1. Handling multiple branching conditions.
            2. Enhancing code readability.
            3. Organizing and structuring code.
            4. Potentially optimizing performance.
            Switch case statements are especially useful for discrete, distinct values and can improve code readability compared to long chains
            of if-else statements.

        Q4. What are the conditional Statements and use of conditional statements in Java? 
        Ans -   Conditional statements in Java, such as if, if-else, and switch, are used to execute different blocks of code based on specific 
                conditions. They allow programs to make decisions and control the flow of execution. Conditional statements are essential for 
                implementing logic, handling user input, error handling, and controlling program behavior based on various conditions. They enhance the 
                flexibility and functionality of Java programs.

        Q5.What is the syntax of if else statement?
        Ans - 
        if (condition) {
            // code to be executed if the condition is true
        } else {
            // code to be executed if the condition is false
        }

        Q6.How do you compare two strings in Java?
        Ans - 
            1. To compare equality of two Strings in java we use string1.equals(string2);
            2. To compare there references (if both strings point to same object in heap memory).
        

        Q7.What is Mutable String in Java Explain with an example.
        Ans - 

            In Java, a mutable string refers to a string object whose value can be modified after it is created. The java.lang.String class
             in Java is immutable by default, meaning that once a string object is created, its value cannot be changed. However, there is 
             another class called java.lang.StringBuilder that represents mutable strings.

            The StringBuilder class provides methods to modify the contents of the string without creating a new object each time. 
            This can be more efficient when you need to perform frequent modifications on a string, such as concatenating multiple strings 
            or replacing substringss


         */

        
        // Q8.Write a program to sort a String Alphabetically

        String str = "DineshSharma";
        str = str.toLowerCase();

        // using bubble sort

        char[] arr = new char[str.length()];
        for(int i = 0; i<str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        // now all charcaters are in arr

        for(int i = 0; i<arr.length; i++) {
            boolean isSwapped = false;
            for(int j = 0; j<arr.length-i-1; j++) {
                // compare two characters decimal value
                if(arr[j] > arr[j+1]) {
                    isSwapped = true;
                    // jth character is bigger - swap
                    char temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
            if(!isSwapped) {
                break;
            }
        }

        // now our arr is sorted, convert to string to retrun it
        str = "";
        for(char c: arr) {
            str += c;
        }
        System.out.println(str);
        // str - aadehhimnrss

        // now string is sorted
        

        // Q9. Write a program to check if the letter 'e' is present in the word "Umbrella";

        String s = "Umbrella";

        boolean isePresent = false;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == 'e') {
                System.out.println("Yes, e is present");
                isePresent = true;
                break;
            }
        }
        if(!isePresent) {
            System.out.println("No, e is not present");
        }


        // Q.10 - Where exactly is the string constant pool located in the memory?
        /*
         Ans - 10 - String Constant Pool is situated inside the heap memory. It consists of unique Strings which can be refereced to 
                    different string objects.
         */


        

    }
}
