package edu.matc.persistence;

import edu.matc.entity.Storable;

import java.util.List;

public interface DataCRUDable {
    List<Storable> retrieveAllRecords(String tableName);
    Storable addRecord(Storable recordToAdd, String tableName);
    Storable selectSingleRecord(int primaryKeyOfRecord, String tableName);
    void updateRecord(Storable recordToUpdate, String tableName);
    void deleteRecord(int primaryKeyOfRecord, String tableName);
    List<Storable> getRecordBySearchType(String searchTerm, String searchType, String tableName);
}