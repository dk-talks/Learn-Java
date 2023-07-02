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

        


         */


    }

}
