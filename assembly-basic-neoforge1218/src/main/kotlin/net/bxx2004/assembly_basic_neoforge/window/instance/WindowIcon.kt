package net.bxx2004.assembly_basic_neoforge.window.instance

import com.mojang.blaze3d.platform.IconSet
import com.mojang.blaze3d.platform.MacosUtil
import com.mojang.blaze3d.platform.NativeImage
import net.bxx2004.assembly.application.InstanceTypes
import net.bxx2004.assembly.application.client.AssemblyInstance
import net.bxx2004.assembly.application.client.ClientResourceManager
import net.bxx2004.assembly.data.AssemblyIdentifier
import net.bxx2004.assembly.data.AssemblyIdentifier.Companion.resource
import net.bxx2004.assembly_basic_neoforge.TypesExtension.window
import net.bxx2004.assembly_neoforge.AssemblyResourcePack.getIoSupplier
import net.bxx2004.assembly_neoforge.NeoForgeSender
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWImage
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
/**
 * @author 6hisea
 * @date  2025/10/25 13:33
 * @description: None
 */
object WindowIcon : AssemblyInstance(
    AssemblyIdentifier(InstanceTypes.window,"icon")
) {
    var icon = "icon.png".resource()
    override fun onMounted() {
        val status = isReady()
        if (status.first){
            setIcon()
        }
    }

    override fun onUnmounted() {
        Minecraft.getInstance().window.setIcon(Minecraft.getInstance().vanillaPackResources, IconSet.RELEASE)
    }
    private fun setIcon(){
        val i = GLFW.glfwGetPlatform()
        when (i) {
            393217, 393220 -> {
                val bufferList = arrayListOf<GLFWImage.Buffer>()
                try {
                    val memorystack = MemoryStack.stackPush()
                    try {
                        val buffer = GLFWImage.malloc(1, memorystack)
                        bufferList.add(buffer)
                        val nativeimage = NativeImage.read(ClientResourceManager.findResourceAsStream(icon.path))

                        try {
                            val bytebuffer =
                                MemoryUtil.memAlloc(nativeimage.width * nativeimage.height * 4)
                            bytebuffer.asIntBuffer().put(nativeimage.pixelsABGR)
                            buffer.position(0)
                            buffer.width(nativeimage.getWidth())
                            buffer.height(nativeimage.getHeight())
                            buffer.pixels(bytebuffer)
                        } catch (var20: Throwable) {
                            if (nativeimage != null) {
                                try {
                                    nativeimage.close()
                                } catch (var19: Throwable) {
                                    var20.addSuppressed(var19)
                                }
                            }

                            throw var20
                        }

                        nativeimage.close()

                        GLFW.glfwSetWindowIcon(Minecraft.getInstance().window.window, buffer.position(0) as GLFWImage.Buffer)
                    } catch (var21: Throwable) {
                        if (memorystack != null) {
                            try {
                                memorystack.close()
                            } catch (var18: Throwable) {
                                var21.addSuppressed(var18)
                            }
                        }

                        throw var21
                    }

                    memorystack.close()
                }finally {
                    bufferList.forEach {it.close()}
                    bufferList.clear()
                }
            }

            393218 -> MacosUtil.loadIcon(ClientResourceManager.getIoSupplier(ResourceLocation.parse(icon.toString()))!!)
            else -> {

            }
        }
    }
}