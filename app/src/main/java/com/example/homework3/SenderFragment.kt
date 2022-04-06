package com.example.homework3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class SenderFragment : Fragment() {
    private val message: String = "Hello from Sender"
    private val messageViewModel: MessageViewModel by viewModels()
    private lateinit var button: Button
    private lateinit var addButton: Button
    private lateinit var addBackStackButton: Button
    private lateinit var replaceButton: Button
    private lateinit var replaceBackStackButton: Button

    override fun onAttach(context: Context) {
        Log.i("LifecycleCallbacks", "SenderFragment: onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleCallbacks", "SenderFragment: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("LifecycleCallbacks", "SenderFragment: onCreateView")
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("LifecycleCallbacks", "SenderFragment: onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        findView(view)
        setOnButtonClickListeners()
    }

    private fun findView(view: View) {
        button = view.findViewById(R.id.button_sender)
        addButton = view.findViewById(R.id.add_button)
        addBackStackButton = view.findViewById(R.id.add_backstack_button)
        replaceButton = view.findViewById(R.id.replace_button)
        replaceBackStackButton = view.findViewById(R.id.replace_backstack_button)
    }

    private fun setOnButtonClickListeners() {
        sendMessage()
        val receiverFragment = ReceiverFragment.newInstance(message)
        button.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, receiverFragment)
                .addToBackStack(null)
                .commit()
        }

        addButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, receiverFragment)
                .commit()
        }

        addBackStackButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, receiverFragment)
                .addToBackStack(null)
                .commit()
        }

        replaceButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, receiverFragment)
                .commit()
        }

        replaceBackStackButton.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, receiverFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun sendMessage() {
        messageViewModel.setMessage("Hello from sender")
    }

    override fun onStart() {
        Log.i("LifecycleCallbacks", "SenderFragment: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("LifecycleCallbacks", "SenderFragment: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("LifecycleCallbacks", "SenderFragment: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("LifecycleCallbacks", "SenderFragment: onStop")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.i("LifecycleCallbacks", "SenderFragment: onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        Log.i("LifecycleCallbacks", "SenderFragment: onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i("LifecycleCallbacks", "SenderFragment: onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.i("LifecycleCallbacks", "SenderFragment: onDetach")
        super.onDetach()
    }
}