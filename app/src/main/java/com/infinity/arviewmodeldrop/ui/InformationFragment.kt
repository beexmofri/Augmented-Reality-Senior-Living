package com.infinity.arviewmodeldrop.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.navigation.fragment.findNavController
import com.infinity.arviewmodeldrop.R
import com.infinity.arviewmodeldrop.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {
    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!
    private var videoPlayer: VideoView? = null
    private var videoController: MediaController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoPlayer = binding.videoView
        configureVideoPlayer()

        binding.btjurnal.setOnClickListener {
            findNavController().navigate(R.id.action_informationFragment_to_webFragment)
        }
    }

    private fun configureVideoPlayer() {
        if (videoController == null) {
            videoController = MediaController(requireContext())
            videoController!!.setAnchorView(this.videoPlayer)
        }

        videoPlayer!!.setMediaController(videoController)

        videoPlayer!!.setVideoURI(
            Uri.parse(
                "android.resource://" + context?.packageName + "/" + R.raw.sampang
            )
        )

        videoPlayer!!.requestFocus()

        videoPlayer!!.pause()

        videoPlayer!!.setOnErrorListener { sp, what, extra ->
            Toast.makeText(requireContext(), "Getting Error", Toast.LENGTH_SHORT).show()
            false

        }

        videoPlayer!!.setOnCompletionListener {

            Toast.makeText(requireContext(), "Video Completed", Toast.LENGTH_SHORT).show()
        }

        videoPlayer!!.setOnPreparedListener { sp ->
            videoPlayer!!.start()
            sp.setOnVideoSizeChangedListener { mp, width, height ->
                videoController = MediaController(requireContext())
                videoPlayer!!.setMediaController(videoController)
                videoController!!.setAnchorView(videoPlayer)
            }
        }
    }
}