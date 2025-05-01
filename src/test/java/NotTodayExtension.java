import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

class NotTodayExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        return AnnotationSupport.isAnnotated(context.getElement(), NotToday.class)
                ? ConditionEvaluationResult.disabled("Annotated with @NotToday")
                : ConditionEvaluationResult.enabled("Not annotated with @NotToday");
    }
}
