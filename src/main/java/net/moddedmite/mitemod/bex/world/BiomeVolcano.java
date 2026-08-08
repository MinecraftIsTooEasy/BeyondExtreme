package net.moddedmite.mitemod.bex.world;

import net.minecraft.BiomeGenBase;
import net.minecraft.Block;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
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
		
		
		int temp;
		int x;
		int y;
		int z;
		WorldGenMinable genMinableWaterMoving = new WorldGenMinable(BEXBlocks.volcanoAshes.blockID, 100000, Block.waterMoving.blockID);
		WorldGenMinable genMinableWater = new WorldGenMinable(BEXBlocks.volcanoAshes.blockID, 100000, Block.waterStill.blockID);
		WorldGenMinable genMinableSand = new WorldGenMinable(BEXBlocks.volcanoSand.blockID, 100000, Block.sand.blockID);
		for (temp = 0; temp < 200000; ++temp) {
			x = par3 + par2Random.nextInt(16);
			y = par2Random.nextInt(128);
			z = par4 + par2Random.nextInt(16);
			genMinableWater.generate(par1World, par2Random, x, 62, z);
			genMinableWaterMoving.generate(par1World, par2Random, x, y, z);
			genMinableSand.generate(par1World, par2Random, x, y, z);
		}
		
		WorldGenMinable genMinableBlock = new WorldGenMinable(BEXBlocks.volcanoStone.blockID, 100, Block.stone.blockID);
		for (temp = 0; temp < 4096; ++temp) {
			x = par3 + par2Random.nextInt(16);
			y = par2Random.nextInt(128);
			z = par4 + par2Random.nextInt(16);
			genMinableBlock.generate(par1World, par2Random, x, y, z);
		}
	}
}