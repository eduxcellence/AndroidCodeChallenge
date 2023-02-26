package com.example.androidcodingchallenge.model.acronymresponse
/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/**
 * `AcronymResponse` is a data class that has two properties: `sf` and `lfs`.
 *
 * `sf` is a nullable string. `lfs` is an array list of `Lfs` objects.
 *
 * `Lfs` is a data class that has three properties: `lf`, `freq`, and `since`.
 *
 * `lf` is a string. `freq` is an integer. `since` is an integer.
 * @property {String?} sf - The short form of the acronym.
 * @property {ArrayList<Lfs>} lfs - An array of Lfs objects.
 */
data class AcronymResponse(var sf: String? = null, var lfs: ArrayList<Lfs> = arrayListOf())