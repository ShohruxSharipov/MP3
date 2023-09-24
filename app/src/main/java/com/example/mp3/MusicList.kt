package com.example.mp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mp3.databinding.FragmentMusicListBinding
import com.example.mp3.music.MP3

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicList.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMusicListBinding.inflate(inflater,container,false)
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

        val adapter = com.example.mp3.adapter.Adapter(musicList,object : com.example.mp3.adapter.Adapter.Click{
            override fun onClick(music: Int) {
                parentFragmentManager.beginTransaction().replace(R.id.home,SingleMusic.newInstance(music,1)).addToBackStack("home").commit()
            }
        })

        binding.recycleview.adapter = adapter
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MusicList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}