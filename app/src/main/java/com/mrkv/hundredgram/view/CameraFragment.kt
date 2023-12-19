package com.mrkv.hundredgram.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrkv.hundredgram.databinding.FragmentCameraBinding
import com.mrkv.hundredgram.viewmodel.CameraViewModel

class CameraFragment : Fragment() {

    private var binding: FragmentCameraBinding? = null
    private val viewModel = CameraViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding!!.root
    }

}