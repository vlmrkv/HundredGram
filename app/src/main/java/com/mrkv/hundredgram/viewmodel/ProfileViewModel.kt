package com.mrkv.hundredgram.viewmodel

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import coil.ImageLoader
import coil.request.ImageRequest
import com.mrkv.hundredgram.model.ProfileGridDataModel

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val context by lazy { application.applicationContext }
    private val imageLoader = ImageLoader(context)
    private val image: Drawable? = null
    private val model = ProfileGridDataModel(image)

    val imageGridLiveData = MutableLiveData<Drawable?>()
    private val imageList = listOf(
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/ad5230185617283.Y3JvcCwzNzAwLDI4OTQsMCwzNg.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/215e17186161641.Y3JvcCw4NDAsNjU3LDI4NSwyMDg.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/35c522151900917.Y3JvcCwxNDAwLDEwOTUsMCww.png",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/be96ee185323757.Y3JvcCwxNTAwLDExNzMsMCwxMTU.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/7c92d9186164513.Y3JvcCwxNDAwLDEwOTUsMCw1NzU.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/88a37a163494339.Y3JvcCwxMTg0LDkyNiw3MDksMzk4.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/fa8418186076417.Y3JvcCwxNDAwLDEwOTUsMCwxNzM.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/f49f1a184641663.Y3JvcCwxNjkwLDEzMjIsMTQ2LDA.png",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/f4a5a5185772403.Y3JvcCwyNTYwLDIwMDIsMCwyNzg.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/d79524179541101.Y3JvcCwxMTgwLDkyMyw1MjMsNzM.png",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/0c75f8185283055.Y3JvcCw3NDksNTg2LDMzMiw1OQ.jpg",
        "https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/2683ce179283483.Y3JvcCwxMzQyLDEwNTAsMjksMA.png"
    )

    private val request = ImageRequest.Builder(context)
        .data(imageList)
        .target { drawable ->
            imageGridLiveData.postValue(drawable)
            model.image = drawable
        }
        .build()

    val disposable = imageLoader.enqueue(request)

    fun getUpdatedUI() {
        val updatedPhoto = model.image

        imageGridLiveData.postValue(updatedPhoto)
    }

}