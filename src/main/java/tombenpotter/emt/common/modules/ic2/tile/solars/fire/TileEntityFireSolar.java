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

package tombenpotter.emt.common.modules.ic2.tile.solars.fire;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityFireSolar extends TileEntitySolarBase {

    public TileEntityFireSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    @Override
    public void createEnergy() {
        int lavaBlocks = countLavaBlocks();
        if (lavaBlocks > 0) {
            energySource.addEnergy(output * 2.5 + lavaBlocks * 25);
        } else {
            super.createEnergy();
        }
    }

    private int countLavaBlocks() {
        int lavaBlocks = 0;
        for (int x = xCoord - 1; x <= xCoord + 1; x++) {
            for (int y = yCoord - 1; y <= yCoord + 1; y++) {
                for (int z = zCoord - 1; z <= zCoord + 1; z++) {
                    Block block = worldObj.getBlock(x, y, z);
                    if (block == Blocks.lava || block == Blocks.flowing_lava) {
                        lavaBlocks++;
                    }
                }
            }
        }
        return lavaBlocks;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.emtSolars, 1, 12);
    }
}
