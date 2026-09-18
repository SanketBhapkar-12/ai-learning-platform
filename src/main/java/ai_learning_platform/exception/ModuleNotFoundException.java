package ai_learning_platform.exception;

public class ModuleNotFoundException extends RuntimeException {

    public ModuleNotFoundException(String moduleId) {
        super("Module not found: " + moduleId);
    }
}
