public class CoreJavaLecture1 {
    public static void main(String[] args) {
        
        /*
        
        Q. 1 - What is the difference between Compiler & Interpreter??
        Ans - Compiler - A Compiler compiles the source code (HLL) in one go and detects and gives back all the issues at once.
                        It is more faster, It is most of the time platfom dependent and may need to recompiled for different platforms.
              Interpreter - An Interpreter runs the High level language line by line, if it encounters an error, it throws it. 
                        It is comparatively slower than compiler, It is not platform dependent.

        Q. 2 - 
        What is the difference between JDK, JRE & JVM;
        Ans - 
            1. JDK - JDK stands for Java Development Kit. It includes all the softwares and tools used to develop a Java
                program. It includes Java Compiler (javac) and Java Runtime Environment (JRE). Installing JDK will have JRE also.

            2. JRE - JRE stands for Java Runtime Environment. It provides all the necessary libraries to run a java program.
                It includes JVM (Java Virtual Machine). JRE is used by end-user to run a Java program. It includes JVM.

            3. JVM - Java Virtual Machine - JVM is a part of JRE and it converts the byte code to machine language.

            JVM is a part of JRE and JRE is a part of JDK.


        Q. 3 - How many types of memory areas are allocated by JVM?
        Ans - 
            1. Method Area (Class Area): Stores metadata about loaded classes, including class structures, methods, 
            field names, and constant pool.

            2. Heap Memory: The runtime data area where objects are allocated. Divided into the Young Generation
             (Eden Space, Survivor Space) and the Old Generation (Tenured Generation).

            3. JVM Stack: Each thread has its own stack memory for executing Java method calls. Holds local variables,
             method arguments, return values, and intermediate results.

            4. Program Counter Register: Keeps track of the current execution position by storing the address of the
             next instruction to be executed.

            5. Native Method Stack: Supports the execution of native methods implemented in languages other than Java,
             such as C or C++.

        
        Q. 4 - What is JIT Compiler?
        Ans - A Just-in-Time (JIT) compiler is a type of compiler that dynamically translates and executes programming code at runtime. Unlike traditional ahead-of-time
            compilers that convert the entire source code into machine code before execution, JIT compilers work by converting smaller portions of code, typically called "chunks"
            or "methods," into machine code just before they are actually needed.

        
        Q. 5 - What are different access specifiers in java??
        Ans - 
            1. Public: The public access specifier allows unrestricted access to a class, method, variable, or constructor from any other class or code module. Public members
             are visible to all other classes and can be accessed outside the defining class.

            2. Private: The private access specifier restricts access to only within the same class. Private members are not visible or accessible outside the class in which 
            they are declared. This is the most restrictive access specifier.

            3. Protected: The protected access specifier allows access within the same package and from subclasses, even if they are in different packages. Protected members 
            are visible to classes within the same package and to subclasses, regardless of the package they are in.

            4. Default (no specifier): The default access specifier (also known as package-private) is used when no explicit access specifier is specified. It allows access
             to classes, methods, variables, and constructors within the same package. Members with default access are not visible to classes in different packages.



        Q. 6 - What is a compiler in Java?
        Ans - In Java, a compiler is a software tool responsible for translating Java source code written by developers into a format that can be executed by the Java 
            Virtual Machine (JVM). The compiler converts human-readable Java code, typically written in .java files, into bytecode, which is a low-level, platform-independent
            representation of the code.

        

        Q. 7 - Explain the types of variables in Java.
        Ans. - There are mainly 3 types of variables in java.
            1. Local variables: Local variables are declared within a method, constructor, or block of code and are only accessible within the scope where they are declared. 
                They must be explicitly initialized before use and do not have default values.

            2. Instance variables: Instance variables are declared within a class but outside of any method. They are associated with instances (objects) of the class and each 
                instance of the class has its own copy of the instance variables. Instance variables are initialized with default values if not explicitly initialized.

            3. Class variables (Static variables): Class variables, also known as static variables, are declared with the static keyword and are associated with the class 
                itself rather than instances of the class. They are shared among all instances of the class and can be accessed directly using the class name. Class variables
                 are initialized with default values if not explicitly initialized.


        Q. 8 - What are the Datatypes in Java?
        Ans - 
            byte: Represents a signed 8-bit integer value (-128 to 127).
            short: Represents a signed 16-bit integer value (-32,768 to 32,767).
            int: Represents a signed 32-bit integer value (-2,147,483,648 to 2,147,483,647).
            long: Represents a signed 64-bit integer value (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807).
            float: Represents a 32-bit floating-point value.
            double: Represents a 64-bit floating-point value.
            boolean: Represents a boolean value (true or false).
            char: Represents a single Unicode character.

        
        Q. 9 - What are the identifiers in java?
        Ans - 
            In Java, an identifier is a name used to identify a class, variable, method, or other program elements. Identifiers are used to give a unique name to different program
             entities and are essential for referencing and manipulating them.


            
        Q. 10 - Explain the architecture of JVM.
        Ans - 
            The Java Virtual Machine (JVM) is an integral part of the Java platform and plays a crucial role in executing Java programs. The JVM provides a runtime environment 
            for Java bytecode, which is the compiled form of Java source code.

            1. Class Loader Subsystem:
                The Class Loader subsystem is responsible for loading classes into the JVM at runtime. It performs the following tasks:
                Loading: Loads class files from various sources like the file system, network, or other sources.
                Verification: Verifies the integrity and correctness of the loaded classes to ensure they adhere to the Java language and JVM specifications.
                Linking: Performs the linking process, which involves preparing the class for execution by resolving symbolic references and allocating memory for class variables and methods.
                Runtime Data Areas:
                The JVM divides memory into different runtime data areas that are used during program execution:
            2. Method Area: It stores class-level data, including bytecode instructions, constant pool, field and method data, and static variables.
                Heap: The heap is the runtime data area where objects are allocated. It is dynamically divided into regions for efficient memory management and garbage collection.
                Java Stack: Each thread in the JVM has its own Java Stack, which stores method invocations and local variables. It is used for method call execution and managing method frames.
                PC Register: The Program Counter (PC) Register holds the address of the current instruction being executed.
                Native Method Stack: It is similar to the Java Stack but is used for executing native (non-Java) methods.
                Execution Engine:
                The Execution Engine is responsible for executing the compiled bytecode. It includes the following components:
            3. Just-in-Time (JIT) Compiler: The JIT compiler compiles parts of the bytecode that are frequently executed into native machine code for better performance. It optimizes the bytecode by applying various optimizations.
                Interpreter: The interpreter executes the bytecode line by line. It reads bytecode instructions from memory, decodes them, and performs the corresponding operations.
                Native Method Interface (JNI):
                The JNI provides a way for Java programs to interact with native code written in languages like C or C++. It allows Java programs to call native methods and provides a bridge between the Java runtime environment and the underlying operating system.

            4. Native Method Libraries:
                Native method libraries contain the implementation of native methods that are used by Java programs. These libraries are written in languages like C or C++ and provide access to platform-specific functionalities.

                Overall, the JVM architecture combines various components to provide a platform-independent and secure runtime environment for Java programs. It manages memory, loads and verifies classes, executes bytecode, and facilitates interaction with native code.

         */


    }

}
