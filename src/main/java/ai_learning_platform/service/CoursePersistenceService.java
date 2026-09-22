package ai_learning_platform.service;

import ai_learning_platform.dto.GeneratedCourse;
import ai_learning_platform.dto.GeneratedLesson;
import ai_learning_platform.dto.GeneratedModule;
import ai_learning_platform.model.Course;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.model.Module;
import ai_learning_platform.repository.CourseRepository;
import ai_learning_platform.repository.LessonRepository;
import ai_learning_platform.repository.ModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CoursePersistenceService {

    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;

    public CoursePersistenceService(
            CourseRepository courseRepository,
            ModuleRepository moduleRepository,
            LessonRepository lessonRepository) {

        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public Course saveGeneratedCourse(GeneratedCourse generatedCourse) {

        Course course = new Course(
                generatedCourse.getTitle(),
                generatedCourse.getDescription(),
                generatedCourse.getTopic(),
                generatedCourse.getDifficulty(),
                generatedCourse.getDurationInDays()
        );

        Course savedCourse = courseRepository.save(course);

        for (GeneratedModule generatedModule : generatedCourse.getModules()) {

            Module module = new Module(
                    savedCourse.getId(),
                    generatedModule.getTitle(),
                    generatedModule.getDescription(),
                    generatedModule.getOrder()
            );

            Module savedModule = moduleRepository.save(module);

            for (GeneratedLesson generatedLesson : generatedModule.getLessons()) {

                Lesson lesson = new Lesson(
                        savedModule.getId(),
                        generatedLesson.getTitle(),
                        generatedLesson.getContent(),
                        generatedLesson.getTopic(),
                        generatedLesson.getOrder(),
                        generatedLesson.getEstimatedMinutes()
                );

                lessonRepository.save(lesson);
            }
        }

        return savedCourse;
    }
}