package com.dicoding.dotaheroesbase.ui.bookmark

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.dotaheroesbase.R
import com.dicoding.dotaheroesbase.core.ui.HeroAdapter
import com.dicoding.dotaheroesbase.databinding.FragmentBookmarkBinding
import com.dicoding.dotaheroesbase.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookmarkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        val root: View = binding.root
        (activity as AppCompatActivity).supportActionBar?.hide()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val heroAdapter = HeroAdapter()
            heroAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.bookmark.observe(viewLifecycleOwner) { data ->
                heroAdapter.setData(data)

                with(binding) {
                    searchView.setupWithSearchBar(searchBar)
                    searchView.editText.setOnEditorActionListener { _, _, _ ->
                        val searchText = searchView.text.toString()
                        searchBar.setText(searchText)
                        searchView.hide()

                        val filteredList = data.filter {
                            it.localizedName?.contains(searchText, true) ?: true
                        }
                        if (filteredList.isEmpty()) {
                            viewError.root.visibility = View.VISIBLE
                            viewError.tvError.text = getString(R.string.no_data_found)
                        } else {
                            viewError.root.visibility = View.GONE
                        }
                        heroAdapter.setData(filteredList)

                        true
                    }
                }

                binding.viewError.root.visibility =
                    if (data.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvHero) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = heroAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}