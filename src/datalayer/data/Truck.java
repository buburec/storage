package datalayer.data;

/**
 * The Truck class represents information about a specific truck, including the truck identifier, model, and host.
 */
public class Truck {
    private String truckIdentifier;
    private String model;
    private String host;

    /**
     * Constructs a new Truck object with the specified truck identifier and model.
     *
     * @param truckIdentifier the identifier of the truck
     * @param model           the model of the truck
     */
    public Truck(String truckIdentifier, String model) {
        this.truckIdentifier = truckIdentifier;
        this.model = model;
    }

    /**
     * Constructs a new Truck object with the specified truck identifier, model, and host.
     *
     * @param truckIdentifier the identifier of the truck
     * @param model           the model of the truck
     * @param host            the host identifier associated with the truck
     */
    public Truck(String truckIdentifier, String model, String host) {
        this.truckIdentifier = truckIdentifier;
        this.model = model;
        this.host = host;
    }

    /**
     * Constructs a new Truck object with the specified truck identifier.
     *
     * @param truckIdentifier the identifier of the truck
     */
    public Truck(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }

    /**
     * Gets the truck identifier.
     *
     * @return the truck identifier
     */
    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    /**
     * Sets the truck identifier.
     *
     * @param truckIdentifier the truck identifier to be set
     */
    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }

    /**
     * Gets the model of the truck.
     *
     * @return the model of the truck
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the truck.
     *
     * @param model the model to be set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the host identifier associated with the truck.
     *
     * @return the host identifier associated with the truck
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host identifier associated with the truck.
     *
     * @param host the host identifier to be set
     */
    public void setHost(String host) {
        this.host = host;
    }
}
