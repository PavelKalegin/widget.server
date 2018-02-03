package app.visitor;

import org.hibernate.id.GUIDGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "visitor")
public class VisitorEntity {

    @Id
    private String id;
    private String name;
    private Integer roomId;
    private boolean active;


    public VisitorEntity(){
        this.id = UUID.randomUUID().toString();
        this.active = true;
    }

    public VisitorEntity(String name, Integer roomId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.roomId = roomId;
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
