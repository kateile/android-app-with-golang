package com.kateile.futa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kateile.futa.databinding.FragmentFirstBinding
import lib.Lib.randomString
import lib.Lib.startServer

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.genBtn.setOnClickListener {
            val str = randomString(24)
            binding.textviewFirst.text = str
        }

        binding.startBtn.setOnClickListener {
            /**
             * Is it possible to just open port and use it for opening
             * server?
             *
             * like startServer(serverPort.localPort.toString())
             */
            //val serverPort = ServerSocket(0)
            //val port =startServer(serverPort.localPort.toString())
            //Log.d("MainActivity", port)

            val str = startServer("24356")
            binding.textviewFirst.text = str
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}