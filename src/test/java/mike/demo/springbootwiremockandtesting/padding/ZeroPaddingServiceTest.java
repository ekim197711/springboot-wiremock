package mike.demo.springbootwiremockandtesting.padding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ZeroPaddingServiceTest {

    private final ZeroPaddingService zeroPaddingService = new ZeroPaddingService();

    @Test
    void zeroPad() {
        String somethingWithoutPadding = "1234";
        int totalLength = 30;
        String result = zeroPaddingService.zeroPad(totalLength, somethingWithoutPadding);
        Assertions.assertThat(result).hasSize(totalLength).isEqualTo("000000000000000000000000001234");
    }
}