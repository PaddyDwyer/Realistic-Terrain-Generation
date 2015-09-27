package rtg.surface;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;

public class SurfaceGrassCanyon extends SurfaceBase
{
	private IBlockState hardenedClayBlock;
	
	public SurfaceGrassCanyon(IBlockState top, IBlockState fill, IBlockState clay)
	{
		super(top, fill);
		this.hardenedClayBlock = clay;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		boolean cliff = c > 1.3f ? true : false;
		
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

        		if(depth > -1 && depth < 12)
	        	{
	            	if(cliff)
	            	{
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, hardenedClayBlock);
	            	}
	            	else
	            	{
	        			if(depth > 4)
	        			{
		        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, hardenedClayBlock);
	        			}
	        			else
	        			{
	        				if(depth == 0)
	        				{
		        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
	        				}
	        				else
	        				{
		        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
	        				}
	        			}
	            	}
        		}
        		else if(k > 63)
        		{
        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, hardenedClayBlock);
        		}
            }
		}
	}
}
