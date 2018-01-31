package app.chat;

import javax.validation.constraints.NotNull;

public class MessageModel {
    @NotNull
    private final String roomID;

    @NotNull
    private final String visitorID;

    @NotNull
    private final String message;

    public MessageModel(String roomID, String visitorID, String message ) {
        this.roomID = roomID;
        this.visitorID = visitorID;
        this.message = message;

    }

    public MessageModel() {
        this.message = "";
        this.visitorID = "";
        this.roomID = "";
    }

    public String getMessage() {
        return message;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public String getRoomID() {
        return roomID;
    }
}
