package com.example.labo07_00301417.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo07_00301417.Database.Githubrepo
import com.example.labo07_00301417.Database.RoomDatabase
import com.example.labo07_00301417.Repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel (app:Application): AndroidViewModel (app) {
    private val repository : GitHubRepository

    init {
        val repoDao = RoomDatabase.getInstance(app).repoDao()
        repository = GitHubRepository(repoDao)
    }

    fun insert (repo:Githubrepo) = viewModelScope.launch (Dispatchers.IO) {
        repository.insert(repo)
    }

    fun getAll ():LiveData<List<Githubrepo>> = repository.getAll()

    fun nukeAll () = repository.nuke()
}