package com.tatvasoftinterview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatvasoftinterview.json.UserItemResponseData
import com.tatvasoftinterview.repository.UserItemRepository
import kotlinx.coroutines.launch

class UserItemViewModel : ViewModel() {
    var userItemListLiveData = MutableLiveData<UserItemResponseData>()
    var userItemRepository = UserItemRepository()

    fun getUserItems(): MutableLiveData<UserItemResponseData> {
        return userItemListLiveData
    }

    fun fetchUserItems() {
        viewModelScope.launch {
            userItemListLiveData.postValue(userItemRepository.fetchUserData())
        }
    }
}