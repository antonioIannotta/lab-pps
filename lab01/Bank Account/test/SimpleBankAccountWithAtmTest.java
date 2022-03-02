import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccountWithAtm;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBankAccountWithAtmTest{

    private AccountHolder accountHolder;
    private BankAccountWithAtm bankAccountWithAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Antonio", "Iannotta", 2);
        bankAccountWithAtm = new BankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance(){
        assertEquals(0,bankAccountWithAtm.getBalance());
    }

    @Test
    void testDeposit(){
        bankAccountWithAtm.deposit(bankAccountWithAtm.getHolder().getId(),100);
        assertEquals(99,bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdraw(){
        bankAccountWithAtm.withdraw(bankAccountWithAtm.getHolder().getId(),98);
        assertEquals(0,bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawWrongCases(){
        bankAccountWithAtm.deposit(bankAccountWithAtm.getHolder().getId(),100);
        assertEquals(99,bankAccountWithAtm.getBalance());
        bankAccountWithAtm.withdraw(bankAccountWithAtm.getHolder().getId(), 99);
        assertNotEquals(0, bankAccountWithAtm.getBalance(), 0.0);
    }
}
