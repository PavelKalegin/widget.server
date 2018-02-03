package app.room;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoomRepository extends CrudRepository<RoomEntity, Integer>
{
    Set<RoomEntity> findByCustomerId(Integer customerId);
}
