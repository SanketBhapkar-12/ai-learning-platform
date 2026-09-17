package ai_learning_platform.repository;

import ai_learning_platform.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LessonRepository extends MongoRepository<Lesson, String> {

    List<Lesson> findByModuleId(String moduleId);
}