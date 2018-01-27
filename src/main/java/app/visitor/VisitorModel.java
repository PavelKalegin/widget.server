package app.visitor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitorModel {
    private String id;
    private String name;
    private Date singInDate;

    public String getsSingInDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(singInDate);
    }

    private String sSingInDate;

    public VisitorModel(){
        this.singInDate = new Date();
    }

    public VisitorModel(String id, String name) {
        this.id = id;
        this.name = name;
        this.singInDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSingInDate() {
        return singInDate;
    }

    public void setSingInDate(Date singInDate) {
        this.singInDate = singInDate;
    }
}
