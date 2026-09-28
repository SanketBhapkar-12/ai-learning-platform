package ai_learning_platform.service;

import ai_learning_platform.dto.CourseProgressResponse;
import ai_learning_platform.dto.LearnerProgressResponse;
import ai_learning_platform.dto.ModuleProgressResponse;
import ai_learning_platform.model.Module;
import ai_learning_platform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearnerProgressService {

    private final CourseProgressService courseProgressService;
    private final ModuleProgressService moduleProgressService;
    private final ModuleRepository moduleRepository;

    public LearnerProgressService(
            CourseProgressService courseProgressService,
            ModuleProgressService moduleProgressService,
            ModuleRepository moduleRepository) {

        this.courseProgressService = courseProgressService;
        this.moduleProgressService = moduleProgressService;
        this.moduleRepository = moduleRepository;
    }

    public LearnerProgressResponse getLearnerProgress(
            String learnerId,
            String courseId) {

        CourseProgressResponse courseProgress =
                courseProgressService.getCourseProgress(
                        learnerId,
                        courseId
                );

        List<Module> modules =
                moduleRepository.findByCourseId(courseId);

        List<ModuleProgressResponse> moduleProgressList =
                new ArrayList<>();

        for (Module module : modules) {

            ModuleProgressResponse moduleProgress =
                    moduleProgressService.getModuleProgress(
                            learnerId,
                            module.getId()
                    );

            moduleProgressList.add(moduleProgress);
        }

        return new LearnerProgressResponse(
                courseProgress.getCourseId(),
                courseProgress.getLearnerId(),
                courseProgress.getTotalLessons(),
                courseProgress.getCompletedLessons(),
                courseProgress.getProgressPercentage(),
                moduleProgressList
        );
    }
}