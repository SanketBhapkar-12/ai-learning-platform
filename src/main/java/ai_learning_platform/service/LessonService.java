package ai_learning_platform.service;

import ai_learning_platform.exception.ModuleNotFoundException;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.repository.LessonRepository;
import ai_learning_platform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;

    public LessonService(
            LessonRepository lessonRepository,
            ModuleRepository moduleRepository) {

        this.lessonRepository = lessonRepository;
        this.moduleRepository = moduleRepository;
    }

    public Lesson createLesson(Lesson lesson) {

        boolean moduleExists =
                moduleRepository.existsById(lesson.getModuleId());

        if (!moduleExists) {
            throw new ModuleNotFoundException(lesson.getModuleId());
        }

        return lessonRepository.save(lesson);
    }

    public List<Lesson> getAllLessons() {

        return lessonRepository.findAll();
    }

    public List<Lesson> getLessonsByModuleId(
            String moduleId) {

        return lessonRepository.findByModuleId(moduleId);
    }

    public List<Lesson> getLessonsByTopic(
        String topic) {

        return lessonRepository.findByTopicStartingWith(topic);
    }
}