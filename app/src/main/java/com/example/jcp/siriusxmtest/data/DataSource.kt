package com.example.jcp.siriusxmtest.data

import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by jacp on 5/23/2018.
 */
interface DataSource {
    fun getCards(startIndex: Int): Single<ApiResponse>
}