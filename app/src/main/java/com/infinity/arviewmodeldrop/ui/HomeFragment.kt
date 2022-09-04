@file:Suppress("DEPRECATION")

package com.infinity.arviewmodeldrop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.infinity.arviewmodeldrop.R
import com.infinity.arviewmodeldrop.databinding.FragmentHomeBinding
import kotlin.system.exitProcess

class HomeFragment : androidx.fragment.app.Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuViewFragment)
        }

        binding.btinfo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_informationFragment)
        }

        binding.btmap.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapsFragment)
        }
    }

    override fun onResume() {
        super.onResume()

        var timeBack: Long = 0
        requireView().isFocusableInTouchMode = true
        requireView().requestFocus()
        requireView().setOnKeyListener { _, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_UP && i == KeyEvent.KEYCODE_BACK) {
                if (System.currentTimeMillis() - timeBack > 1000) {
                    timeBack = System.currentTimeMillis()
                    Toast.makeText(requireContext(), "Press Again To Exit App", Toast.LENGTH_LONG)
                        .show()
                } else {
                    exitProcess(0)
                }
                true
            } else false
        }
    }
}
