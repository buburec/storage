package datalayer.daointerface;

import datalayer.data.Occupation;

import java.util.List;

/**
 * The OccupationDAO interface defines methods for retrieving occupation-related data from the database.
 */
public interface OccupationDAO {

    /**
     * Retrieves a list of all occupation data.
     *
     * @return a list of Occupation objects representing all occupations
     */
    List<Occupation> getOccupationData();
}
