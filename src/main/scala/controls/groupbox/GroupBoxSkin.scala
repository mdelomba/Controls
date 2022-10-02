package com.okayestprogrammer.controls

import javafx.scene.control.Skin
import javafx.scene.Node
import javafx.scene.layout.AnchorPane

class GroupBoxSkin extends Skin[GroupBox]{
  def this(value: GroupBox) = {
    this()
    skinnable = value
  }

  private var mAnchorPane = new AnchorPane

  private var skinnable: GroupBox = null

  override def getSkinnable(): GroupBox = skinnable

  override def getNode(): Node = mAnchorPane
 
  override def dispose(): Unit = {}
}
