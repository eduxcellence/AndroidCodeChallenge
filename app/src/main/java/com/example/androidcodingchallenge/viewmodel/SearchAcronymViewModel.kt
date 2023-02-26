package com.example.androidcodingchallenge.viewmodel

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcodingchallenge.data.DataRepository
import com.example.androidcodingchallenge.data.Result
import com.example.androidcodingchallenge.model.acronymresponse.AcronymResponse
import com.example.androidcodingchallenge.service.ApiManager
import com.example.androidcodingchallenge.service.ApiService
import com.example.androidcodingchallenge.utils.AppConstants
import kotlinx.coroutines.*
import java.net.UnknownHostException

/**
 * Created by Akash Kumar on 26/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */

/* It's a ViewModel class that has a method to search for an acronym and it has two LiveData variables
to hold the result of the search */
class SearchAcronymViewModel : ViewModel() {


    //instances
    private val apiManager by lazy { ApiManager.getInstance() }
    private val dataRepository by lazy { DataRepository(apiManager) }

    //resultState
    var errorMessage = MutableLiveData<String>()
    var networkErrorMessage = MutableLiveData<String>()
    var acronymResponse = MutableLiveData<AcronymResponse>()

    //job
    private var job: Job? = null

    //progress variable
    var isSearching = MutableLiveData(View.GONE)
    var isNoResultFound = MutableLiveData(View.GONE)


    /**
     * It searches for an acronym and returns the result.
     *
     * @param query The acronym to search for.
     */
    fun searchAcronym(query: String) {
        isSearching.postValue(View.VISIBLE)
        job = CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                try {
                    when (val response = dataRepository.searchAcronym(query)) {
                        is Result.Success -> {
                            response.data?.let { onSuccess(it) }
                        }
                        is Result.Failure -> {
                            onFailure(response.toString())
                        }
                    }
                } catch (ex: UnknownHostException) {
                    onNetworkFailure(ex.stackTraceToString())
                }catch (ex: java.lang.Exception) {
                    onFailure(ex.stackTraceToString())
                }
            }
        }
    }

    private fun onNetworkFailure(stackTraceToString: String) {
        networkErrorMessage.value = AppConstants.NO_INTERNET_CONNECTION
        isSearching.postValue(View.GONE)
        isNoResultFound.postValue(View.GONE)
    }


    /**
     * A function that is called when the API call is successful. It checks if the response is not
     * empty and if it is not empty, it sets the acronymResponse value to the first element of the
     * response list. If the response is empty, it sets the isNoResultFound value to View.GONE.
     *
     * @param response The response from the server.
     */
    private fun onSuccess(response: List<AcronymResponse>) {
        if (response.isNotEmpty()) {
            acronymResponse.value = response[0]
            isNoResultFound.postValue(View.GONE)
        } else {
            isNoResultFound.postValue(View.VISIBLE)
        }

        isSearching.postValue(View.GONE)
    }


    /**
     * It sets the error message and hides the progress bar and no result found text.
     *
     * @param message The error message to be displayed
     */
    private fun onFailure(message: String) {
        errorMessage.value = message
        isSearching.postValue(View.GONE)
        isNoResultFound.postValue(View.GONE)
    }

    /**
     * It cancels the job when the viewmodel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
        isSearching.postValue(View.GONE)
        isNoResultFound.postValue(View.GONE)
    }


}