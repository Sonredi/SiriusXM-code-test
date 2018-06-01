package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class SearchInfo(
    @SerializedName("textSnippet") var textSnippet: String
)