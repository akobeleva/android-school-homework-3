package com.example.homework3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ReceiverFragment : Fragment() {
    private val messageViewModel: MessageViewModel by viewModels()

    private lateinit var messageView: TextView
    private lateinit var button: Button

    private val allMessageIsRead = "All message is read"

    private lateinit var message: String

    companion object {
        private const val MESSAGE = "MESSAGE"

        fun newInstance(message: String): ReceiverFragment =
            ReceiverFragment().apply {
                val bundle = Bundle()
                bundle.putString(MESSAGE, message)
                arguments = bundle
            }
    }

    override fun onAttach(context: Context) {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onCreateView")
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        subscribeToViewModel()
        findViews(view)
        if (savedInstanceState == null){
            setMessage()
        }
        setOnButtonClickListener()
    }

    private fun findViews(view: View) {
        messageView = view.findViewById(R.id.messageView)
        button = view.findViewById(R.id.button_receiver)
    }

    private fun setMessage() {
        val receivedMessage = arguments?.getString(MESSAGE)
        receivedMessage?.let { messageViewModel.setMessage(it) }
    }

    private fun setOnButtonClickListener() {
        button.setOnClickListener {
            messageViewModel.setMessage(allMessageIsRead)
        }
    }

    private fun showMessage(newMessage: String) {
        messageView.text = newMessage
    }

    private fun subscribeToViewModel() {
        messageViewModel.message.observe(viewLifecycleOwner) { value ->
            message = value
            showMessage(message)
        }
    }

    override fun onStart() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleCallbacks", "ReceiverFragment: onDetach")
        super.onDetach()
    }
}