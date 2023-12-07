package com.mrkv.hundredgram.viewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coil.ImageLoader
import coil.executeBlocking
import coil.request.ImageRequest
import com.mrkv.hundredgram.model.DataModel

class TapeViewModel(context: Context) : ViewModel() {

    private val imageLoader = ImageLoader(context)
    private val request = ImageRequest.Builder(context)
        .data("https://img.freepik.com/free-photo/young-people-skateboarding-in-japan_23-2149331793.jpg")
        .build()
    private var drawable = imageLoader.executeBlocking(request).drawable
    private val model = DataModel(drawable, "my photo", false)

    val photoLiveData = MutableLiveData<Drawable?>()
    val textLiveData = MutableLiveData<String>()

    fun getUpdatedUI() {
        val updatedPhoto = model.photo
        val updatedText = model.text
        val updatedLike = model.isLiked

        photoLiveData.postValue(updatedPhoto)
        textLiveData.postValue(updatedText)
    }
}