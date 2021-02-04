package com.withplum.emojibottomsheetdialog.view.recyclerview

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

fun <T : View> RecyclerView.ViewHolder.bind(@IdRes idRes: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return unsafeLazy { itemView.findViewById<T>(idRes) as T }
}
