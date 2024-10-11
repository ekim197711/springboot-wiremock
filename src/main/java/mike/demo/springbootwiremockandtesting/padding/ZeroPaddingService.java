package mike.demo.springbootwiremockandtesting.padding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ZeroPaddingService {

    public String zeroPad(int lengthOfString, String theStringToPad) {
        String result = "0".repeat(Math.max(0, lengthOfString - theStringToPad.length())) + theStringToPad;
        log.info("Hey the result is {} for input {} with a total length of {}", result, theStringToPad, lengthOfString);
        return result;
    }
}
