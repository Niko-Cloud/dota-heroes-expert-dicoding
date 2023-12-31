package com.dicoding.dotaheroesbase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.dotaheroesbase.R
import com.dicoding.dotaheroesbase.core.data.Resource
import com.dicoding.dotaheroesbase.core.ui.HeroAdapter
import com.dicoding.dotaheroesbase.databinding.FragmentHomeBinding
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val heroAdapter = HeroAdapter()
//            heroAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
//                startActivity(intent)
//            }

            homeViewModel.hero.observe(viewLifecycleOwner) { hero ->
                if (hero != null) {
                    when (hero) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
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
                layoutManager = GridLayoutManager(context,2)
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