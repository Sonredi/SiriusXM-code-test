package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class ReadingModes(
    @SerializedName("text") var text: Boolean,
    @SerializedName("image") var image: Boolean
)