package com.example.imgurcomposefinal.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imgurcomposefinal.domain.usecase.GetImg
import com.example.imgurcomposefinal.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImgurViewModel @Inject constructor(
    private val getImg: GetImg
) : ViewModel() {


    private val _state = mutableStateOf(DataState())
    val state: State<DataState> = _state

    init {
        loadImgur()
    }

    private fun loadImgur() = viewModelScope.launch {
        getImg().collect {
            when(it) {
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _state.value = state.value.copy(

                        imgList = it.data!!.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

}