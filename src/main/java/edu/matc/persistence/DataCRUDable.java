package edu.matc.persistence;

import edu.matc.entity.Storable;

import java.util.List;

/**
 * The interface Data cru dable.
 */
public interface DataCRUDable {
    /**
     * Retrieve all records list.
     *
     * @param tableName the table name
     * @return the list
     */
    List<Storable> retrieveAllRecords(String tableName);

    /**
     * Add record storable.
     *
     * @param recordToAdd the record to add
     * @param tableName   the table name
     * @return the storable
     */
    Storable addRecord(Storable recordToAdd, String tableName);

    /**
     * Select single record storable.
     *
     * @param primaryKeyOfRecord the primary key of record
     * @param tableName          the table name
     * @return the storable
     */
    Storable selectSingleRecord(int primaryKeyOfRecord, String tableName);

    /**
     * Update record.
     *
     * @param recordToUpdate the record to update
     * @param tableName      the table name
     */
    void updateRecord(Storable recordToUpdate, String tableName);

    /**
     * Delete record.
     *
     * @param primaryKeyOfRecord the primary key of record
     * @param tableName          the table name
     */
    void deleteRecord(int primaryKeyOfRecord, String tableName);

    /**
     * Gets record by search type.
     *
     * @param searchTerm the search term
     * @param searchType the search type
     * @param tableName  the table name
     * @return the record by search type
     */
    List<Storable> getRecordBySearchType(String searchTerm, String searchType, String tableName);
}
