package rtg.surface.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.surface.SurfaceBase;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.PerlinNoise;

public class SurfaceVanillaMesa extends SurfaceBase
{
	private int[] claycolor = new int[100];
	
	public SurfaceVanillaMesa(IBlockState top, IBlockState fill)
	{
		super(top, fill);
		
		int[] c = new int[]{1, 8, 0};
		PerlinNoise perlin = new PerlinNoise(2L);
		
		float n;
		for(int i = 0; i < 100; i++)
		{
			n = perlin.noise1(i / 3f) * 3f + perlin.noise1(i / 1f) * 0.3f + 1.5f;
			n = n >= 3f ? 2.9f : n < 0f ? 0f : n;
			claycolor[i] = c[(int)n];
		}
	}
	
	public byte getClayColorForHeight(int k)
	{
		k -= 60;
		k = k < 0 ? 0 : k > 99 ? 99 : k;
		return (byte)claycolor[k];
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
	        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(getClayColorForHeight(k)));
	            	}
	            	else
	            	{
	        			if(depth > 4)
	        			{
		        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(getClayColorForHeight(k)));
	        			}
	        			else if(k > 77)
	        			{
	        				if(rand.nextInt(5) == 0)
	        				{
		        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
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
	        			else if(k < 69)
	        			{
	        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
	        			}
	        			else if(k < 78)
	        			{
	        				if(depth == 0)
	        				{
	        					if(k < 72 && rand.nextInt(k - 69 + 1) == 0)
	        					{
			        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
	        					}
		        				else if(rand.nextInt(5) == 0)
		        				{
			        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
		        				}
		        				else
		        				{
			        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
		        				}
	        				}
	        				else
	        				{
		        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
	        				}
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
        			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(getClayColorForHeight(k)));
        		}
            }
		}
	}
}
