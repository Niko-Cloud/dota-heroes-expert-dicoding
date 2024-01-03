package com.dicoding.dotaheroesbase.ui.important

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.dotaheroesbase.databinding.FragmentImportantBinding
import com.dicoding.dotaheroesbase.ui.webviewdocs.WebViewDocsActivity

class ImportantFragment : Fragment() {

    private var _binding: FragmentImportantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImportantBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tvApiLink.setOnClickListener {
            // Uncomment this code if you don't wanna webview for the docs
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://docs.opendota.com")
            val intent = Intent(context, WebViewDocsActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
