package com.example.androidcodingchallenge.data

import com.example.androidcodingchallenge.model.acronymresponse.AcronymResponse
import com.example.androidcodingchallenge.service.ApiService

/**
 * Created by Akash Kumar on 26/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
class DataRepository constructor(private val apiService: ApiService) {

    /**
     * If the response is successful, return a Success result with the response body, otherwise return
     * a Failure result with the response
     *
     * @param acronym The acronym to search for.
     * @return Result<List<AcronymResponse>>
     */
    suspend fun searchAcronym(acronym: String): Result<List<AcronymResponse>> {
        val response = apiService.searchAcronym(acronym)
        print(response)
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                Result.Success(responseBody)
            } else {
                Result.Failure(response)
            }
        } else {
            Result.Failure(response)
        }
    }
}