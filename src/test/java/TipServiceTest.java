import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {


    @ParameterizedTest
    @CsvSource({
            "0, 1.1",
            "1, 1.1",
            "999, 1.1",
            "1000, 1.05",
            "1001, 1.05",
            "-10, 1.1",
    })
    @DisplayName("Calculation of tips for different order amounts")

    public void aroundTipsTest(BigDecimal amount,BigDecimal percent) {
        TipService tipService = new TipService();
        BigDecimal actual = tipService.roundTips(amount);
        BigDecimal expected = amount.multiply(percent);

        assertEquals(actual, expected);
    }


}
