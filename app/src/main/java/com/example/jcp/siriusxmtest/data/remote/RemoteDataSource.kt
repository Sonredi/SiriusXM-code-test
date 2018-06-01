package com.example.jcp.siriusxmtest.data.remote

import com.example.jcp.siriusxmtest.data.DataSource
import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item
import com.example.jcp.siriusxmtest.data.remote.api.BooksService
import io.reactivex.Maybe
import io.reactivex.Single
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by jacp on 5/23/2018.
 */
class RemoteDataSource @Inject constructor(private val booksService: BooksService) : DataSource {
    override fun getCards(startIndex: Int): Single<ApiResponse> {
        //Todo pass the parameters as user input and implement pagination
//        return booksService.retrieveBooks("kotlin", 10).map { it -> it.response()?.body()?.items }
        return booksService.retrieveBooks("kotlin", 10, startIndex)
    }


}