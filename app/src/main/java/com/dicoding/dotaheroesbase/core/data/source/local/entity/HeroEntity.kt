package com.dicoding.dotaheroesbase.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dicoding.dotaheroesbase.core.utils.TypeConverter

@Entity(tableName = "hero")
data class HeroEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo("primary_attr")
    val primaryAttr: String? = null,

    @ColumnInfo(name = "is_bookmark")
    var isBookmark: Boolean = false,

    @ColumnInfo("attack_range")
    val attackRange: Int? = null,

    @ColumnInfo("attack_type")
    val attackType: String? = null,

    @ColumnInfo("base_health")
    val baseHealth: Int? = null,

    @ColumnInfo("str_gain")
    val strGain: Float? = null,

    @ColumnInfo("night_vision")
    val nightVision: Int? = null,

    @ColumnInfo("attack_rate")
    val attackRate: Float? = null,

    @ColumnInfo("base_str")
    val baseStr: Int? = null,

    @ColumnInfo("agi_gain")
    val agiGain: Float? = null,

    @ColumnInfo("attack_point")
    val attackPoint: Float? = null,

    @ColumnInfo("projectile_speed")
    val projectileSpeed: Int? = null,

    @ColumnInfo("day_vision")
    val dayVision: Int? = null,

    @ColumnInfo("img")
    val img: String? = null,

    @TypeConverters(TypeConverter::class)
    @ColumnInfo("roles")
    val roles: List<String?>? = null,

    @ColumnInfo("icon")
    val icon: String? = null,

    @ColumnInfo("base_mana")
    val baseMana: Int? = null,

    @ColumnInfo("localized_name")
    val localizedName: String? = null,

    @ColumnInfo("base_armor")
    val baseArmor: Int? = null,

    @ColumnInfo("base_mana_regen")
    val baseManaRegen: Int? = null,

    @ColumnInfo("base_attack_max")
    val baseAttackMax: Int? = null,

    @ColumnInfo("base_int")
    val baseInt: Int? = null,

    @ColumnInfo("int_gain")
    val intGain: Float? = null,

    @ColumnInfo("move_speed")
    val moveSpeed: Int? = null,

    @ColumnInfo("turn_rate")
    val turnRate: Float? = null,

    @ColumnInfo("base_attack_min")
    val baseAttackMin: Int? = null,

    @ColumnInfo("base_attack_time")
    val baseAttackTime: Int? = null,

    @ColumnInfo("base_agi")
    val baseAgi: Int? = null,

    @ColumnInfo("base_health_regen")
    val baseHealthRegen: Float? = null,

    @ColumnInfo("base_mr")
    val baseMr: Int? = null
)
