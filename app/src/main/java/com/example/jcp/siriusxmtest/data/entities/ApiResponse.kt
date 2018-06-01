package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("kind") var kind: String,
    @SerializedName("totalItems") var totalItems: Int,
    @SerializedName("items") var items: List<Item>
)