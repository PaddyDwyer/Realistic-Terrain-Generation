package rtg.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;

public class SurfaceRedDesert extends SurfaceBase
{	
	public SurfaceRedDesert()
	{
		super(Blocks.sand.getStateFromMeta(1), Blocks.sand.getStateFromMeta(1));
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		boolean cliff = c > 1.4f ? true : false;

		for(int k = 255; k > -1; k--)
		{
			Block b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

            	if(cliff)
            	{
            		if (depth < 6)
            		{                			
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta((byte)14));
            		}
            	}
            	else if(depth < 6)
            	{
	        		if(depth == 0 && k > 61)
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
	        		}
	        		else if(depth < 4)
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
	        		}
	        		else
	        		{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.sandstone.getDefaultState());
	        		}
            	}
            }
		}
	}
}
