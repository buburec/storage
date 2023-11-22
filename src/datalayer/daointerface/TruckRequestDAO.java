package datalayer.daointerface;

import datalayer.data.Request;

import java.util.List;

public interface TruckRequestDAO {
    List<Request> getDriverRequestList(String host_identifier);
}
