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

package tombenpotter.emt.common.modules.ic2.tile.solars.air;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tombenpotter.emt.common.modules.ic2.blocks.IC2BlockRegistry;
import tombenpotter.emt.common.modules.ic2.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityAirSolar extends TileEntitySolarBase {

    public TileEntityAirSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    private static final int MAX_CHARGE_TICKS = 288000;
    private int chargeTicks;

    @Override
    public void createEnergy() {
        if (theSunIsVisible && yCoord >= 140) {
            if (chargeTicks < MAX_CHARGE_TICKS) {
                chargeTicks++;
            }
            energySource.addEnergy(output * (2.5 + chargeTicks / (double) MAX_CHARGE_TICKS));
        } else if (theSunIsVisible) {
            energySource.addEnergy(output);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("AirSolarChargeTicks", chargeTicks);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        chargeTicks = nbttagcompound.getInteger("AirSolarChargeTicks");
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(IC2BlockRegistry.emtSolars, 1, 15);
    }
}
