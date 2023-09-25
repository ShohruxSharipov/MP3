package com.example.mp3

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.mp3.databinding.FragmentSingleMusicBinding
import com.example.mp3.music.MP3

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SingleMusic.newInstance] factory method to
 * create an instance of this fragment.
 */
class SingleMusic : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null
    lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSingleMusicBinding.inflate(inflater, container, false)
        val musiclist2 = mutableListOf<MP3>()
        musiclist2.add(MP3("Don't be shy", R.raw.m1))
        musiclist2.add(MP3("New rules", R.raw.m2))
        musiclist2.add(MP3("We don't talk anymo", R.raw.m3))
        musiclist2.add(MP3("Dancin", R.raw.m4))
//        musiclist2.add(MP3("Bad habits",R.raw.m5))
        musiclist2.add(MP3("Shape of you", R.raw.m6))
        musiclist2.add(MP3("One kiss", R.raw.m7))
//        musiclist2.add(MP3("Rockby",R.raw.m8))
        musiclist2.add(MP3("Solitude", R.raw.m9))
        var a = param1!!
        media = MediaPlayer.create(requireContext(), musiclist2[a].music)
        binding.musname.text = musiclist2[a].name
        media.start()
        val thread = Thread()
        thread.start()

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(requireActivity(), object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Log.d("TAG", "Fragment back pressed invoked")
                    // Do custom work here
                    media.stop()
                    // if you want onBackPressed() to be called as normal afterwards
                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            }
            )




        binding.play.setOnClickListener {
            if (media.isPlaying) {
                media.pause()
                binding.play.setBackgroundResource(R.drawable.baseline_play_circle_24)
            } else {
                media.start()
                binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            }
        }

        binding.next.setOnClickListener {
            media.stop()
            if (a < musiclist2.size - 1) {
                a = a + 1
            } else a = 0
            media = MediaPlayer.create(requireContext(), musiclist2[a].music)
            binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            binding.musname.text = musiclist2[a].name
            media.start()

        }

        binding.prev.setOnClickListener {
            media.stop()
            if (a > 0) {
                a = a - 1
            } else a = musiclist2.size - 1
            media = MediaPlayer.create(requireContext(), musiclist2[a].music)
            binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            binding.musname.text = musiclist2[a].name
            media.start()

        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SingleMusic.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: Int) =
            SingleMusic().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }
}