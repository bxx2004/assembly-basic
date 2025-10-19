package net.bxx2004.assembly_bukkit.basic

import net.bxx2004.assembly.Assembly
import net.bxx2004.assembly.AssemblyRegister.Companion.registerServerInstance
import net.bxx2004.assembly_bukkit.basic.app.window.WindowApplication
import net.bxx2004.assembly_bukkit.basic.app.window.instance.WindowTitle
import taboolib.common.platform.Plugin

object AssemblyBasicBukkit : Plugin() {
    override fun onEnable() {
        /*
            注册应用和实例，注意事项：
                1.所有经过注册的实例才能被服务端同步到客户端
                2.服务端需要使用registerServerInstance方法注册所有实例
                3.客户端需要使用registerClientInstance方法注册实例的类
                4.应用注册方法相同,可以进行远端函数调用
         */
        Assembly.register {
            application(WindowApplication)
                .registerServerInstance(WindowTitle)
        }
    }
}