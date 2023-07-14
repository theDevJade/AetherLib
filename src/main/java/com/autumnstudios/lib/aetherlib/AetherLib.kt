package com.autumnstudios.lib.aetherlib


import com.autumnstudios.plugins.mercury.startup.StartupManager
import com.autumnstudios.pyrite.api.effects.PermPotionManager
import com.autumnstudios.pyrite.api.schedulers.GlobalSchedulersData
import org.bukkit.plugin.java.JavaPlugin
import org.checkerframework.checker.nullness.qual.NonNull
import org.checkerframework.framework.qual.DefaultQualifier

@DefaultQualifier(NonNull::class)
class AetherLib : JavaPlugin() {

  companion object {
    lateinit var instance: AetherLib;

    fun getAetherLib() : AetherLib {
      return instance
    }

    fun getGlobalScheduler() : GlobalSchedulersData {
      return instance.globalSchedulersData
    }

    fun getPermPotionsManager() : PermPotionManager {
      return instance.permPotionsManager
    }
  }


  lateinit var globalSchedulersData: GlobalSchedulersData;
  lateinit var permPotionsManager: PermPotionManager



  private fun importantRegister() {
    // Registering variables, and instance
    instance = this;

  }
  override fun onEnable() {
    importantRegister()
    logger.info("Starting up Aether (Library)")

    StartupManager()

  }
  override fun onDisable() {

  }




}
