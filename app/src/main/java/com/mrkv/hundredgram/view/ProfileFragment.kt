package com.mrkv.hundredgram.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import com.mrkv.hundredgram.R
import com.mrkv.hundredgram.databinding.FragmentProfileBinding
import com.mrkv.hundredgram.databinding.GridviewItemBinding
import com.mrkv.hundredgram.viewmodel.ProfileViewModel

class ProfileFragment(private val context: Context) : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private var bindingGridImage: GridviewItemBinding? = null
    private val viewModel: ProfileViewModel by activityViewModels()
    private val gridView: GridView? = null
    private val imageList: List<Drawable?> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = GridImageAdapter(imageList, context)
        gridView?.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentUpdateObserver()
    }

    private fun fragmentUpdateObserver() {
        viewModel.getUpdatedUI()

        viewModel.imageGridLiveData.observe(viewLifecycleOwner) { updatedPhoto ->
            bindingGridImage?.gridImage?.setImageDrawable(updatedPhoto)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        bindingGridImage = null
    }

    internal class GridImageAdapter(
        private val imageList: List<Drawable?>,
        private val context: Context
    ) : BaseAdapter() {

        private var layoutInflater: LayoutInflater? = null
        private lateinit var image: ImageView
        override fun getCount(): Int {
            return imageList.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var returnView = convertView

            if (layoutInflater == null) {
                layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            }

            if (returnView == null) {
                returnView = layoutInflater!!.inflate(R.layout.gridview_item, GridView(context))
            }

            image = returnView!!.findViewById(R.id.grid_image)
            image.setImageDrawable(imageList.get(position))

            return returnView

        }
    }

}