package com.example.project002.interfaces

import com.example.project002.data.models.ServiceModel

interface OnServiceClickListener {
    fun onClick(item: ServiceModel)
}