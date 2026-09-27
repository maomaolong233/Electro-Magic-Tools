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

package tombenpotter.emt.common.modules.ic2.tile.solars.dark;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityDarkSolar extends TileEntitySolarBase {

    public TileEntityDarkSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    @Override
    public void createEnergy() {
        if (yCoord <= 1) {
            energySource.addEnergy(output * 3 + countEmptyBlocks());
        }
    }

    private int countEmptyBlocks() {
        int emptyBlocks = 0;
        for (int x = xCoord - 6; x < xCoord + 6; x++) {
            for (int y = yCoord - 6; y < yCoord + 6; y++) {
                for (int z = zCoord - 6; z < zCoord + 6; z++) {
                    if (worldObj.isAirBlock(x, y, z)) {
                        emptyBlocks++;
                    }
                }
            }
        }
        return emptyBlocks;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.emtSolars, 1, 6);
    }
}
