import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.support.TypeBasedParameterResolver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExecutorServiceExtension extends TypeBasedParameterResolver<ExecutorService> implements BeforeAllCallback {

    private static final Namespace NAMESPACE = Namespace.create(ExecutorServiceExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) {
        context.getStore(NAMESPACE)
                .put(ExecutorServiceResource.class, new ExecutorServiceResource(Executors.newCachedThreadPool()));
    }

    @Override
    public ExecutorService resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE)
                .get(ExecutorServiceResource.class, ExecutorServiceResource.class)
                .executorService();
    }

    private record ExecutorServiceResource(ExecutorService executorService) implements CloseableResource {
        @Override
        public void close() throws Throwable {
            executorService.shutdownNow();
            boolean terminated = executorService.awaitTermination(5, SECONDS);
            assertTrue(terminated, "ExecutorService did not shut down within timeout of 5 seconds");
        }
    }
}
