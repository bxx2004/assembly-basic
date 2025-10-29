package net.bxx2004.assembly_bukkit.basic

import net.bxx2004.assembly_bukkit.api.AssemblyCommandRegisterEvent
import org.bukkit.command.CommandSender
import taboolib.common.platform.event.SubscribeEvent

/**
 * @author 6hisea
 * @date  2025/10/26 21:29
 * @description: None
 */
object BukkitCommand {
    @SubscribeEvent
    fun e(e: AssemblyCommandRegisterEvent){
        e.register {
            literal("basic"){
                literal("info"){
                    execute<CommandSender>{ sender, context, argument ->
                        sender.sendMessage("assembly:basic| bxx2004 | version 1.0")
                    }
                }
            }
        }
    }
}