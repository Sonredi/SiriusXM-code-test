package com.example.jcp.siriusxmtest.data

import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item
import com.example.jcp.siriusxmtest.data.local.LocalDataSource
import com.example.jcp.siriusxmtest.data.remote.RemoteDataSource
import com.example.jcp.siriusxmtest.util.AppLogger
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by jacp on 5/23/2018.
 */
class DataRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                         private val localDataSource: LocalDataSource) : DataSource {
    // TODO: Implement localDataSource cache
    override fun getCards(startIndex: Int): Single<ApiResponse> {
        return remoteDataSource.getCards(startIndex).doOnError{AppLogger.e(it.toString())}
    }

}