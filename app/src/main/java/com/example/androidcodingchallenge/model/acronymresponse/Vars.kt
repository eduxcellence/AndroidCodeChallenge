package com.example.androidcodingchallenge.model.acronymresponse
/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/**
 * `Vars` is a data class with three properties: `lf`, `freq`, and `since`.
 *
 * The `lf` property is a `String` that is nullable. The `freq` property is an `Int` that is nullable.
 * The `since` property is an `Int` that is nullable.
 *
 * The `lf` property has a default value of `null`. The `freq` property has a default value of `null`.
 * The `since` property has a default value of `null`.
 * @property {String?} lf - The language filter.
 * @property {Int?} freq - The frequency of the word in the corpus.
 * @property {Int?} since - The number of days since the last time the user was active.
 */
data class Vars(var lf: String? = null, var freq: Int? = null, var since: Int? = null)