package com.kkagurazaka.experimental.asyncpermissions

import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.experimental.suspendCancellableCoroutine

class AsyncPermissions(activity: AppCompatActivity) {

    private val asyncPermissionsFragment: AsyncPermissionsFragment =
            AsyncPermissionsFragment.attach(activity)

    suspend fun request(permission: String, vararg others: String): PermissionResult =
            suspendCancellableCoroutine { cont ->
                try {
                    asyncPermissionsFragment.request(permission, *others, cont = cont)
                } catch(ex: Exception){
                    cont.resumeWithException(ex)
                }
            }
}
