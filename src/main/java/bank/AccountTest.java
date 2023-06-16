package bank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private static Stream<Account> accountProvider() {
        return Stream.of(
                new Account(1, 1000.0, 0.05),
                new Account(2, 2000.0, 0.03),
                new Account(3, 3000.0, 0.02)
        );
    }

    @ParameterizedTest(name = "Test deposit method for account {index}: {0}")
    @MethodSource("accountProvider")
    public void testDeposit(Account account) {
        double initialBalance = account.getBalance();
        double depositAmount = 500.0;
        account.deposit(depositAmount);
        double expectedBalance = initialBalance + depositAmount;
        assertEquals(expectedBalance, account.getBalance());
    }

    @ParameterizedTest(name = "Test withdraw method for account {index}: {0}")
    @MethodSource("accountProvider")
    public void testWithdraw(Account account) {
        double initialBalance = account.getBalance();
        double withdrawalAmount = 200.0;
        account.withdraw(withdrawalAmount);
        double expectedBalance = initialBalance - withdrawalAmount;
        assertEquals(expectedBalance, account.getBalance());
    }

    @ParameterizedTest(name = "Test calculateInterest method for account {index}: {0}")
    @MethodSource("accountProvider")
    public void testCalculateInterest(Account account) {
        double expectedInterest = account.getBalance() * account.getInterestRate();
        assertEquals(expectedInterest, account.calculateInterest());
    }
}
