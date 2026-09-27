/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt.common.modules.ic2.tile.solars.water;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityWaterSolar extends TileEntitySolarBase {

    public TileEntityWaterSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    @Override
    public void createEnergy() {
        if ((worldObj.isRaining() || worldObj.isThundering()) && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord)) {
            energySource.addEnergy(output * 4);
        } else if (isSurroundedByWater()) {
            energySource.addEnergy(output * 2.5);
        }
    }

    private boolean isSurroundedByWater() {
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            Block block = worldObj.getBlock(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
            if (block != Blocks.water && block != Blocks.flowing_water) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.emtSolars, 1, 3);
    }
}
