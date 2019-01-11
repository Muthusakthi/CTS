package bazzifer.jobs.com.cts.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.provider.ContactsContract;

@Dao
public interface DaoAccess {
    @Insert
    Long insertTask(DAO note);


    @Query("SELECT * FROM DAO")
    LiveData<Contacts> fetchAllTasks();


    @Query("SELECT * FROM DAO WHERE id =:taskId")
    LiveData<Contacts> getTask(int taskId);


    @Update
    void updateTask(DAO note);


    @Delete
    void deleteTask(DAO note);

    //https://android.jlelse.eu/5-steps-to-implement-room-persistence-library-in-android-47b10cd47b24
}
