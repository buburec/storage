package datalayer.data;

import java.sql.Date;

public class Request {
    private int identifier;
    private String truckModel;
    private String topic;
    private Date sentDate;
    private String resolver;
    private String status;
    private String commentary;
    private String resolverResponse;
    private String truckIdentifier;

    public Request(int identifier, String truckIdentifier, String commentary, String topic, String status, String resolverResponse, String resolver) {
        this.identifier = identifier;
        this.topic = topic;
        this.status = status;
        this.commentary = commentary;
        this.resolverResponse = resolverResponse;
        this.truckIdentifier = truckIdentifier;
        this.resolver = resolver;
    }

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

    public String getIdentifier() {
        return String.format("%010d", identifier);
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

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getResolverResponse() {
        return resolverResponse;
    }

    public void setResolverResponse(String resolverResponse) {
        this.resolverResponse = resolverResponse;
    }

    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }
}
