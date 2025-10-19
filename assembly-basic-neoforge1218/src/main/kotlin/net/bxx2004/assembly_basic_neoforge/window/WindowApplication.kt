package net.bxx2004.assembly_basic_neoforge.window

import net.bxx2004.assembly.application.AssemblyApplication
import net.bxx2004.assembly.data.AssemblyIdentifier.Companion.id
import net.bxx2004.assembly.data.Side



object WindowApplication : AssemblyApplication(){
    override val side = Side.SERVER
    override val id = "application:basic-window".id()
}