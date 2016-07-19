package iec.core.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class IECCCommonProxy {

    public void preInit(FMLPreInitializationEvent e){
        registerEventHandlers();
    }

    public void init(FMLInitializationEvent e){
        registerRenderers();
    }

    public void postInit(FMLPostInitializationEvent e){

    }

    public void registerRenderers(){

    }

    public void registerEventHandlers(){

    }

}
