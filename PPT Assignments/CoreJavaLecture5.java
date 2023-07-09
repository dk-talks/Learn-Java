public class CoreJavaLecture5 {

    public static void main(String[] args) {
        
        /*
         
        Q1.What is Exception in Java?
        Ans - In Java, an exception is an event that occurs during the execution of a program and disrupts the normal flow of the program's 
              instructions. It represents an abnormal condition or error that can occur at runtime. When an exceptional situation arises, such as an 
              input/output error, arithmetic error, or invalid data, an exception is thrown.

        
        Q2.What is Exception Handling?
        Ans - Exception handling in Java is a mechanism that allows programmers to handle and respond to exceptional situations or errors 
        that occur during the execution of a program. It provides a structured way to deal with runtime errors and prevents the program from
         terminating abruptly.

        Exception handling involves the use of try-catch blocks. The code that may throw an exception is enclosed within the try block, 
        and if an exception occurs, it is caught and handled by the catch block. The catch block specifies the type of exception it can 
        handle, and when a matching exception occurs, the corresponding catch block is executed.


        Q3.What is the difference between Checked and Unchecked Exceptions and Error?
        Ans - 
        1. Checked Exceptions: Checked exceptions are the exceptions that are checked at compile-time. These exceptions are typically 
        related to external factors beyond the control of the program, such as I/O operations, network connectivity, or database interactions.
         Checked exceptions must be explicitly declared in the method signature or handled using try-catch blocks. If a method throws a 
         checked exception, the calling method must either handle it or declare it in its own throws clause. Examples of checked exceptions
          in Java include IOException, SQLException, and ClassNotFoundException.

        2. Unchecked Exceptions: Unchecked exceptions, also known as runtime exceptions, are exceptions that are not checked at compile-time.
         They typically indicate programming errors or logical mistakes within the code that could have been avoided with proper coding 
         practices. Unchecked exceptions do not need to be declared in method signatures or explicitly handled, although it is a good 
         practice to handle them. Examples of unchecked exceptions in Java include NullPointerException, ArrayIndexOutOfBoundsException,
          and IllegalArgumentException.

        3. Errors: Errors are exceptional conditions that are typically caused by system-level issues or failures that are beyond the
         control of the application. Errors are not intended to be caught or handled by the application, as they indicate serious problems
          that usually cannot be recovered from. Examples of errors in Java include OutOfMemoryError, StackOverflowError, and 
          VirtualMachineError.


          
        Q4.What are the difference between throw and throws in Java?
        Ans - 
        1.  throw: The throw keyword is used to explicitly throw an exception from a block of code. It is followed by an instance of an
            exception class or a subclass of Throwable. When the throw statement is executed, it terminates the normal flow of the program 
            and transfers control to the nearest enclosing try-catch block or the calling method's exception handling mechanism. It allows 
            you to create and throw custom exceptions or propagate built-in exceptions.

        2.  throws: The throws keyword is used in method declarations to specify the exceptions that a method may throw. 
            It indicates that the method can potentially generate and propagate exceptions of the specified types. Multiple exceptions can be
            declared using a comma-separated list. When a method declares throws for a specific exception type, it is indicating that the
            method does not handle the exception itself but rather delegates the responsibility of handling the exception to its caller or 
            higher-level methods.



        Q5.What is multithreading in Java? mention its advantages.
        Ans - 
            Multithreading in Java refers to the concurrent execution of multiple threads within a single program. 
            A thread is a lightweight unit of execution that can perform tasks independently, allowing multiple tasks to run simultaneously.
            Multithreading provides several advantages:

            Improved Performance: Multithreading allows for parallel execution of tasks, maximizing CPU utilization and enhancing overall
             performance.

            Enhanced Responsiveness: Multithreading keeps the user interface responsive by separating time-consuming tasks from the main thread.

            Concurrent Operations: Multithreading enables concurrent execution of multiple operations, facilitating tasks such as handling multiple client requests simultaneously or parallel computations.

            Efficient Resource Utilization: Multithreading optimizes resource utilization by allowing threads to share system resources, leading to better efficiency and scalability.


        Q6.Write a program to create and call a custom exception.

        Ans - 

            class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    // Example usage of custom exception
    class Main {
        public static void main(String[] args) {
            try {
                // Throw custom exception
                throw new CustomException("This is a custom exception.");
            } catch (CustomException e) {
                // Catch and handle custom exception
                System.out.println("Caught CustomException: " + e.getMessage());
            }
        }
    }




        
        Q. 7 - How can you handle exceptions in Java? 

        Ans  - Using Below code snippet--

        try {
            // Code that may throw an exception
        } catch (ExceptionType1 exceptionVariable1) {
            // Code to handle ExceptionType1
        } catch (ExceptionType2 exceptionVariable2) {
            // Code to handle ExceptionType2
        } finally {
            // Code that will be executed regardless of whether an exception occurred or not
        }

        Q.8 - What is Thread in Java?
        Ans - In Java, a thread refers to a separate path of execution within a program. It allows concurrent execution of multiple tasks 
        within a single program. Each thread represents an independent flow of control, enabling different parts of the program to execute
         concurrently.

        A thread in Java is an instance of the Thread class or a subclass of it. Threads can be created and managed using the 
        java.lang.Thread class and provide various methods for controlling their behavior, such as starting, pausing, resuming, and stopping.



        Q9. What are the two ways of implementing thread in Java?
        Ans - 
        1. Implementing the Runnable interface: This involves implementing the Runnable interface and defining the run() method. The run() 
            method contains the code that will be executed by the thread. To create a thread using this approach, an instance of the Thread class
            is created, passing the Runnable object as a parameter, and then invoking the start() method to start the thread.

        2.  Extending the Thread class: This involves creating a subclass of the Thread class and overriding the run() method to define the 
            code that will be executed by the thread. To create a thread using this approach, an instance of the subclass is created, and then 
            the start() method is invoked to start the thread.




        Q10.What do you mean by garbage collection?
        Ans - 
        Garbage collection in Java refers to the automatic memory management process where the Java Virtual Machine (JVM) automatically 
        deallocates memory occupied by objects that are no longer referenced or in use by the program.

        When objects are created in Java, memory is allocated to store them in the heap. However, as the program runs, objects may become 
        unreachable or no longer needed. Garbage collection identifies such unreferenced objects and reclaims the memory occupied by them,
         making it available for future allocation.



         */

    }
    
}



// Answer 9 - two ways to create thread in java

//1. Implementing the Runnable Interface

class MyRunnable implements Runnable {
    public void run() {
        // Code to be executed by the thread
    }
}

// Creating and starting the thread
Thread thr = new Thread(new MyRunnable());
myThread.start();


// 2. Extending the Thread class

class MyThread extends Thread {
    public void run() {
        // Code to be executed by the thread
    }
}

// Creating and starting the thread
MyThread thr1 = new MyThread();
myThread.start();






