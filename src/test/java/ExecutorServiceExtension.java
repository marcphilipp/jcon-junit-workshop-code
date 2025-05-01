import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutorServiceExtension extends TypeBasedParameterResolver<ExecutorService> implements BeforeAllCallback, AfterAllCallback {

    private ExecutorService executorService;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        executorService = Executors.newCachedThreadPool();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        executorService.shutdownNow();
        boolean terminated = executorService.awaitTermination(5, SECONDS);
        assertTrue(terminated, "ExecutorService did not shut down within timeout of 5 seconds");
    }

    @Override
    public ExecutorService resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return executorService;
    }
}
