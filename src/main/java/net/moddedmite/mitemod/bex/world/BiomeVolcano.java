package net.moddedmite.mitemod.bex.world;

import net.minecraft.BiomeGenBase;
import net.minecraft.Block;
import net.minecraft.World;
import net.moddedmite.mitemod.bex.register.BEXBlocks;

import java.awt.*;
import java.util.Random;

public class BiomeVolcano extends BiomeGenBase {
	
	public BiomeVolcano(int par1) {
		super(par1);
		this.minHeight = 0.7F;
		this.maxHeight = 3.0F;
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.topBlock = (byte)Block.sand.blockID;
		this.fillerBlock = (byte)Block.sand.blockID;
		this.theBiomeDecorator.sandPerChunk = -99;
		this.theBiomeDecorator.sandPerChunk2 = -99;
		this.theBiomeDecorator.deadBushPerChunk = 3;
		this.theBiomeDecorator.treesPerChunk = -99;
		this.theBiomeDecorator.flowersPerChunk = -99;
		this.theBiomeDecorator.clayPerChunk = -99;
		this.theBiomeDecorator.bigMushroomsPerChunk = -999;
		this.canSpawnLightningBolt(true);
		this.setColor(new Color(202, 36, 26).getRGB());
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
		
		int tempore;
		for (tempore = 0; tempore < 6 + par2Random.nextInt(3); ++tempore) {
			int k = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int blockId = par1World.getBlockId(k, var8, var9);
			if (blockId == Block.stone.blockID) {
				par1World.setBlock(k, var8, var9, BEXBlocks.volcanoEmeraldOre.blockID, 0, 2);
			}
		}
		
		for (tempore = 0; tempore < 4 + par2Random.nextInt(3); ++tempore) {
			int k = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int blockId = par1World.getBlockId(k, var8, var9);
			if (blockId == Block.stone.blockID) {
				par1World.setBlock(k, var8, var9, BEXBlocks.volcanoDiamondOre.blockID, 0, 2);
			}
		}
		
		for(tempore = 0; tempore < 4 + par2Random.nextInt(3); ++tempore) {
			int k = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int blockId = par1World.getBlockId(k, var8, var9);
			if (blockId == Block.stone.blockID) {
				par1World.setBlock(k, var8, var9, BEXBlocks.volcanoMithrilOre.blockID, 0, 2);
			}
		}
		
		
		for (int dx = 0; dx < 16; ++dx) {
			for (int dz = 0; dz < 16; ++dz) {
				for (int dy = 0; dy < 128; ++dy) {
					int x = par3 + dx;
					int z = par4 + dz;
					int blockId = par1World.getBlockId(x, dy, z);
					if (blockId == Block.waterMoving.blockID || blockId == Block.waterStill.blockID) {
						par1World.setBlock(x, dy, z, BEXBlocks.volcanoAshes.blockID, 0, 2);
					} else if (blockId == Block.sand.blockID) {
						par1World.setBlock(x, dy, z, BEXBlocks.volcanoSand.blockID, 0, 2);
					} else if (blockId == Block.stone.blockID) {
						par1World.setBlock(x, dy, z, BEXBlocks.volcanoStone.blockID, 0, 2);
					}
				}
			}
		}
	}
}