package datalayer.data;

import java.sql.Date;

/**
 * The Request class represents information about a specific request, including the request's
 * identifier, truck model, topic, sent date, resolver, status, commentary, resolver response,
 * and truck identifier.
 */
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

    /**
     * Constructs a new Request object with the specified identifier, truck identifier, commentary,
     * topic, status, resolver response, and resolver.
     *
     * @param identifier       the identifier of the request
     * @param truckIdentifier  the identifier of the associated truck
     * @param commentary       additional commentary for the request
     * @param topic            the topic of the request
     * @param status           the status of the request
     * @param resolverResponse the resolver's response to the request
     * @param resolver         the resolver (storekeeper) assigned to the request
     */
    public Request(int identifier, String truckIdentifier, String commentary, String topic, String status, String resolverResponse, String resolver) {
        this.identifier = identifier;
        this.topic = topic;
        this.status = status;
        this.commentary = commentary;
        this.resolverResponse = resolverResponse;
        this.truckIdentifier = truckIdentifier;
        this.resolver = resolver;
    }

    /**
     * Constructs a new Request object with the specified identifier, truck model, topic,
     * sent date, resolver, and status.
     *
     * @param identifier  the identifier of the request
     * @param truckModel  the model of the associated truck
     * @param topic       the topic of the request
     * @param sentDate    the date the request was sent
     * @param resolver    the resolver (storekeeper) assigned to the request
     * @param status      the status of the request
     */
    public Request(int identifier, String truckModel, String topic, Date sentDate, String resolver, String status) {
        this.identifier = identifier;
        this.truckModel = truckModel;
        this.topic = topic;
        this.sentDate = sentDate;
        this.resolver = resolver;
        this.status = status;
    }

    /**
     * Gets the formatted identifier of the request.
     *
     * @return the formatted identifier of the request
     */
    public String getIdentifier() {
        return String.format("%010d", identifier);
    }

    /**
     * Sets the identifier of the request.
     *
     * @param identifier the identifier to be set
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the truck model associated with the request.
     *
     * @return the truck model associated with the request
     */
    public String getTruckModel() {
        return truckModel;
    }

    /**
     * Sets the truck model associated with the request.
     *
     * @param truckModel the truck model to be set
     */
    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }

    /**
     * Gets the topic of the request.
     *
     * @return the topic of the request
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets the topic of the request.
     *
     * @param topic the topic to be set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Gets the date the request was sent.
     *
     * @return the date the request was sent
     */
    public Date getSentDate() {
        return sentDate;
    }

    /**
     * Sets the date the request was sent.
     *
     * @param sentDate the date to be set
     */
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * Gets the resolver assigned to the request.
     *
     * @return the resolver assigned to the request
     */
    public String getResolver() {
        return resolver;
    }

    /**
     * Sets the resolver assigned to the request.
     *
     * @param resolver the resolver to be set
     */
    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    /**
     * Gets the status of the request.
     *
     * @return the status of the request
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the request.
     *
     * @param status the status to be set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the commentary for the request.
     *
     * @return the commentary for the request
     */
    public String getCommentary() {
        return commentary;
    }

    /**
     * Sets the commentary for the request.
     *
     * @param commentary the commentary to be set
     */
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    /**
     * Gets the resolver's response to the request.
     *
     * @return the resolver's response to the request
     */
    public String getResolverResponse() {
        return resolverResponse;
    }

    /**
     * Sets the resolver's response to the request.
     *
     * @param resolverResponse the resolver's response to be set
     */
    public void setResolverResponse(String resolverResponse) {
        this.resolverResponse = resolverResponse;
    }

    /**
     * Gets the truck identifier associated with the request.
     *
     * @return the truck identifier associated with the request
     */
    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    /**
     * Sets the truck identifier associated with the request.
     *
     * @param truckIdentifier the truck identifier to be set
     */
    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }
}
