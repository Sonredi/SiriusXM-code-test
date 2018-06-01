package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class SaleInfo(
    @SerializedName("country") var country: String,
    @SerializedName("saleability") var saleability: String,
    @SerializedName("isEbook") var isEbook: Boolean
)