import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise09_TestsB {

    ExecutorService executorService;

    @BeforeEach
    void createExecutorService() {
        executorService = Executors.newCachedThreadPool();
    }

    @AfterEach
    void shutdownExecutorService() throws Exception {
        executorService.shutdownNow();
        boolean terminated = executorService.awaitTermination(5, SECONDS);
        assertTrue(terminated, "ExecutorService did not shut down within timeout of 5 seconds");
    }

    @Test
    @Timeout(5)
    void spawnsMultipleThreads() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);

        Future<Thread> first = executorService.submit(() -> {
            latch.countDown();
            latch.await();
            return Thread.currentThread();
        });
        Future<Thread> second = executorService.submit(() -> {
            latch.countDown();
            latch.await();
            return Thread.currentThread();
        });

        assertNotEquals(first.get(), second.get());
    }
}
