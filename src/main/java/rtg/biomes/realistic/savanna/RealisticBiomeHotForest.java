package rtg.biomes.realistic.savanna;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.GeneratorBushFeature;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.deco.DecoBlob;
import rtg.deco.DecoFlowers;
import rtg.deco.DecoGrass;
import rtg.deco.DecoLog;
import rtg.deco.DecoWaterGrass;
import rtg.deco.trees.DecoBirch;
import rtg.deco.trees.DecoShrub;
import rtg.deco.trees.DecoSmallPine;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceGrasslandMixBig;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainGrasslandFlats;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeHotForest extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;
	
	public RealisticBiomeHotForest() 
	{
		super(0, RTGBiomes.baseHotForest, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT));
		
		terrain = new TerrainGrasslandFlats();
		surface = new SurfaceGrasslandMixBig(Blocks.sand, Blocks.sand, Blocks.grass, Blocks.dirt, Blocks.stone, Blocks.cobblestone, 60f, -0.14f, 14f, 0.25f);
	}
	
	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
        if(rand.nextInt((int)(15f / strength)) == 0)
		{
			int i2 = chunkX + rand.nextInt(16) + 8;
			int i8 = chunkY + rand.nextInt(16) + 8;
			int l4 = world.getTopSolidOrLiquidBlock(new BlockPos(i2, 0, i8)).getY();
			if(l4 > 63)
			{
				(new WorldGenLakes(Blocks.water)).generate(world, rand, new BlockPos(i2, l4, i8));
			}
		}
        
		//boulders
		for (int l = 0; l < 3f * strength; ++l)
		{
			int i1 = chunkX + rand.nextInt(16) + 8;
			int j1 = chunkY + rand.nextInt(16) + 8;
		    int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
			if(k1 < 95 && (k1 < 64 || rand.nextInt(7) == 0))
			{
		    	(new DecoBlob(Blocks.cobblestone, 0)).generate(world, rand, i1, k1, j1);
			}
		}
		
		//trees
		float l = perlin.noise2((chunkX + 16f) / 60f, (chunkY + 16f) / 60f) * 6f + 0.2f;
		for (int b1 = 0; b1 < l * 4f * strength; b1++)
		{
			int j6 = chunkX + rand.nextInt(16) + 8;
			int k10 = chunkY + rand.nextInt(16) + 8;
			int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();

			WorldGenerator worldgenerator = rand.nextInt(6) == 0 ? new WorldGenTrees(false) : rand.nextInt(12) == 0 ? new DecoBirch(4 + rand.nextInt(5), 6 + rand.nextInt(5)) : rand.nextInt(6) == 0 ? new DecoSmallPine(3 + rand.nextInt(2), 3 + rand.nextInt(3), 0) : new DecoSmallPine(6 + rand.nextInt(5), 3 + rand.nextInt(6), 0);
			worldgenerator.setScale(1.0D, 1.0D, 1.0D);
			worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
		}
		
		if(l < 0.5f)
		{
			for(int l14 = 0; l14 < (l + 2f) * 4f * strength; l14++)
			{
				int l19 = chunkX + rand.nextInt(16) + 8;
				int k22 = 64 + rand.nextInt(64);
				int j24 = chunkY + rand.nextInt(16) + 8;

				(new DecoWaterGrass(Blocks.tallgrass, 1, 65)).generate(world, rand, l19, k22, j24);
			}
		}
		
    	if(l > 0f && rand.nextInt(6) == 0)
    	{
			int x22 = chunkX + rand.nextInt(16) + 8;
			int z22 = chunkY + rand.nextInt(16) + 8;
			int y22 = world.getTopSolidOrLiquidBlock(new BlockPos(x22, 0, z22)).getY();
			(new DecoLog(0, 3 + rand.nextInt(4), false)).generate(world, rand, x22, y22, z22);	
    	}
		
    	for(int b = 0; b < 2f * strength; b++)
    	{
			int i1 = chunkX + rand.nextInt(16) + 8;
			int j1 = chunkY + rand.nextInt(16) + 8;
		    int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();
		    if(rand.nextInt(10) == 0)
		    {
    		    (new DecoShrub(rand.nextInt(5) + 4, rand.nextInt(2), 0)).generate(world, rand, i1, k1, j1);
		    }
		    else
		    {
		    	(new DecoShrub(rand.nextInt(4) + 1, rand.nextInt(2), 0)).generate(world, rand, i1, k1, j1);
		    }
    	}

		if(rand.nextInt((int)(3f / strength)) == 0)
		{
			int k15 = chunkX + rand.nextInt(16) + 8;
			int k17 = rand.nextInt(64) + 64;
			int k20 = chunkY + rand.nextInt(16) + 8;
			
			if(rand.nextBoolean())
			{
				(new GeneratorBushFeature(Blocks.brown_mushroom)).generate(world, rand, new BlockPos(k15, k17, k20));
			}
			else
			{
				(new GeneratorBushFeature(Blocks.red_mushroom)).generate(world, rand, new BlockPos(k15, k17, k20));
			}
		}
		
		if(rand.nextInt((int)(20f / strength)) == 0)
		{
			int j16 = chunkX + rand.nextInt(16) + 8;
			int j18 = rand.nextInt(128);
			int j21 = chunkY + rand.nextInt(16) + 8;
			(new WorldGenPumpkin()).generate(world, rand, new BlockPos(j16, j18, j21));
		}
		
		for(int f23 = 0; f23 < 4f * strength; f23++)
		{
			int j15 = chunkX + rand.nextInt(16) + 8;
			int j17 = rand.nextInt(128);
			int j20 = chunkY + rand.nextInt(16) + 8;
			(new DecoFlowers(new int[]{9,9,9,9,3,3,3,3,3,2,2,2,11,11,11})).generate(world, rand, j15, j17, j20);
		}

		for(int l14 = 0; l14 < 10f * strength; l14++)
		{
			int l19 = chunkX + rand.nextInt(16) + 8;
			int k22 = rand.nextInt(128);
			int j24 = chunkY + rand.nextInt(16) + 8;
			(new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, l19, k22, j24);
		}
    }

	@Override
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
		return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }

	@Override
    public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(blocks, metadata, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
