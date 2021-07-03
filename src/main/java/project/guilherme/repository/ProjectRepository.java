package project.guilherme.repository;

import org.springframework.data.jpa.repository.Query;
import project.guilherme.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
    @Query(
            value = "SELECT projects.* FROM projects, user_in_project WHERE projects.id = user_in_project.project_id and user_in_project.user_id = ?1",
            nativeQuery = true)
    Iterable<ProjectModel> findByUserId(Long id);
}
