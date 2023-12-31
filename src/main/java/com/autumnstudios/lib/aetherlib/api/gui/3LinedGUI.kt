package com.autumnstudios.pyrite.api.gui

import com.autumnstudios.pyrite.api.utils.ColorUtil
import com.autumnstudios.pyrite.api.utils.ItemUtils
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class `3LinedGUI`(name: String) {



  private val iutils: ItemUtils;

  private val name: String;

  lateinit var row1: String
  lateinit var row2: String
  lateinit var row3: String

  val charDefinations: MutableMap<Char, ItemStack> = HashMap<Char, ItemStack>()


  init {

    this.iutils = ItemUtils
    this.name = name;

    initializeFeatures()

  }

  private fun initializeFeatures() {
    row1 = "_________"
    row2 = "_________"
    row3 = "_________"

    charDefinations.put(' ', ItemStack(Material.AIR))
    charDefinations.put('_', iutils.quickItem(Material.GRAY_STAINED_GLASS_PANE, "&e"))
  }

  fun defineRow(row: Int, data: String) {
    if (data.length == 9) {
      when (row) {
        1 -> {
          row1 = data
        }
        2 -> {
          row2 = data
        }
        3 -> {
          row3 = data
        }
      }
    }


  }

  fun defineChar(chr: Char, stack: ItemStack) {
    charDefinations[chr] = stack
  }

  fun buildInventory() : Inventory {
    val inv: Inventory = Bukkit.createInventory(null, (3 * 9), ColorUtil.colorize(name))


    val firstRow: MutableList<Char> = row1.toMutableList()
    val secondRow: MutableList<Char> = row2.toMutableList()
    val thirdRow: MutableList<Char> = row3.toMutableList()

    Bukkit.broadcast(ColorUtil.getTextComponent(firstRow.toString()))
    var index = 0

    for (chr: Char in firstRow) {
      Bukkit.broadcast(ColorUtil.getTextComponent(chr.toString()))
      if (charDefinations.contains(chr)) {
        inv.setItem(index, charDefinations[chr])
        Bukkit.broadcast(ColorUtil.getTextComponent(firstRow.indexOf(chr).toString()))
      } else {
        inv.setItem(index, charDefinations[' '])
      }
      index++
    }
    index = 0
    for (chr: Char in secondRow) {
      if (charDefinations.contains(chr)) {
        inv.setItem(index + 9, charDefinations[chr])
      } else {
        inv.setItem(index + 9, charDefinations[' '])
      }
      index++
    }
    index = 0
    for (chr: Char in thirdRow) {
      if (charDefinations.contains(chr)) {
        inv.setItem(index + 18, charDefinations[chr])
      } else {
        inv.setItem(index + 18, charDefinations[' '])
      }
      index++
    }





    return inv;
  }


}
