package edu.matc.persistence;

import edu.matc.entity.Storable;

import java.util.List;

public interface DataCRUDable {
    List<Storable> retrieveAllRecords(String tableName);
    Storable addRecord(Storable recordToAdd);
    Storable selectSingleRecord(String PKOfRecord);
    void updateRecord(Storable recordToUpdate);
    void deleteRecord(String PKOfRecord);
    List<Storable> getRecordBySearchType(String searchTerm, String searchType);
}
