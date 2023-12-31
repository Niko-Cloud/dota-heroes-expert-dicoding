package com.dicoding.dotaheroesbase.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.dotaheroesbase.R
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.databinding.ActivityDetailBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val data = intent.getParcelableExtra<Hero>(EXTRA_DATA)
        if (data != null) {
            showDetail(data)
        }

        for (tag in data?.roles!!) {
            val chip = Chip(this@DetailActivity)
            chip.text = tag
            binding.chipGroup.addView(chip)
        }

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun showDetail(detailHero: Hero) {
        detailHero.let {
            binding.tvName.text = detailHero.localizedName

            binding.statsLayout.apply {
                tvPrimaryAttribute.text =
                    getString(R.string.primary_attribute, detailHero.primaryAttr)
                tvMoveSpeed.text = getString(R.string.move_speed, detailHero.moveSpeed.toString())
                tvBaseHealth.text =
                    getString(R.string.base_health, detailHero.baseHealth.toString())
                tvBaseMana.text = getString(R.string.base_mana, detailHero.baseMana.toString())
                tvBaseArmor.text = getString(R.string.base_armor, detailHero.baseArmor.toString())
                tvBaseAttackMin.text =
                    getString(R.string.base_attack_min, detailHero.baseAttackMin.toString())
                tvBaseAttackMax.text =
                    getString(R.string.base_attack_max, detailHero.baseAttackMax.toString())
                tvBaseStr.text = getString(R.string.base_str, detailHero.baseStr.toString())
                tvBaseAgi.text = getString(R.string.base_agi, detailHero.baseAgi.toString())
                tvBaseInt.text = getString(R.string.base_int, detailHero.baseInt.toString())
                tvStrGain.text = getString(R.string.str_gain, detailHero.strGain.toString())
                tvAgiGain.text = getString(R.string.agi_gain, detailHero.agiGain.toString())
                tvIntGain.text = getString(R.string.int_gain, detailHero.intGain.toString())
                tvAttackRange.text =
                    getString(R.string.attack_range, detailHero.attackRange.toString())
                tvAttackRate.text =
                    getString(R.string.attack_rate, detailHero.attackRate.toString())
                tvAttackType.text = getString(R.string.attack_type, detailHero.attackType)
                tvAttackPoint.text =
                    getString(R.string.attack_point, detailHero.attackPoint.toString())
                tvProjectileSpeed.text =
                    getString(R.string.projectile_speed, detailHero.projectileSpeed.toString())
                tvDayVision.text = getString(R.string.day_vision, detailHero.dayVision.toString())
                tvNightVision.text =
                    getString(R.string.night_vision, detailHero.nightVision.toString())
                tvBaseHealthRegen.text =
                    getString(R.string.base_hp_regen, detailHero.baseHealthRegen.toString())
                tvBaseManaRegen.text =
                    getString(R.string.base_mana_regen, detailHero.baseManaRegen.toString())
                tvBaseMagic.text = getString(R.string.base_magic_res, detailHero.baseMr.toString())
                tvBaseAttackTime.text =
                    getString(R.string.base_attack_time, detailHero.baseAttackTime.toString())
            }
            Glide.with(this@DetailActivity)
                .load("https://api.opendota.com${detailHero.icon}")
                .into(
                    binding.ivIcon
                )
            Glide.with(this@DetailActivity)
                .load("https://api.opendota.com${detailHero.img}")
                .into(binding.ivImage)

            var statusFavorite = detailHero.isBookmark
            setStatusFavorite(statusFavorite)
            binding.ivBookmark.setOnClickListener {
                statusFavorite = !statusFavorite
                viewModel.setFavoriteTourism(detailHero, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.bookmark_button_filled
                )
            )
        } else {
            binding.ivBookmark.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.bookmark_button_outline
                )
            )
        }
    }
}