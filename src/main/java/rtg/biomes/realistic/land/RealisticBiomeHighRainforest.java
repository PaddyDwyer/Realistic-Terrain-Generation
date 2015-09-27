package rtg.biomes.realistic.land;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.api.RTGBiomes;
import rtg.biomes.realistic.RealisticBiomeBase;
import rtg.deco.trees.DecoJungleFat;
import rtg.surface.SurfaceBase;
import rtg.surface.SurfaceGrassland;
import rtg.terrain.TerrainBase;
import rtg.terrain.TerrainHighland;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;

public class RealisticBiomeHighRainforest extends RealisticBiomeBase
{
	private TerrainBase terrain;
	private SurfaceBase surface;
	
	public RealisticBiomeHighRainforest()
	{
		super(0, RTGBiomes.baseJungle);
		
		terrain = new TerrainHighland(0f, 140f, 68f, 200f);
		surface = new SurfaceGrassland(Blocks.grass.getDefaultState(), Blocks.dirt.getDefaultState(), Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState());
	}


    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
    	if(rand.nextInt((int)(1f / strength)) == 0) 
		{
			int j6 = chunkX + 8;//12 + rand.nextInt(8);
			int k10 = chunkY + 8;//12 + rand.nextInt(8);
			int z52 = world.getTopSolidOrLiquidBlock(new BlockPos(j6, 0, k10)).getY();
	
			WorldGenerator worldgenerator = new DecoJungleFat(Blocks.log, 3, Blocks.sponge, 7, 15 + rand.nextInt(15), 4 + rand.nextInt(2), 14f, 3, 0.2f, 0.25f);
			worldgenerator.generate(world, rand, new BlockPos(j6, z52, k10));
		}
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);
    }
    
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	surface.paintTerrain(chunkPrimer, i, j, x, y, depth, world, rand, perlin, cell, noise, river, base);
    }
}
