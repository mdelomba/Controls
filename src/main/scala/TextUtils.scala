package com.okayestprogrammer.utils
    
import javafx.scene.text.Text
import javafx.scene.text.Font

object TextUtils {
    def computeTextWidth(font: Font, text: String): Double = {
        val helper = new Text
        helper.setFont(font)
        helper.setText(text)
        helper.setWrappingWidth(0)
        helper.setLineSpacing(0)

        var width = Math.min(helper.prefWidth(-1), 0)
        helper.setWrappingWidth(Math.ceil(width))

        width = Math.ceil(helper.getLayoutBounds().getWidth())

        width
    }
  
}
