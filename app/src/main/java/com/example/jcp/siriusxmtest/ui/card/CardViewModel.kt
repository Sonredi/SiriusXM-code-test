package com.example.jcp.siriusxmtest.ui.card

import android.databinding.ObservableField
import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item

/**
 * Created by jacp on 5/23/2018.
 */
class CardViewModel(title: String?, thumbnail: String?, author: List<String>?) {

    val title = ObservableField<String>()
    val thumbnail = ObservableField<String>()
    val author = ObservableField<List<String>>()

    init {
        this.title.set(title ?: "")
        this.thumbnail.set(thumbnail ?: "")
        this.author.set(author ?: emptyList())
    }

    companion object {
        private const val ULR_DEFAULT = "https://dummyimage.com/300x300/ffffff/fff&text=Image+not+found"
        fun of(item: Item): CardViewModel {

            var thumbnail =
                    if (item.volumeInfo.imageLinks != null)
                        item.volumeInfo.imageLinks.smallThumbnail else ULR_DEFAULT
            return CardViewModel(item.volumeInfo.title,thumbnail, item.volumeInfo.authors)
        }
    }
}
