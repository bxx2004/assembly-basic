package net.bxx2004.assembly_basic_neoforge.window.instance

import net.bxx2004.assembly.application.InstanceTypes
import net.bxx2004.assembly.application.client.AssemblyInstance
import net.bxx2004.assembly.data.AssemblyIdentifier
import net.bxx2004.assembly_basic_neoforge.TypesExtension.window
import net.minecraft.client.Minecraft
import java.util.Timer
import java.util.TimerTask


/**
 * @author 6hisea
 * @date  2025/10/19 17:58
 * @description: None
 */

object WindowTitle : AssemblyInstance(
    AssemblyIdentifier(InstanceTypes.window,"title")
){
    //实例数据定义
    var titles = arrayListOf("我的世界")
    var duration = 1000L

    val timer = Timer()
    var task: TimerTask? = null
    override fun onMounted() {
        val window = Minecraft.getInstance().window
        if (duration == -1L){
            window.setTitle(titles.getOrNull(0) ?: "Hello Assembly")
        }else{
            task = object : TimerTask(){
                override fun run() {
                    window.setTitle(titles.random())
                }
            }
            timer.schedule(task, 0, duration)
        }
    }

    override fun onUnmounted() {
        task?.cancel()
    }
}