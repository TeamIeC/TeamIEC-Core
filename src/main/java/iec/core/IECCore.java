package iec.core;

import iec.core.common.IECCCommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static iec.core.common.lib.ModPrefs.*;

@Mod(modid = MODID, name = NAME, version = VERSION, acceptedMinecraftVersions = ACC_MC, dependencies = DEPS)
public class IECCore {

    @Mod.Instance(value = MODID)
    public static IECCore instance = new IECCore();

    @SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
    public static IECCCommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
