package net.bxx2004.assembly_bukkit.basic.app.window.instance

import net.bxx2004.assembly.application.InstanceTypes
import net.bxx2004.assembly.application.client.AssemblyInstance
import net.bxx2004.assembly.data.AssemblyIdentifier
import net.bxx2004.assembly.data.AssemblyIdentifier.Companion.resource
import net.bxx2004.assembly_bukkit.basic.TypesExtension.window
import net.bxx2004.assembly_bukkit.basic.app.window.WindowApplication

/**
 * @author 6hisea
 * @date  2025/10/25 13:33
 * @description: None
 */
object WindowIcon : AssemblyInstance(
    AssemblyIdentifier(InstanceTypes.window,"icon")
) {
    var icon = (WindowApplication.options.getString("icon")?:"icon.png").resource()
    override fun onMounted() {

    }

    override fun onUnmounted() {

    }
}