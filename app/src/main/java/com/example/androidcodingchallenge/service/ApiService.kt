package com.example.androidcodingchallenge.service

import com.example.androidcodingchallenge.model.acronymresponse.AcronymResponse
import com.example.androidcodingchallenge.utils.ApiURLs.searchQuery
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/* It's an interface that defines method like POST/GET/PUT/DELETE whicch return response accordingly their required type*/
interface ApiService {

    @GET(searchQuery)
    suspend fun searchAcronym(@Query("sf") query: String): Response<List<AcronymResponse>>
}