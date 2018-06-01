package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("kind") var kind: String,
    @SerializedName("id") var id: String,
    @SerializedName("etag") var etag: String,
    @SerializedName("selfLink") var selfLink: String,
    @SerializedName("volumeInfo") var volumeInfo: VolumeInfo,
    @SerializedName("saleInfo") var saleInfo: SaleInfo,
    @SerializedName("accessInfo") var accessInfo: AccessInfo,
    @SerializedName("searchInfo") var searchInfo: SearchInfo
)