package com.example.androidcodingchallenge.model.acronymresponse
/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/**
 * `Lfs` is a data class with four properties: `lf`, `freq`, `since`, and `vars`.
 *
 * The first three properties are nullable strings, and the last is an array of `Vars` objects.
 *
 * The `Vars` type is defined as follows:
 * @property {String?} lf - The word or phrase in the original language.
 * @property {Int?} freq - The number of times the word appears in the corpus.
 * @property {Int?} since - The year in which the word was first used.
 * @property {ArrayList<Vars>} vars - This is an array of objects that contain the following
 * properties:
 */
data class Lfs(
    var lf: String? = null,
    var freq: Int? = null,
    var since: Int? = null,
    var vars: ArrayList<Vars> = arrayListOf()
)