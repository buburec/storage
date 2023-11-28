package datalayer.data;

public class Truck {
    private String truckIdentifier;
    private String model;

    private String host;

    public Truck(String truckIdentifier, String model) {
        this.truckIdentifier = truckIdentifier;
        this.model = model;
    }

    public Truck(String truckIdentifier, String model, String host) {
        this.truckIdentifier = truckIdentifier;
        this.model = model;
        this.host = host;
    }

    public Truck(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }

    public String getTruckIdentifier() {
        return truckIdentifier;
    }

    public void setTruckIdentifier(String truckIdentifier) {
        this.truckIdentifier = truckIdentifier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
