package app.visitor;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitorRepository extends CrudRepository<VisitorEntity, String> {
    Set<VisitorEntity> findByRoomId(Integer roomId);
}
