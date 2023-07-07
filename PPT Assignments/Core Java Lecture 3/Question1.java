
// BankAccout class is serving as an Abstract class and SavingAccoutn classs is serving as an Implementation class
// so It follows Abstraction principle of OOPS
class BankAccout {

  // Encapsulation here - these properties can be only accessed within the class 
     private String accountNumber;
     private Double balance;

    
     public BankAccout(String accoutNumber) {
        this.accountNumber = accoutNumber;
        this.balance = 0.0;
     }

     public void deposit(Double amount) {
        balance += amount;
        System.out.println("Accout Deposited with " + amount);
     }

     public void withdraw(Double amount) {
        if(balance < amount) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn, Remaining Balance: " + balance);
        }
     }

     public Double getBalance() {
        return balance;
     }

}
// Inheritence -  SavingAccount inherits all the properties and methods of BankAccount Class to improve code reusablity.
 class SavingAccout extends BankAccout {
    private Double intrestRate;

    public SavingAccout(String accoutNumber, Double intrestRate) {
        super(accoutNumber);
        this.intrestRate = intrestRate;
    }

   // Polymorphism - getInterest()  is behaving
    public void getInterest() {
        Double balance = getBalance();
        if(balance >0) {
            Double amout = getBalance() * ((double)3/100);
            System.out.println("Amount to be deposit: " + amout);
            deposit(amout);
        } else {
            System.out.println("Your Bank balance is 0,.0, cannot add interest");
        }
    }
 }


public class Question1 {

    public static void main(String[] args) {
        
        BankAccout ac1 = new BankAccout("1234543");
        System.out.println(ac1.getBalance());

        ac1.deposit(5500.0);
        System.out.println(ac1.getBalance());
        ac1.withdraw(6000.0);
        System.out.println(ac1.getBalance());

        ac1.withdraw(5000.0);

        System.out.println(ac1.getBalance());


        // saving accout
        System.out.println("Saving bank account below----");
        SavingAccout sa1 = new SavingAccout("734883353", 3.0);
        System.out.println(sa1.getBalance());
        sa1.getInterest();
        sa1.deposit(5023.0);
        sa1.getInterest();

        sa1.withdraw(3000.5);
        System.out.println(sa1.getBalance());





    }
    
}


