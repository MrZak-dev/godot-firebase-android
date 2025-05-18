// TODO: Update to match your plugin's package name.
package org.godotengine.plugin.android.firebase

import android.util.Log
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.database
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.UsedByGodot

class GodotAndroidPlugin(godot: Godot): GodotPlugin(godot) {

    override fun getPluginName() = BuildConfig.GODOT_PLUGIN_NAME

    /**
     * Example showing how to declare a method that's used by Godot.
     *
     * Shows a 'Hello World' toast.
     */
    @UsedByGodot
    fun initialize(){
        FirebaseApp.initializeApp(godot.getActivity()!!);
    }

    @UsedByGodot
    fun helloWorld() {
        runOnUiThread {
            Log.v(pluginName, "Hello World")
            val database = Firebase.database
            val dbRef = database.getReference("godotplugin-default-rtdb")
            dbRef.setValue("Hello, world")
        }
    }
}
