package com.example.androidcodingchallenge.data

import retrofit2.Response

/**
 * Created by Akash Kumar on 26/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/* It's a sealed class that can be either a Success or a Failure */
sealed class Result<out T> {
    /**
     * `Result` is a sealed class with two subclasses: `Success` and `Failure`.
     *
     * `Success` is a data class that takes a generic type `T` and has a single property `data` of type
     * `T?`.
     *
     * `Failure` is a data class that takes a generic type `T` and has a single property `error` of
     * type `Response<T>`.
     *
     * `Response<T>` is a class that takes a generic type `T` and has two properties: `code` of type
     * `Int` and `message` of
     * @property {T?} data - The data that was returned from the API call.
     */
    data class Success<out T>(val data: T?) : Result<T>()
    data class Failure<T>(val error: Response<T>) : Result<T>()
}