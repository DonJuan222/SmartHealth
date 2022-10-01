package com.example.project002.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class ServiceModel (
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val icon: String

)