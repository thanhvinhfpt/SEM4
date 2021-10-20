package com.keysoft.maithanhvinh;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeedBackDao {
    @Insert(onConflict = REPLACE)
    void insertFeedBack(FeedBack model);

    @Query("Select * from Feedback")
    List<FeedBack> listFeedBack();
}
