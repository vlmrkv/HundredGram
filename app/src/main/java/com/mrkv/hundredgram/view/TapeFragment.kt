package com.mrkv.hundredgram.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mrkv.hundredgram.viewmodel.TapeViewModel
import com.mrkv.hundredgram.databinding.FragmentTapeBinding

class TapeFragment : Fragment() {

    private var binding: FragmentTapeBinding? = null
    private val viewModel: TapeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTapeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUpdateObserver()
    }

    private fun fragmentUpdateObserver() {
        viewModel.getUpdatedUI()

        viewModel.photoLiveData.observe(viewLifecycleOwner) { updatedPhoto ->
            binding?.imageOnTape?.setImageDrawable(updatedPhoto)
        }
        viewModel.textLiveData.observe(viewLifecycleOwner) { updatedText ->
            binding?.photoDescription?.text = updatedText
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}