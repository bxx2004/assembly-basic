package net.bxx2004.assembly_bukkit.basic.app.window

import net.bxx2004.assembly.Assembly
import net.bxx2004.assembly.application.AssemblyApplication
import net.bxx2004.assembly.application.server.ServerInstanceManager.sync
import net.bxx2004.assembly.data.AssemblyIdentifier.Companion.id
import net.bxx2004.assembly.data.Side
import net.bxx2004.assembly_bukkit.BukkitSender.Companion.asPacketSender
import org.bukkit.event.player.PlayerRegisterChannelEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

/**
 * @author 6hisea
 * @date  2025/10/19 17:53
 * @description: None
 */
//app和ins都需要在双端注册
object WindowApplication : AssemblyApplication(){


    override val side = Side.SERVER
    override val id = "application:basic-window".id()


    @Config("window-options.yml", migrate = true, autoReload = true)
    lateinit var options: Configuration
        private set


    //同步instance，也可以用来重载应用
    @SubscribeEvent
    fun playerJoinEvent(event: PlayerRegisterChannelEvent){
        if (event.channel != Assembly.CHANNEL) return
        sync(event.player.asPacketSender)
    }
}