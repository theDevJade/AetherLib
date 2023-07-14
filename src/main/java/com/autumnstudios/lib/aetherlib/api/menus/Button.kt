package com.autumnstudios.pyrite.api.menus

import org.bukkit.Material


data class Button(val x: Int, val y: Int, val material: Material, val name: String) {
    fun execute() {}
}
