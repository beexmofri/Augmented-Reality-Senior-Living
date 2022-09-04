package com.infinity.arviewmodeldrop.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infinity.arviewmodeldrop.databinding.FragmentMenuViewBinding

class MenuViewFragment : Fragment() {
    private var _binding: FragmentMenuViewBinding? = null
    private val binding get() = _binding!!
    private val link1: String =
        "https://firebasestorage.googleapis.com/v0/b/ar-project-f88a3.appspot.com/o/klinik.glb?alt=media&token=b80a4efd-53c4-4274-bcb1-42930e48ac3e"
    private val link2: String =
        "https://firebasestorage.googleapis.com/v0/b/ar-project-f88a3.appspot.com/o/auditorium.glb?alt=media&token=41dda9ba-a5de-4ef6-8310-42bd87b3465f"
    private val link3: String =
        "https://firebasestorage.googleapis.com/v0/b/ar-project-f88a3.appspot.com/o/home.glb?alt=media&token=cdfd003d-5afb-428c-b8ec-b85e5a3beca7"
    private val link4: String =
        "https://firebasestorage.googleapis.com/v0/b/ar-project-f88a3.appspot.com/o/Senior%20Living.glb?alt=media&token=37cbd89a-8cc5-4c7f-a5b8-df9eaccff6dd"
    private val link5: String =
        "https://firebasestorage.googleapis.com/v0/b/ar-project-f88a3.appspot.com/o/swim.glb?alt=media&token=74546d51-c169-40af-aac7-502076cc5134"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMenuViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)

        binding.btvdenah.setOnClickListener {
            sceneViewerIntent.data =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter(
                        "file",
                        link4
                    ).appendQueryParameter("title", "Denah Senior Living").build()
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            startActivity(sceneViewerIntent)
        }

        binding.btvklinik.setOnClickListener {
            sceneViewerIntent.data =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter(
                        "file",
                        link1
                    ).appendQueryParameter("title", "Fasilitas Klinik").build()
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            startActivity(sceneViewerIntent)
        }

        binding.btvauditorium.setOnClickListener {
            sceneViewerIntent.data =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter(
                        "file",
                        link2
                    ).appendQueryParameter("title", "Fasilitas Auditorium").build()
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            startActivity(sceneViewerIntent)
        }

        binding.btvhome.setOnClickListener {
            sceneViewerIntent.data =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter(
                        "file",
                        link3
                    ).appendQueryParameter("title", "Fasilitas Rumah").build()
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            startActivity(sceneViewerIntent)
        }

        binding.btvkolam.setOnClickListener {
            sceneViewerIntent.data =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                    .appendQueryParameter(
                        "file",
                        link5
                    ).appendQueryParameter("title", "Fasilitas Kolam Renang").build()
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            startActivity(sceneViewerIntent)
        }
    }
}