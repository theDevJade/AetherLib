package com.autumnstudios.pyrite.api.utils

import com.autumnstudios.pyrite.api.utils.ColorUtil
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

object ItemUtils {

  fun quickItem(material: Material, name: String, unbreakable: Boolean = false) : ItemStack {
    val stack: ItemStack = ItemStack(material)

    val meta: ItemMeta = stack.itemMeta
    meta.displayName(ColorUtil.getTextComponent(name))
    meta.isUnbreakable = unbreakable;
    stack.itemMeta = meta;

    return stack;
  }
}
