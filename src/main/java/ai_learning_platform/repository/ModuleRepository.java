package ai_learning_platform.repository;

import ai_learning_platform.model.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModuleRepository extends MongoRepository<Module, String> {

    List<Module> findByCourseId(String courseId);
}