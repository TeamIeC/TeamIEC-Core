package iec.core.common.registry;

import iec.core.client.render.IECTESR;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Basicly a handler class that does nothing except 'emulating'
 * the old GameRegistry just to make things nicer.
 */
public class IECRegistry {

    /**
     * Registers a block with the given arguments.
     * @param block
     * @param name
     */
    public static void registerBlock(Block block, String name){
        ResourceLocation location = new ResourceLocation(name);

        if(block != null){
            GameRegistry.register(block, location);
        }
        else{
            throw new IllegalArgumentException("Failed to register Block ! [" + name + "] Block can't be null !");
        }
    }

    /**
     * Registers a block with the given arguments and the given ItemBlock.
     * @param block
     * @param itemBlock
     * @param name
     */
    public static void registerBlock(Block block, ItemBlock itemBlock, String name){
        ResourceLocation location = new ResourceLocation(name);

        if(block != null){
            if(itemBlock == null){
                throw new IllegalArgumentException("Failed to register ItemBlock ! [" + name + "] ItemBlock can't be null !");
            }

            GameRegistry.register(block, location);
            GameRegistry.register(itemBlock, location);
        }
        else{
            throw new IllegalArgumentException("Failed to register Block ! [" + name + "] Block can't be null !");
        }
    }

    /**
     * Registers an item with the given arguments.
     * @param item
     * @param name
     */
    public static void registerItem(Item item, String name){
        ResourceLocation location = new ResourceLocation(name);

        if(item != null){
            GameRegistry.register(item, location);
        }
        else{
            throw new IllegalArgumentException("Failed to register Item ! [" + name + "] Item can't be null !");
        }
    }

    /**
     * Registers a TileEntity with the given arguments
     * @param tile
     * @param name
     */
    public static void registerTileEntity(Class<? extends TileEntity> tile, String name){
        if(tile != null){
            GameRegistry.registerTileEntity(tile, name);
        }
        else{
            throw new IllegalArgumentException("Failed to register TileEntity ! [" + name + "] TileEntity can't be null !");
        }
    }

    /**
     * Registers a GuiHandler with the given instance.
     * @param modInstance
     * @param handler
     */
    public static void registerGuiHandler(Object modInstance, IGuiHandler handler){
        if(modInstance != null && modInstance != ""){
            if(handler == null){
                throw new IllegalArgumentException("Failed to register GuiHandler ! [" + modInstance + "] GuiHandler can't be null !");
            }
        }
        else{
            throw new IllegalArgumentException("Failed to register GuiHandler ! [" + handler.toString() + "] Mod instance can't be null or empty !");
        }
    }

    /**
     * Registers an EventHandler.
     * @param handler
     */
    public static void registerEventHandler(Object handler){
        if(handler != null && !(handler instanceof String)){
            MinecraftForge.EVENT_BUS.register(handler);
        }
        else{
            throw new IllegalArgumentException("Failed to register EventHandler ! Handler can't be null or a String !");
        }
    }

    /**
     * Registers a TESR. (TileEntity class is not needed)
     * @param tesr
     */
    @SideOnly(Side.CLIENT)
    public static void registerTESR(IECTESR tesr){
        if(tesr != null){
            if(tesr.getTileEntity() == null){
                throw new IllegalArgumentException("Failed to register TESR ! [" + tesr.toString() + "] TileEntity can't be null !");
            }

            ClientRegistry.bindTileEntitySpecialRenderer(tesr.getTileEntity().getClass(), tesr);
        }
        else{
            throw new IllegalArgumentException("Failed to register TESR ! [" + tesr.toString() + "] TESR can't be null !");
        }
    }

}
