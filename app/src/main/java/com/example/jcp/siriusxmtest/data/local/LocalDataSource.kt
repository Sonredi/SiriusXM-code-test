package com.example.jcp.siriusxmtest.data.local

import com.example.jcp.siriusxmtest.data.DataSource
import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by jacp on 5/23/2018.
 */
class LocalDataSource : DataSource {
    override fun getCards(startIndex: Int): Single<ApiResponse> {
        return Single.never()
    }
}