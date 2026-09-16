package ai_learning_platform.service;

import ai_learning_platform.model.Module;
import ai_learning_platform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public List<Module> getModulesByCourseId(String courseId) {
        return moduleRepository.findByCourseId(courseId);
    }
}