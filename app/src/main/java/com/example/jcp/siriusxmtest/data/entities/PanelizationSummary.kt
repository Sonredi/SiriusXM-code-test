package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class PanelizationSummary(
    @SerializedName("containsEpubBubbles") var containsEpubBubbles: Boolean,
    @SerializedName("containsImageBubbles") var containsImageBubbles: Boolean
)