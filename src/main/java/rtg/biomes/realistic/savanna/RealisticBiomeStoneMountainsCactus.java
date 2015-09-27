package rtg.biomes.realistic.savanna;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.config.ConfigRTG;
import rtg.deco.DecoBlob;
import rtg.deco.DecoCacti;
import rtg.deco.DecoFlowers;
import rtg.deco.DecoGrass;
import rtg.deco.trees.DecoSavannah;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceMountainStoneMix1;
import rtg.surface.river.SurfaceRiverOasis;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainHilly;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeStoneMountainsCactus extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;
	private SurfaceBase riverSurface;

	public RealisticBiomeStoneMountainsCactus()
	{
		super(0, RTGBiomes.baseHotPlains, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.OASIS));
		terrain = new TerrainHilly(230f, 120f, 0f);
		surface = new SurfaceMountainStoneMix1(Blocks.grass.getDefaultState(), Blocks.dirt.getDefaultState(), false, null, 0f, 1.5f, 60f, 65f, 1.5f, Blocks.stone.getDefaultState(), 0.20f);
		riverSurface = new SurfaceRiverOasis();
	}

	@Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
		if ( ConfigRTG.enableCobblestoneBoulders && DecoBlob.shouldGenerateCobblestoneBoulder() ) {
			for (int i23 = 0; i23 < 1; i23++)
			{
				int i1 = chunkX + rand.nextInt(16) + 8;
				int j1 = chunkY + rand.nextInt(16) + 8;
				int k1 = world.getTopSolidOrLiquidBlock(new BlockPos(i1, 0, j1)).getY();

				if (k1 < 80)
				{
					(new WorldGenBlockBlob(Blocks.cobblestone, 0)).generate(world, rand, new BlockPos(i1, k1, j1));
				}
			}
		}
		
		if(river > 0.7f)
		{
			if(river > 0.86f)
			{
				for(int b33 = 0; b33 < 10f * strength; b33++)
				{
					int j6 = chunkX + rand.nextInt(16) + 8;
					int k10 = chunkY + rand.nextInt(16) + 8;
					int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
					if(z52 < 100f || (z52 < 120f && rand.nextInt(10) == 0))
					{
						WorldGenerator worldgenerator = rand.nextInt(4) != 0 ? new WorldGenShrub(0, 0) : new DecoSavannah(1);
						worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
					}
				}
			}
			
			for(int k18 = 0; k18 < 12f * strength; k18++)
			{
				int k21 = chunkX + rand.nextInt(16) + 8;
				int j23 = rand.nextInt(160);
				int k24 = chunkY + rand.nextInt(16) + 8;
				if(j23 < 120f)
				{
					(new DecoCacti(false)).generate(world, rand, new BlockPos(k21, j23, k24));
				}
			}

			for(int f25 = 0; f25 < 2f * strength; f25++)
			{
				int i18 = chunkX + rand.nextInt(16) + 8;
				int i23 = chunkY + rand.nextInt(16) + 8;
				(new WorldGenReed()).generate(world, rand, new BlockPos(i18, 60 + rand.nextInt(8), i23));
			}
			
			if(rand.nextInt(28) == 0)
			{
				int j16 = chunkX + rand.nextInt(16) + 8;
				int j18 = rand.nextInt(128);
				int j21 = chunkY + rand.nextInt(16) + 8;
				(new WorldGenPumpkin()).generate(world, rand, new BlockPos(j16, j18, j21));
			}
			
			for(int f23 = 0; f23 < 3; f23++)
			{
				int j15 = chunkX + rand.nextInt(16) + 8;
				int j17 = rand.nextInt(128);
				int j20 = chunkY + rand.nextInt(16) + 8;
				(new DecoFlowers(new int[]{9,9,9,9,3,3,3,3,3,2,2,2,11,11,11})).generate(world, rand, new BlockPos(j15, j17, j20));
			}
			
			for(int l14 = 0; l14 < 15; l14++)
			{
				int l19 = chunkX + rand.nextInt(16) + 8;
				int k22 = rand.nextInt(128);
				int j24 = chunkY + rand.nextInt(16) + 8;

				if(rand.nextInt(3) == 0)
				{
					(new DecoGrass(Blocks.double_plant, 2)).generate(world, rand, new BlockPos(l19, k22, j24));
				}
				else
				{
					(new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, new BlockPos(l19, k22, j24));
				}
			}
		}
		else
		{
			int a = 6 - (int)(perlin.noise2(chunkX / 100f, chunkY / 100f) * 10);
			if(a < 1 || rand.nextInt(a) == 0)
			{
				int j6 = chunkX + rand.nextInt(16) + 8;
				int k10 = chunkY + rand.nextInt(16) + 8;
				int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
				if(z52 < 100f || (z52 < 120f && rand.nextInt(10) == 0))
				{
					WorldGenerator worldgenerator = rand.nextInt(14) != 0 ? new WorldGenShrub(0, 0) : new DecoSavannah(1);
					worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
				}
			}
	
			for(int k18 = 0; k18 < 70; k18++)
			{
				int k21 = chunkX + rand.nextInt(16) + 8;
				int j23 = 64 + rand.nextInt(64);
				int k24 = chunkY + rand.nextInt(16) + 8;
				if(j23 < 120f)
				{
					(new DecoCacti(false)).generate(world, rand, new BlockPos(k21, j23, k24));
				}
			}
			
			if(rand.nextInt((int)(3f / strength)) == 0) 
			{
				int i18 = chunkX + rand.nextInt(16) + 8;
				int i23 = chunkY + rand.nextInt(16) + 8;
				(new WorldGenReed()).generate(world, rand, new BlockPos(i18, 60 + rand.nextInt(8), i23));
			}
			
			if(rand.nextInt(28) == 0)
			{
				int j16 = chunkX + rand.nextInt(16) + 8;
				int j18 = rand.nextInt(128);
				int j21 = chunkY + rand.nextInt(16) + 8;
				(new WorldGenPumpkin()).generate(world, rand, new BlockPos(j16, j18, j21));
			}
			
			for(int f23 = 0; f23 < 3; f23++)
			{
				int j15 = chunkX + rand.nextInt(16) + 8;
				int j17 = rand.nextInt(128);
				int j20 = chunkY + rand.nextInt(16) + 8;
				(new DecoFlowers(new int[]{9,9,9,9,3,3,3,3,3,2,2,2,11,11,11})).generate(world, rand, new BlockPos(j15, j17, j20));
			}
			
			for(int l14 = 0; l14 < 15; l14++)
			{
				int l19 = chunkX + rand.nextInt(16) + 8;
				int k22 = rand.nextInt(128);
				int j24 = chunkY + rand.nextInt(16) + 8;
	
				if(rand.nextInt(3) == 0)
				{
					(new DecoGrass(Blocks.double_plant, 2)).generate(world, rand, new BlockPos(l19, k22, j24));
				}
				else
				{
					(new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, new BlockPos(l19, k22, j24));
				}
			}
		}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(chunkPrimer, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    	riverSurface.paintTerrain(chunkPrimer, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
