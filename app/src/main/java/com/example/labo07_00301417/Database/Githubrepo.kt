package com.example.labo07_00301417.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
class Githubrepo (
    @ColumnInfo(name = "s_name")
    val name:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}