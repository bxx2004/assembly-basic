package net.bxx2004.assembly_bukkit.basic.app.window.instance

import net.bxx2004.assembly.application.InstanceTypes
import net.bxx2004.assembly.application.client.AssemblyInstance
import net.bxx2004.assembly.data.AssemblyIdentifier
import net.bxx2004.assembly_bukkit.basic.TypesExtension.window
import net.bxx2004.assembly_bukkit.basic.app.window.WindowApplication


/**
 * @author 6hisea
 * @date  2025/10/19 17:58
 * @description: None
 */
//优先级：实例模式 > 实体模式 > 数据包模式
//因为WindowTitle不涉及多个实例，单例即可
//使用前需要在app内服务端注册，客户端需要注册工厂
object WindowTitle : AssemblyInstance(
    AssemblyIdentifier(InstanceTypes.window,"title")
){
    //实例数据定义
    var titles = WindowApplication.options.getStringList("titles")
    var duration = WindowApplication.options.getLong("duration")

    override fun onMounted() {
        //服务端不会执行此函数
    }

    override fun onUnmounted() {
        //服务端不会执行此函数
    }
}