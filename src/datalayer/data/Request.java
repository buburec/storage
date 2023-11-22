package datalayer.data;

import java.sql.Date;

public class Request {
    private int identifier;
    private String truckModel;
    private String topic;
    private Date sentDate;
    private String resolver;
    private String status;

    public Request(int identifier, String truckModel, String topic, Date sentDate, String resolver, String status) {
        this.identifier = identifier;
        this.truckModel = truckModel;
        this.topic = topic;
        this.sentDate = sentDate;
        this.resolver = resolver;
        this.status = status;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getTruckModel() {
        return truckModel;
    }

    public String getTopic() {
        return topic;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getResolver() {
        return resolver;
    }

    public String getStatus() {
        return status;
    }
}
