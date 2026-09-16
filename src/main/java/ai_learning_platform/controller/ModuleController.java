package ai_learning_platform.controller;

import ai_learning_platform.dto.ModuleRequest;
import ai_learning_platform.dto.ModuleResponse;
import ai_learning_platform.model.Module;
import ai_learning_platform.service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public ModuleResponse createModule(@Valid @RequestBody ModuleRequest request) {

        Module module = new Module(
                request.getCourseId(),
                request.getTitle(),
                request.getDescription(),
                request.getOrder()
        );

        Module savedModule = moduleService.createModule(module);

        return convertToResponse(savedModule);
    }

    @GetMapping
    public List<ModuleResponse> getAllModules() {

        return moduleService.getAllModules()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @GetMapping("/course/{courseId}")
    public List<ModuleResponse> getModulesByCourseId(
            @PathVariable String courseId) {

        return moduleService.getModulesByCourseId(courseId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private ModuleResponse convertToResponse(Module module) {

        return new ModuleResponse(
                module.getId(),
                module.getCourseId(),
                module.getTitle(),
                module.getDescription(),
                module.getOrder()
        );
    }
}