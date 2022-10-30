package com.adgif.timofiytestapp.base.extension

import android.content.res.Resources
import android.util.TypedValue

fun dpToPx(dp: Int) =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        Resources.getSystem().displayMetrics
    )