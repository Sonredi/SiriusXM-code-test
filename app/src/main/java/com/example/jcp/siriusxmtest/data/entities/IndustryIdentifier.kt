package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class IndustryIdentifier(
    @SerializedName("type") var type: String,
    @SerializedName("identifier") var identifier: String
)