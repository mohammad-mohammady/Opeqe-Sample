package mohammad.mohammadi.opeqesample.util

import android.content.Context
import android.content.res.AssetManager
import mohammad.mohammadi.opeqesample.util.Constants.Companion.LOG_TAG
import java.io.IOException
import android.R.string
import okio.BufferedSource
import okio.Okio
import java.nio.charset.Charset


fun logMe(message: String)
{
    if(Statics.debugging)
        android.util.Log.d(LOG_TAG,message)
}

infix fun Any?.ifNotNull(block: () -> Unit) {
    if (this != null) block()
}

