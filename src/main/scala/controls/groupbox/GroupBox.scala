package com.okayestprogrammer.controls

import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.property.ReadOnlyStringProperty
import javafx.scene.Node
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.scene.layout.Region
import javafx.scene.control.Skinnable
import javafx.beans.property.ObjectProperty
import javafx.scene.control.Skin
import javafx.scene.control.Skin

class GroupBox extends Region with Skinnable{


  private val mTitle: String = ""
  private val mTitleProperty: SimpleStringProperty  = new SimpleStringProperty(mTitle)
  def setTitle(value: String): Unit = mTitleProperty.setValue(value)
  def getTitle: String = mTitleProperty.getValueSafe()
  def titleProperty: ReadOnlyStringProperty = mTitleProperty

  private val mContent: Node = null
  private val mContentProperty: SimpleObjectProperty[Node] = new SimpleObjectProperty[Node](mContent)
  def setContent(value: Node): Unit = mContentProperty.setValue(value)
  def getContent: Node = mContentProperty.getValue()
  def contentProperty: ReadOnlyObjectProperty[Node] = mContentProperty

  private val mSkin: Skin[_ <: Object] = null
  private val mSkinProperty = new SimpleObjectProperty[Skin[_ <: Object]](mSkin)
  override def skinProperty(): ObjectProperty[Skin[_ <: Object]] = mSkinProperty

  override def setSkin(value: Skin[_ <: Object]): Unit = mSkinProperty.setValue(value)

  override def getSkin(): Skin[_ <: Object] = mSkinProperty.getValue()
}
