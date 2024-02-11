package waitTimes;

import java.time.Duration;

public class WaitTimes {
    public final Duration DEFAULT_WAIT = Duration.ofSeconds(
            Long.parseLong(System.getProperty("wait.default")));
    public final Duration LONG_WAIT = Duration.ofSeconds(
            Long.parseLong(System.getProperty("wait.long")));
}
