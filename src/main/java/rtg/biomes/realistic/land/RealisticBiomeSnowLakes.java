package rtg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.deco.DecoBlob;
import rtg.deco.DecoFlowers;
import rtg.deco.DecoGrass;
import rtg.deco.trees.DecoShrub;
import rtg.deco.trees.DecoSmallPine;
import rtg.deco.trees.DecoSmallSpruce;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceMountainSnow;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainFlatLakes;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeSnowLakes extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;

	public RealisticBiomeSnowLakes() 
	{
		super(0, RTGBiomes.baseSnowForest, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE));
		
		terrain = new TerrainFlatLakes();
		surface = new SurfaceMountainSnow(Blocks.grass, Blocks.dirt, true, Blocks.sand, 0.2f);
	}
	
	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
		if(rand.nextInt((int)(15f / strength)) == 0)
		{
			int i2 = chunkX + rand.nextInt(16) + 8;
			int i8 = chunkY + rand.nextInt(16) + 8;
			int l4 = world.getTopSolidOrLiquidBlock(new BlockPos(i2, 0, i8)).getY();
			if(l4 > 63 && l4 < 105)
			{
				(new WorldGenLakes(Blocks.water)).generate(world, rand, new BlockPos(i2, l4, i8));
			}
		}
	    
		for (int l = 0; l < 6f * strength; ++l)
		{
			int i1 = chunkX + rand.nextInt(16) + 8;
			int j1 = chunkY + rand.nextInt(16) + 8;
		    int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
			if(k1 < 95 && (k1 < 64 || rand.nextInt(15) == 0))
			{
		    	(new DecoBlob(Blocks.mossy_cobblestone, 0)).generate(world, rand, new BlockPos(i1, k1, j1));
			}
		}
		
		if(rand.nextInt((int)(25f / strength)) == 0)
		{
			int j16 = chunkX + rand.nextInt(16) + 8;
			int j18 = rand.nextInt(128);
			int j21 = chunkY + rand.nextInt(16) + 8;
			(new WorldGenPumpkin()).generate(world, rand, new BlockPos(j16, j18, j21));
		}
		
		for(int f23 = 0; f23 < 2f * strength; f23++)
		{
			int j15 = chunkX + rand.nextInt(16) + 8;
			int j17 = rand.nextInt(128);
			int j20 = chunkY + rand.nextInt(16) + 8;
			(new DecoFlowers(new int[]{9,0,3})).generate(world, rand, new BlockPos(j15, j17, j20));
		}

		for(int l14 = 0; l14 < 3f * strength; l14++)
		{
			int l19 = chunkX + rand.nextInt(16) + 8;
			int k22 = rand.nextInt(128);
			int j24 = chunkY + rand.nextInt(16) + 8;
			(new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, new BlockPos(l19, k22, j24));
		}
		
		if(rand.nextInt((int)(4f / strength)) == 0)
		{
			int j6 = chunkX + rand.nextInt(16) + 8;
			int k10 = chunkY + rand.nextInt(16) + 8;
			int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();

			if(z52 < 120)
			{
				WorldGenerator worldgenerator = rand.nextInt(3) != 0 ? new DecoSmallPine(1 + rand.nextInt(3), 3 + rand.nextInt(5), 0) : new DecoSmallSpruce(rand.nextInt(2));
				worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
			}
		}
		
		if(rand.nextInt((int)(2f / strength)) == 0)
    	{
			int i1 = chunkX + rand.nextInt(16) + 8;
			int j1 = chunkY + rand.nextInt(16) + 8;
		    int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
			if(k1 < 110)
			{
				(new DecoShrub(rand.nextInt(4) + 1, rand.nextInt(2), rand.nextInt(2))).generate(world, rand, new BlockPos(i1, k1, j1));
			}
    	}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(blocks, metadata, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
