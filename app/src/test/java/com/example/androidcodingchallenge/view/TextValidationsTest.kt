package com.example.androidcodingchallenge.view

import com.example.androidcodingchallenge.utils.AppConstants
import com.example.androidcodingchallenge.utils.TextUtils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Akash Kumar on 27/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/* This class tests the TextUtils class for the following cases:

1. Empty case
2. Minimum length case
3. Valid case */
@RunWith(JUnit4::class)
class TextValidationsTest {
    @Test
    fun testAcronymEmptyCase() {
        val acronym = "" //FOR EMPTY CASE
        Assert.assertEquals(AppConstants.REQUIRED_FIELD, TextUtils.isAcronymValid(acronym))
    }

    @Test
    fun testAcronymMinLengthCase() {
        val acronym = "He"  // FOR MIN VALIDATION CASE
        Assert.assertEquals(AppConstants.MIN_KEYWORD_VALIDATION, TextUtils.isAcronymValid(acronym))
    }


    @Test
    fun testAcronymValidCase() {
        val acronym = "Hello"   //FOR SUCCESS CASE
        Assert.assertEquals(AppConstants.VALID, TextUtils.isAcronymValid(acronym))
    }

}