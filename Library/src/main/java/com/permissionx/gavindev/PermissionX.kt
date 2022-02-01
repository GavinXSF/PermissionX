package com.permissionx.gavindev

import androidx.fragment.app.FragmentActivity

object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permissions: String,
                callback: PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(TAG) as InvisibleFragment?
            ?: InvisibleFragment().apply {
                fragmentManager.beginTransaction().add(this, TAG).commitNow()
            }
        fragment.requestNow(callback, *permissions)
    }
}