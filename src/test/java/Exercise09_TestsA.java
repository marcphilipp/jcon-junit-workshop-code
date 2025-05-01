import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(ExecutorServiceExtension.class)
class Exercise09_TestsA {

    @Test
    void runsOnDifferentThread(ExecutorService executorService) throws Exception {
        Future<Thread> future = executorService.submit(Thread::currentThread);

        assertNotEquals(Thread.currentThread(), future.get());
    }
}
