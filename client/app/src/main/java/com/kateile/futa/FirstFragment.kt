package com.kateile.futa

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.HandlerCompat
import androidx.fragment.app.Fragment
import com.kateile.futa.databinding.FragmentFirstBinding
import lib.Lib.randomString
import lib.Lib.startServer
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    private val threadHandler: Handler = HandlerCompat.createAsync(Looper.getMainLooper())
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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
            start {
                Log.d("FirstFragment", it.toString())
                //binding.textviewFirst.text = "Running on port $it"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /**
     * Reference
     * 1. https://developer.android.com/guide/background/threading
     */
    private fun start(
        callback: (Result<String>) -> Unit
    ) {
        executorService.execute {
            try {
                val dir = activity?.filesDir
                val path = dir!!.path
                Log.d("path: ", path)

                val port = startServer("7070", "$path/my_db.db")
                val result = Result.Success(port)
                threadHandler.post { callback(result) }
            } catch (e: Exception) {
                val errorResult = Result.Error(e)
                threadHandler.post { callback(errorResult) }
            }
        }
    }
}