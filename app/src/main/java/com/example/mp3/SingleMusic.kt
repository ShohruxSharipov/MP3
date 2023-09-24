package com.example.mp3

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.mp3.databinding.FragmentSingleMusicBinding
import com.example.mp3.music.MP3
import java.util.ResourceBundle.getBundle

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
        val binding = FragmentSingleMusicBinding.inflate(inflater,container,false)
        val musicList = mutableListOf<MP3>()
        musicList.add(MP3("Don't be shy",R.raw.m1))
        musicList.add(MP3("New rules",R.raw.m2))
        musicList.add(MP3("We don't talk anymo",R.raw.m3))
        musicList.add(MP3("Dancin",R.raw.m4))
//        musicList.add(MP3("Bad habits",R.raw.m5))
        musicList.add(MP3("Shape of you",R.raw.m6))
        musicList.add(MP3("One kiss",R.raw.m7))
//        musicList.add(MP3("Rockby",R.raw.m8))
        musicList.add(MP3("Solitude",R.raw.m9))
        var a = param1!!
        var media = MediaPlayer.create(requireContext(),musicList[a].music)
        binding.musname.text = musicList[a].name
        media.start()
        Log.d("TAG", "RRR : $musicList")




        binding.play.setOnClickListener {
            if (media.isPlaying){
                media.pause()
                binding.play.setBackgroundResource(R.drawable.baseline_play_circle_24)
            }else{
                media.start()
                binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            }
        }

        binding.next.setOnClickListener {
            media.stop()
            if (a < musicList.size - 1){
                a = a + 1 }
            else a = 0
            media = MediaPlayer.create(requireContext(),musicList[a].music)
            binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            binding.musname.text = musicList[a].name
            media.start()

        }

        binding.prev.setOnClickListener {
            media.stop()
            if (a > 0){
                a = a - 1 }
            else a = musicList.size-1
            media = MediaPlayer.create(requireContext(),musicList[a].music)
            binding.play.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            binding.musname.text = musicList[a].name
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