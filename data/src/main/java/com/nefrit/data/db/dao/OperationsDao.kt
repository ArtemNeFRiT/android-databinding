package com.nefrit.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.nefrit.data.db.model.OperationLocal

@Dao
abstract class OperationsDao {

    @Query("DELETE FROM operations")
    abstract fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addPoints(points: List<OperationLocal>)
}