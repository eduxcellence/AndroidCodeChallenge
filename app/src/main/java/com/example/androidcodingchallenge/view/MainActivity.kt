package com.example.androidcodingchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidcodingchallenge.R
import com.example.androidcodingchallenge.adapter.SearchAcronymAdapter
import com.example.androidcodingchallenge.databinding.ActivityMainBinding
import com.example.androidcodingchallenge.utils.AppConstants
import com.example.androidcodingchallenge.utils.TextUtils
import com.example.androidcodingchallenge.viewmodel.SearchAcronymViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */

/* This class is responsible for observing the data from the ViewModel and updating the UI accordingly */
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    /**
     * Search acronym view model
     */
    lateinit var searchAcronymViewModel: SearchAcronymViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The layout for this activity is a Data Binding layout so it needs to be inflated using
        // DataBindingUtil.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /* This is a way to get the instance of the ViewModel. */
        searchAcronymViewModel =
            ViewModelProvider(
                this,
            )[SearchAcronymViewModel::class.java]
        binding.searchAcronymViewModel = searchAcronymViewModel
        binding.lifecycleOwner = this

        /* This is a way to get the instance of the ViewModel using let scope function. */
        searchAcronymViewModel.let {
            //HANDLE SUCCESS STATE OF ACRONYM RESPONSE
            it.acronymResponse.observe(this) {
                binding.rvAcronym.adapter = SearchAcronymAdapter(it.lfs)
            }
            //HANDLE FAILURE STATE OF ACRONYM RESPONSE
            it.errorMessage.observe(this) {
                Snackbar.make(binding.root, it.toString(), Snackbar.LENGTH_SHORT).show()
            }
            //HANDLE NETWORK FAILURE STATE OF ACRONYM RESPONSE
            it.networkErrorMessage.observe(this) {
                Snackbar.make(binding.root, it.toString(), Snackbar.LENGTH_SHORT).show()
            }
            //HANDLE NO RESULT FOUND STATE OF ACRONYM RESPONSE
            it.isNoResultFound.observe(this) {
                if (it == View.VISIBLE) {
                    binding.rvAcronym.adapter = SearchAcronymAdapter(searchAcronymLfsList = null)
                }

            }
        }



        /* This is a way to observe the text change in the EditText. */
        binding.etAcronym.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (TextUtils.isAcronymValid(s.toString().trim())!=AppConstants.REQUIRED_FIELD) {
                        binding.tlAcronym.error = null
                        if (TextUtils.isAcronymValid(s.toString().trim())!=AppConstants.MIN_KEYWORD_VALIDATION) {
                            binding.tlAcronym.error = null
                            searchAcronymViewModel.searchAcronym(s.toString())
                        } else {

                            with(binding) {
                                tlAcronym.error = AppConstants.MIN_KEYWORD_VALIDATION
                                binding.rvAcronym.adapter =
                                    SearchAcronymAdapter(searchAcronymLfsList = null)
                            }
                        }
                    } else binding.tlAcronym.error = AppConstants.REQUIRED_FIELD
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}