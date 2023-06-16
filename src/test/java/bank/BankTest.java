package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;
    private Account account1;
    private Account account2;

    @BeforeEach
    public void setup() {
        bank = new Bank();
        account1 = new Account(1, 1000.0, 0.05);
        account2 = new Account(2, 2000.0, 0.03);
        bank.addAccount(account1);
        bank.addAccount(account2);
    }

    @ParameterizedTest(name = "Test transfer method from account1 to account2 with amount {0}")
    @MethodSource("amountProvider")
    public void testTransfer(double amount) {
        double initialBalance1 = account1.getBalance();
        double initialBalance2 = account2.getBalance();
        bank.transfer(account1, account2, amount);
        double expectedBalance1 = initialBalance1 - amount;
        double expectedBalance2 = initialBalance2 + amount;
        assertEquals(expectedBalance1, account1.getBalance());
        assertEquals(expectedBalance2, account2.getBalance());
    }

    /*@Test
    @DisplayName("Test removeAccount method")
    public void testRemoveAccount() {
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.removeAccount(account1);
        List<Account> accounts = bank.getAccounts();
        assertFalse(accounts.contains(account1));
        assertTrue(accounts.contains(account2));
    }*/

    @Test
    @DisplayName("Test displayAccountBalances method")
    public void testDisplayAccountBalances() {
        bank.addAccount(account1);
        bank.addAccount(account2);

        // Redirect System.out.println() to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalPrintStream = System.out;
        System.setOut(printStream);

        bank.displayAccountBalances();

        System.out.flush();
        System.setOut(originalPrintStream);

        String expectedOutput = "Account ID: 1, Balance: 1000.0\n" +
                "Account ID: 2, Balance: 2000.0\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    private static Stream<Double> amountProvider() {
        return Stream.of(100.0, 200.0, 300.0);
    }
}
