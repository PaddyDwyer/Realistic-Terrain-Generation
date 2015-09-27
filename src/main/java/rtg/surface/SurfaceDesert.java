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

public class SurfaceDesert extends SurfaceBase
{
	private IBlockState cliffBlock1;
	private IBlockState cliffBlock2;
	private IBlockState bottomBlock;
	
	public SurfaceDesert(IBlockState top, IBlockState filler, IBlockState bottom, IBlockState cliff1, IBlockState cliff2)
	{
		super(top, filler);
		
		bottomBlock = bottom; 
		cliffBlock1 = cliff1;
		cliffBlock2 = cliff2;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		boolean cliff = c > 2.8f ? true : false;

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
            		if(depth > -1 && depth < 2)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(3) == 0 ? cliffBlock2 : cliffBlock1);
            		}
            		else if (depth < 10)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, cliffBlock1);
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
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, bottomBlock);
	        		}
            	}
            }
		}
	}
}
