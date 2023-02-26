package com.example.androidcodingchallenge.utils

/**
 * Created by Akash Kumar on 27/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/**
 * This is a singleton class.
This class do validations for the following cases:

1. Empty case
2. Minimum length case
3. Valid case */
object TextUtils {

    /**
     * The function takes a string as an argument and returns a string
     *
     * @param word The word to be validated.
     * @return A String
     */
    fun isAcronymValid(word: String): String {
        return if (word.isEmpty())
            AppConstants.REQUIRED_FIELD
        else if (word.length < 3)
            AppConstants.MIN_KEYWORD_VALIDATION
        else
            AppConstants.VALID
    }
}