import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(ExecutorServiceExtension.class)
class Exercise09_TestsB {

    @Test
    @Timeout(5)
    void spawnsMultipleThreads(ExecutorService executorService) throws Exception {
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
