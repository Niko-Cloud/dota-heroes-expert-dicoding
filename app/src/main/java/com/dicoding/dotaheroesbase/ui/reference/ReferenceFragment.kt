package com.dicoding.dotaheroesbase.ui.reference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dicoding.dotaheroesbase.databinding.FragmentReferenceBinding

class ReferenceFragment : Fragment() {

    private var _binding: FragmentReferenceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ReferenceViewModel::class.java)

        _binding = FragmentReferenceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        (activity as AppCompatActivity).supportActionBar?.hide()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}