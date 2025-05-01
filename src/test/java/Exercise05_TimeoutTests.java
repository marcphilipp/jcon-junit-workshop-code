import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class Exercise05_TimeoutTests {

    static final int TIMEOUT_SECONDS = 1;
    static final int SLEEP_SECONDS = 2;

    @Test
    void timeoutAssertion(TestInfo testInfo) {
        assertTimeout(Duration.ofSeconds(TIMEOUT_SECONDS), () -> sleep(testInfo, Duration.ofSeconds(SLEEP_SECONDS)));
    }

    @Test
    void preemptiveTimeoutAssertion(TestInfo testInfo) {
        assertTimeoutPreemptively(Duration.ofSeconds(TIMEOUT_SECONDS), () -> sleep(testInfo, Duration.ofSeconds(SLEEP_SECONDS)));
    }

    @Timeout(TIMEOUT_SECONDS)
    @Test
    void declarativeTimeout(TestInfo testInfo) {
        sleep(testInfo, Duration.ofSeconds(SLEEP_SECONDS));
    }

    private static void sleep(TestInfo testInfo, Duration duration) {
        try {
            System.out.printf("[%s] Sleeping for %s on thread %s%n", testInfo.getDisplayName(), duration, Thread.currentThread());
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            System.out.printf("[%s] Sleeping interrupted on thread %s%n", testInfo.getDisplayName(), Thread.currentThread());
            throw new RuntimeException(e);
        }
    }
}
