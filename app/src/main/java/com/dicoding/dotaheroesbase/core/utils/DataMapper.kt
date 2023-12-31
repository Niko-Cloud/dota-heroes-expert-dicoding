package com.dicoding.dotaheroesbase.core.utils

import com.dicoding.dotaheroesbase.core.data.source.local.entity.HeroEntity
import com.dicoding.dotaheroesbase.core.data.source.remote.response.HeroResponseItem
import com.dicoding.dotaheroesbase.core.domain.model.Hero

object DataMapper {
    fun mapResponsesToEntities(input: List<HeroResponseItem>):List<HeroEntity>{
        val heroList = ArrayList<HeroEntity>()
        input.map {
            val hero = HeroEntity(
                id = it.id,
                primaryAttr = it.primaryAttr,
                isBookmark = false,
                attackRange = it.attackRange,
                attackType = it.attackType,
                baseHealth = it.baseHealth,
                strGain = it.strGain,
                nightVision = it.nightVision,
                attackRate = it.attackRate,
                baseStr = it.baseStr,
                agiGain = it.agiGain,
                attackPoint = it.attackPoint,
                projectileSpeed = it.projectileSpeed,
                dayVision = it.dayVision,
                img = it.img,
                roles = it.roles,
                icon = it.icon,
                baseMana = it.baseMana,
                localizedName = it.localizedName,
                baseArmor = it.baseArmor,
                baseManaRegen = it.baseManaRegen,
                baseAttackMax = it.baseAttackMax,
                baseInt = it.baseInt,
                intGain = it.intGain,
                moveSpeed = it.moveSpeed,
                baseAttackMin = it.baseAttackMin,
                baseAttackTime = it.baseAttackTime,
                baseAgi = it.baseAgi,
                baseHealthRegen = it.baseHealthRegen,
                baseMr = it.baseMr,
            )
            heroList.add(hero)
        }
        return heroList
    }

    fun mapEntitiesToDomain(input: List<HeroEntity>): List<Hero> =
        input.map {
            Hero(
                id = it.id,
                primaryAttr = it.primaryAttr,
                isBookmark = it.isBookmark,
                attackRange = it.attackRange,
                attackType = it.attackType,
                baseHealth = it.baseHealth,
                strGain = it.strGain,
                nightVision = it.nightVision,
                attackRate = it.attackRate,
                baseStr = it.baseStr,
                agiGain = it.agiGain,
                attackPoint = it.attackPoint,
                projectileSpeed = it.projectileSpeed,
                dayVision = it.dayVision,
                img = it.img,
                roles = it.roles,
                icon = it.icon,
                baseMana = it.baseMana,
                localizedName = it.localizedName,
                baseArmor = it.baseArmor,
                baseManaRegen = it.baseManaRegen,
                baseAttackMax = it.baseAttackMax,
                baseInt = it.baseInt,
                intGain = it.intGain,
                moveSpeed = it.moveSpeed,
                baseAttackMin = it.baseAttackMin,
                baseAttackTime = it.baseAttackTime,
                baseAgi = it.baseAgi,
                baseHealthRegen = it.baseHealthRegen,
                baseMr = it.baseMr,
            )
        }

    fun mapDomainToEntity(input: Hero) = HeroEntity(
        id = input.id,
        primaryAttr = input.primaryAttr,
        isBookmark = input.isBookmark,
        attackRange = input.attackRange,
        attackType = input.attackType,
        baseHealth = input.baseHealth,
        strGain = input.strGain,
        nightVision = input.nightVision,
        attackRate = input.attackRate,
        baseStr = input.baseStr,
        agiGain = input.agiGain,
        attackPoint = input.attackPoint,
        projectileSpeed = input.projectileSpeed,
        dayVision = input.dayVision,
        img = input.img,
        roles = input.roles,
        icon = input.icon,
        baseMana = input.baseMana,
        localizedName = input.localizedName,
        baseArmor = input.baseArmor,
        baseManaRegen = input.baseManaRegen,
        baseAttackMax = input.baseAttackMax,
        baseInt = input.baseInt,
        intGain = input.intGain,
        moveSpeed = input.moveSpeed,
        baseAttackMin = input.baseAttackMin,
        baseAttackTime = input.baseAttackTime,
        baseAgi = input.baseAgi,
        baseHealthRegen = input.baseHealthRegen,
        baseMr = input.baseMr,
    )
}