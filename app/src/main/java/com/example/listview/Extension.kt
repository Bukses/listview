package com.example.listview

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat


fun Activity.showWebView(url: String) {
    val customTabsIntent = CustomTabsIntent.Builder()
        .setCloseButtonIcon(getBitmap(this, R.drawable.ic_arrow_back))
        .addDefaultShareMenuItem()
        .setShowTitle(true)
        .setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left)
        .setExitAnimations(this, R.anim.slide_in_left, R.anim.slide_out_right)
        .build()

    customTabsIntent.launchUrl(this, Uri.parse(url))

}

private fun getPixels(ctx: Context, dp: Int) = dp * ctx.resources.displayMetrics.density + 0.5f

private fun getBitmap(ctx: Context, @DrawableRes id: Int): Bitmap {
    var drawable = ContextCompat.getDrawable(ctx, id)
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        drawable = DrawableCompat.wrap(drawable!!).mutate()
    }

    val bitmap = Bitmap.createBitmap(
        drawable?.intrinsicWidth ?: 0,
        drawable?.intrinsicHeight ?: 0, Bitmap.Config.ARGB_8888
    )

    val canvas = Canvas(bitmap)
    drawable?.setBounds(0, 0, canvas.width, canvas.height)
    drawable?.draw(canvas)

    return bitmap
}