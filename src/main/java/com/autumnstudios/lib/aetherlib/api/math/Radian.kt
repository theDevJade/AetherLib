package com.autumnstudios.pyrite.api.math

class Radian(radian: Double) {

  private val radian: Double

  init {
      this.radian = radian
  }

  fun get() : Double {
    return radian
  }
}
