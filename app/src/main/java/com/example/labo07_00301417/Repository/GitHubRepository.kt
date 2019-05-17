package com.example.labo07_00301417.Repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.labo07_00301417.Database.Githubrepo
import com.example.labo07_00301417.Database.githubDAO

class GitHubRepository (private val repoDao: githubDAO) {
    suspend fun insert (repo:Githubrepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<Githubrepo>> = repoDao.getallRepos()

    fun nuke () = repoDao.nukeTable()
}