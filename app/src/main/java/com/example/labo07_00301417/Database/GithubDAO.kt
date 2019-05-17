package com.example.labo07_00301417.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface githubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: Githubrepo)

    @Query("SELECT * FROM repos")
    fun getallRepos():LiveData<List<Githubrepo>>

    @Query("DELETE FROM REPOS")
    fun nukeTable()
}