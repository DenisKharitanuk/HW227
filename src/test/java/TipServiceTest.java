import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {


    @ParameterizedTest( name =   "Amount {0}")
    @CsvSource({
            "0, 0",
            "1,0.1",
            "999, 99.9",
            "1000,50.05",
            "1001,50.05",
            "-10,-1 ",
    })
    @DisplayName("Расчет чаевых при различной сумме заказа")

    public void aroundTipsTest(BigDecimal amount, BigDecimal expected) {
        TipService tipService = new TipService();

        assertEquals(amount.multiply(amount), tipService.roundTips(amount));
    }


}
