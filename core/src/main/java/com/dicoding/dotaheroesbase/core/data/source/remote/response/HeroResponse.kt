package com.dicoding.dotaheroesbase.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
data class HeroResponseItem(

    @field:SerializedName("primary_attr")
    val primaryAttr: String? = null,

    @field:SerializedName("attack_range")
    val attackRange: Int? = null,

    @field:SerializedName("attack_type")
    val attackType: String? = null,

    @field:SerializedName("base_health")
    val baseHealth: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("str_gain")
    val strGain: Float? = null,

    @field:SerializedName("night_vision")
    val nightVision: Int? = null,

    @field:SerializedName("attack_rate")
    val attackRate: Float? = null,

    @field:SerializedName("base_str")
    val baseStr: Int? = null,

    @field:SerializedName("agi_gain")
    val agiGain: Float? = null,

    @field:SerializedName("attack_point")
    val attackPoint: Float? = null,

    @field:SerializedName("projectile_speed")
    val projectileSpeed: Int? = null,

    @field:SerializedName("day_vision")
    val dayVision: Int? = null,

    @field:SerializedName("img")
    val img: String? = null,

    @field:SerializedName("roles")
    val roles: List<String?>? = null,

    @field:SerializedName("icon")
    val icon: String? = null,

    @field:SerializedName("base_mana")
    val baseMana: Int? = null,

    @field:SerializedName("localized_name")
    val localizedName: String? = null,

    @field:SerializedName("base_armor")
    val baseArmor: Float? = null,

    @field:SerializedName("base_mana_regen")
    val baseManaRegen: Float? = null,

    @field:SerializedName("base_attack_max")
    val baseAttackMax: Float? = null,

    @field:SerializedName("base_int")
    val baseInt: Int? = null,

    @field:SerializedName("int_gain")
    val intGain: Float? = null,

    @field:SerializedName("move_speed")
    val moveSpeed: Int? = null,

    @field:SerializedName("base_attack_min")
    val baseAttackMin: Float? = null,

    @field:SerializedName("base_attack_time")
    val baseAttackTime: Float? = null,

    @field:SerializedName("base_agi")
    val baseAgi: Int? = null,

    @field:SerializedName("base_health_regen")
    val baseHealthRegen: Float? = null,

    @field:SerializedName("base_mr")
    val baseMr: Float? = null
)
