package com.example.jcp.siriusxmtest.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jcp.siriusxmtest.data.entities.Item
import com.example.jcp.siriusxmtest.ui.card.CardAdapter

/**
 * Created by jacp on 5/23/2018.
 */
object BindingUtils {
    @JvmStatic
    @BindingAdapter("adapter")
    fun addCards(recyclerView: RecyclerView, cards: List<Item>) {
        val adapter = recyclerView.adapter as CardAdapter?
        adapter?.updateItems(cards)
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.context
        Glide.with(context).load(url)
                .apply(RequestOptions.overrideOf(300, 300))
                .apply(RequestOptions.fitCenterTransform())
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("actions")
    fun actions(linearLayout: LinearLayout, content: List<String>) {
        // TODO: Optimize with ViewHolder
        val context = linearLayout.context
        linearLayout.removeAllViews()
        content.forEach {
            val tv = TextView(context)
            tv.setText(it)
            linearLayout.addView(tv)
        }
    }

    @JvmStatic
    @BindingAdapter("emptyVisibility")
    fun emptyVisibility(textView: TextView, string: List<String>) {
        textView.movementMethod = LinkMovementMethod.getInstance()
        when {
            string.isEmpty() -> textView.visibility = View.GONE
            else -> textView.visibility = View.VISIBLE
        }
    }
}