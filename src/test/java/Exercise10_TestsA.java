import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise10_TestsA {

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
    void runsOnDifferentThread() throws Exception {
        Future<Thread> future = executorService.submit(Thread::currentThread);

        assertNotEquals(Thread.currentThread(), future.get());
    }
}
