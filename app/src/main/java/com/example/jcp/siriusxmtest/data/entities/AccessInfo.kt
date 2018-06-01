package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class AccessInfo(
    @SerializedName("country") var country: String,
    @SerializedName("viewability") var viewability: String,
    @SerializedName("embeddable") var embeddable: Boolean,
    @SerializedName("publicDomain") var publicDomain: Boolean,
    @SerializedName("textToSpeechPermission") var textToSpeechPermission: String,
    @SerializedName("epub") var epub: Epub,
    @SerializedName("pdf") var pdf: Pdf,
    @SerializedName("webReaderLink") var webReaderLink: String,
    @SerializedName("accessViewStatus") var accessViewStatus: String,
    @SerializedName("quoteSharingAllowed") var quoteSharingAllowed: Boolean
)