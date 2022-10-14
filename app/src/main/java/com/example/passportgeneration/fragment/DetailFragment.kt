package com.example.passportgeneration.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.passportgeneration.R
import com.example.passportgeneration.database.Entity
import com.example.passportgeneration.databinding.FragmentDetailBinding
import com.example.passportgeneration.util.toBitmap


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var entity: Entity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entity = arguments?.getParcelable("entity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        entity?.let {
            binding.imageView.setImageBitmap(it.image.toBitmap())
            binding.textView.text = "${it.lastName} \n ${it.name} \n ${it.middleName}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}