package com.example.jcp.siriusxmtest.data.entities

import com.google.gson.annotations.SerializedName
data class VolumeInfo(
    @SerializedName("title") var title: String,
    @SerializedName("authors") var authors: List<String>,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("publishedDate") var publishedDate: String,
    @SerializedName("description") var description: String,
    @SerializedName("industryIdentifiers") var industryIdentifiers: List<IndustryIdentifier>,
    @SerializedName("readingModes") var readingModes: ReadingModes,
    @SerializedName("pageCount") var pageCount: Int,
    @SerializedName("printType") var printType: String,
    @SerializedName("categories") var categories: List<String>,
    @SerializedName("maturityRating") var maturityRating: String,
    @SerializedName("allowAnonLogging") var allowAnonLogging: Boolean,
    @SerializedName("contentVersion") var contentVersion: String,
    @SerializedName("panelizationSummary") var panelizationSummary: PanelizationSummary,
    @SerializedName("imageLinks") var imageLinks: ImageLinks,
    @SerializedName("language") var language: String,
    @SerializedName("previewLink") var previewLink: String,
    @SerializedName("infoLink") var infoLink: String,
    @SerializedName("canonicalVolumeLink") var canonicalVolumeLink: String
)