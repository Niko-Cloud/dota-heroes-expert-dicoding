package com.dicoding.dotaheroesbase.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.dotaheroesbase.R
import com.dicoding.dotaheroesbase.core.data.Resource
import com.dicoding.dotaheroesbase.core.ui.HeroAdapter
import com.dicoding.dotaheroesbase.databinding.FragmentHomeBinding
import com.dicoding.dotaheroesbase.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.hide()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val heroAdapter = HeroAdapter()
            heroAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                Log.d("HomeFragment", "selectedData: $selectedData")
                startActivity(intent)
            }

            homeViewModel.hero.observe(viewLifecycleOwner) { hero ->
                if (hero != null) {
                    when (hero) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            with(binding) {
                                searchView.setupWithSearchBar(this.searchBar)
                                searchView
                                    .editText
                                    .setOnEditorActionListener { _, _, _ ->
                                        val searchText = searchView.text.toString()
                                        searchBar.setText(searchText)
                                        searchView.hide()
                                        val filteredList = hero.data?.filter {
                                            it.localizedName?.contains(searchText, true)
                                                ?: true
                                        }
                                        if (filteredList != null) {
                                            if (filteredList.isEmpty()) {
                                                viewError.root.visibility = View.VISIBLE
                                                viewError.tvError.text =
                                                    getString(R.string.no_data_found)
                                            } else {
                                                viewError.root.visibility = View.GONE
                                            }
                                        }
                                        heroAdapter.setData(filteredList)
                                        true
                                    }
                            }

                            binding.progressBar.visibility = View.GONE
                            heroAdapter.setData(hero.data)
                        }

                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                hero.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
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
