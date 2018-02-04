package app.chat;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "message")
public class MessageEntity {
    @Id
    private String id;

    private Date timestamp;

    private String visitorId;

    private Integer roomId;

    private Integer customerId;

    private String text;

    public MessageEntity(@NotNull Integer roomId, @Nullable Integer customerId, @NotNull String visitorId, @NotNull String text ) {
        this.id = UUID.randomUUID().toString();
        this.roomId = roomId;
        this.visitorId = visitorId;
        this.text = text;
        this.customerId = customerId;
        this.timestamp = new Date();
    }

    public MessageEntity() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
    }

    //region Getters
    public String getText() {
        return text;
    }

    public String getVisitorId() {

        return visitorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    //endregion
}
