package rtg.world.gen.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.world.biome.realistic.RealisticBiomeBase;

public class SurfaceBase 
{
	protected IBlockState topBlock;
	protected IBlockState fillerBlock;
	
	public SurfaceBase(IBlockState top, IBlockState fill)
	{
		topBlock = top;
		fillerBlock = fill;
	}
	
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
	}
}
