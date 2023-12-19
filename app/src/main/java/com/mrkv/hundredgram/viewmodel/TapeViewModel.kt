package com.mrkv.hundredgram.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import coil.ImageLoader
import coil.request.ImageRequest
import com.mrkv.hundredgram.model.TapeDataModel

class TapeViewModel(application: Application) : AndroidViewModel(application) {

    private val context by lazy { application.applicationContext }
    private val imageLoader = ImageLoader(context)
    private var drawable: Drawable? = null
    private val model = TapeDataModel(drawable, "my photo", false)

    val photoLiveData = MutableLiveData<Drawable?>()
    val textLiveData = MutableLiveData<String>()

    private val request = ImageRequest.Builder(context)
        .data("https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/215e17186161641.Y3JvcCw4NDAsNjU3LDI4NSwyMDg.jpg")
        .target { drawable ->
            photoLiveData.postValue(drawable)
            model.photo = drawable
        }
        .build()

    val disposable = imageLoader.enqueue(request)


    fun getUpdatedUI() {
        val updatedPhoto = model.photo
        val updatedText = model.text
        val updatedLike = model.isLiked

        photoLiveData.postValue(updatedPhoto)
        textLiveData.postValue(updatedText)
    }
}