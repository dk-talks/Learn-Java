
// Main class
public class Question5 {
    public static void main(String[] args) {
        Printer consolePrinter = new ConsolePrinter();
        Printer filePrinter = new FilePrinter();

        PrinterUser user1 = new PrinterUser(consolePrinter);
        user1.usePrinter("Printing to console");

        PrinterUser user2 = new PrinterUser(filePrinter);
        user2.usePrinter("Printing to file");
    }
}



// Interface defining the contract for a Printer
public interface Printer {
    void print(String message);
}

// Implementation of a Printer
public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Console Printer: " + message);
    }
}

// Another implementation of a Printer
public class FilePrinter implements Printer {
    @Override
    public void print(String message) {
        // Code for printing to a file
        System.out.println("File Printer: " + message);
    }
}

// Class that depends on the Printer interface
public class PrinterUser {
    private final Printer printer;

    public PrinterUser(Printer printer) {
        this.printer = printer;
    }

    public void usePrinter(String message) {
        printer.print(message);
    }
}

