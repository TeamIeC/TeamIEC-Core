package iec.core.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class IECTESR<T extends TileEntity> extends TileEntitySpecialRenderer<T> {

    private float partialTicks;
    private int destroyStage;
    private T tile;

    @Override
    public void renderTileEntityAt(T te, double x, double y, double z, float partialTicks, int destroyStage) {
        this.partialTicks = partialTicks;
        this.destroyStage = destroyStage;
        renderTile(te, x, y, z);
    }

    protected abstract void renderTile(T tile, double x, double y, double z);

    public TileEntity getTileEntity(){
        return tile;
    }

    protected float getPartialTicks(){
        return partialTicks;
    }

    protected int getDestroyStage(){
        return destroyStage;
    }

}
