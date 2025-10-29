package net.bxx2004.assembly_basic_neoforge

import net.bxx2004.assembly.Assembly
import net.bxx2004.assembly.AssemblyRegister.Companion.registerClientInstance
import net.bxx2004.assembly_basic_neoforge.window.WindowApplication
import net.bxx2004.assembly_basic_neoforge.window.instance.WindowIcon
import net.bxx2004.assembly_basic_neoforge.window.instance.WindowTitle
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

/**
 * Main mod class.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(AssemblyBasicNeoforge.ID)
@EventBusSubscriber
object AssemblyBasicNeoforge {
    const val ID = "assembly_basic_neoforge1218"
    val LOGGER: Logger = LogManager.getLogger(ID)


    @SubscribeEvent
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Assembly basic neoforge...")
        Assembly.register {
            application(WindowApplication)
                .registerClientInstance(WindowTitle::class.java)
                .registerClientInstance(WindowIcon::class.java)

        }
    }
}
