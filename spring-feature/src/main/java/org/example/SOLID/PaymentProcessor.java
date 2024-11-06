package org.example.SOLID;

// Initial non-SOLID code

// PaymentProcessor.java

import java.io.FileWriter;
import java.io.IOException;

// Original code
public class PaymentProcessor {
    public void processCreditCardPayment(String accountNumber, double amount) {
        // Processing logic
        System.out.println("Processing credit card payment: " + amount);
    }

    public void processPaypalPayment(String email, double amount) {
        // Processing logic
        System.out.println("Processing PayPal payment: " + amount);

        try (FileWriter logWriter = new FileWriter("log.txt", true)) {
            logWriter.write("PayPal payment processed for email: " + email + ", amount: " + amount + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Single Responsibility Principle
class PaymentLogger {
    public void printPayment(String paymentDetail) {
        try (FileWriter logWriter = new FileWriter("log.txt", true)) {
            logWriter.write(paymentDetail);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PaymentProcessorSingle {
    final PaymentLogger paymentPrinter = new PaymentLogger();

    public void processCreditCardPayment(String accountNumber, double amount) {
        // Processing logic
        System.out.println("Processing credit card payment: " + amount);

        paymentPrinter.printPayment("Credit card payment processed for account number: " + accountNumber + ", amount: " + amount + "\n");
    }

    public void processPaypalPayment(String email, double amount) {
        // Processing logic
        System.out.println("Processing PayPal payment: " + amount);

        paymentPrinter.printPayment("PayPal payment processed for email: " + email + ", amount: " + amount + "\n");
    }
}

// Open Closed Principle
interface PaymentProcessorInterface {
    void processPayment(double amount);
}

class CreditCardPaymentProcessor implements PaymentProcessorInterface {
    private final PaymentLogger paymentPrinter;
    private String accountNumber;

    public CreditCardPaymentProcessor(String accountNumber, PaymentLogger paymentPrinter) {
        this.accountNumber = accountNumber;
        this.paymentPrinter = paymentPrinter;
    }

    @Override
    public void processPayment(double amount) {
        // Processing logic
        System.out.println("Processing credit card payment: " + amount);

        paymentPrinter.printPayment("Credit card payment processed for account number: " + accountNumber + ", amount: " + amount + "\n");
    }
}

class PaypalPaymentProcessor implements PaymentProcessorInterface {
    private final PaymentLogger paymentPrinter;
    private String email;

    public PaypalPaymentProcessor(String email, PaymentLogger paymentPrinter) {
        this.email = email;
        this.paymentPrinter = paymentPrinter;
    }

    @Override
    public void processPayment(double amount) {
        // Processing logic
        System.out.println("Processing PayPal payment: " + amount);
        paymentPrinter.printPayment("PayPal payment processed for email: " + email + ", amount: " + amount + "\n");
    }
}

class PioneerPaymentProcessor implements PaymentProcessorInterface {
    private final PaymentLogger paymentPrinter;
    private String email;

    public PioneerPaymentProcessor(String email, PaymentLogger paymentPrinter) {
        this.email = email;
        this.paymentPrinter = paymentPrinter;
    }

    @Override
    public void processPayment(double amount) {
        // Processing logic
        System.out.println("Processing Pioneer payment: " + amount);
        paymentPrinter.printPayment("Pioneer payment processed for email: " + email + ", amount: " + amount + "\n");
    }
}

// Liskov Substitution Principle
// Code as above
class ProcessPaymentTest {
    PaymentProcessorInterface creditCard = new CreditCardPaymentProcessor("1234-5678-9876-5432", new PaymentLogger());
    PaymentProcessorInterface paypal = new PaypalPaymentProcessor("abc@gmail.com", new PaymentLogger());

    public void processPayment(double amount) {
        creditCard.processPayment(amount);
        paypal.processPayment(amount);
    }

}
// Interface Segregation Principle
interface Logger {
    void log(String message);
}

class PaymentLoggerExtend implements Logger {
    @Override
    public void log(String message) {
        try (FileWriter logWriter = new FileWriter("log.txt", true)) {
            logWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Dependency Inversion Principle
class CreditCardPaymentProcessorExtend implements PaymentProcessorInterface {
    private final Logger paymentPrinter;
    private String accountNumber;

    public CreditCardPaymentProcessorExtend(String accountNumber, Logger paymentPrinter) {
        this.accountNumber = accountNumber;
        this.paymentPrinter = paymentPrinter;
    }

    @Override
    public void processPayment(double amount) {
        // Processing logic
        System.out.println("Processing credit card payment: " + amount);

        paymentPrinter.log("Credit card payment processed for account number: " + accountNumber + ", amount: " + amount + "\n");
    }
}


// Main.java
//public class Main {
//    public static void main(String[] args) {
//        PaymentProcessor processor = new PaymentProcessor();
//        processor.processCreditCardPayment("1234-5678-9876-5432", 100.00);
//        processor.processPaypalPayment("user@example.com", 75.50);
//    }
//}

