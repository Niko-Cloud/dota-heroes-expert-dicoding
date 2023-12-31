package com.dicoding.dotaheroesbase.core.domain.model

import android.os.Parcelable
import androidx.room.TypeConverters
import com.dicoding.dotaheroesbase.core.utils.TypeConverter
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val id: Int?,
    val primaryAttr: String?,
    var isBookmark: Boolean,
    val attackRange: Int?,
    val attackType: String?,
    val baseHealth: Int?,
    val strGain: Float?,
    val nightVision: Int?,
    val attackRate: Float?,
    val baseStr: Int?,
    val agiGain: Float?,
    val attackPoint: Float?,
    val projectileSpeed: Int?,
    val dayVision: Int?,
    val img: String?,
    @TypeConverters(TypeConverter::class)
    val roles: List<String?>?,
    val icon: String?,
    val baseMana: Int?,
    val localizedName: String?,
    val baseArmor: Float?,
    val baseManaRegen: Float?,
    val baseAttackMax: Float?,
    val baseInt: Int?,
    val intGain: Float?,
    val moveSpeed: Int?,
    val turnRate: Float?,
    val baseAttackMin: Float?,
    val baseAttackTime: Float?,
    val baseAgi: Int?,
    val baseHealthRegen: Float?,
    val baseMr: Float?
): Parcelable
