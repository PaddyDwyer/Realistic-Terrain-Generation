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

public class SurfaceDesertMountain extends SurfaceBase
{
	private boolean beach;
	private IBlockState beachBlock;
	private float min;
	
	private float sCliff = 1.5f;
	private float sHeight = 60f;
	private float sStrength = 65f;
	private float cCliff = 1.5f;
	
	public SurfaceDesertMountain(IBlockState top, IBlockState fill, boolean genBeach, IBlockState genBeachBlock, float minCliff) 
	{
		super(top, fill);
		beach = genBeach;
		beachBlock = genBeachBlock;
		min = minCliff;
	}
	
	public SurfaceDesertMountain(IBlockState top, IBlockState fill, boolean genBeach, IBlockState genBeachBlock, float minCliff, float stoneCliff, float stoneHeight, float stoneStrength, float clayCliff)
	{
		this(top, fill, genBeach, genBeachBlock, minCliff);
		
		sCliff = stoneCliff;
		sHeight = stoneHeight;
		sStrength = stoneStrength;
		cCliff = clayCliff;
	}
	
	@Override
	public void paintTerrain(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		float c = CliffCalculator.calc(x, y, noise);
		int cliff = 0;
		boolean gravel = false;

    	Block b;
		for(int k = 255; k > -1; k--)
		{
			b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;
            	
            	if(depth == 0)
            	{
            		if(k < 63)
            		{
            			if(beach)
            			{
            				gravel = true;
            			}
            		}

					float p = perlin.noise3(i / 8f, j / 8f, k / 8f) * 0.5f;
					if(c > min && c > sCliff - ((k - sHeight) / sStrength) + p)
        			{
        				cliff = 1;
        			}
            		if(c > cCliff)
        			{
        				cliff = 2;
        			}
            		
            		if(cliff == 1)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, rand.nextInt(3) == 0 ? Blocks.cobblestone.getDefaultState() : Blocks.stone.getDefaultState());
            		}
            		else if(cliff == 2)
            		{
        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(9));
            		}
            		else if(k < 63)
            		{
            			if(beach)
            			{
	            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, beachBlock);
	            			gravel = true;
            			}
            			else if(k < 62)
            			{
                			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
            			}
            			else
            			{
                			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
            			}
            		}
            		else
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, topBlock);
            		}
            	}
            	else if(depth < 6)
        		{
            		if(cliff == 1)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stone.getDefaultState());
            		}
            		else if(cliff == 2)
            		{
        				chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.stained_hardened_clay.getStateFromMeta(9));
            		}
            		else if(gravel)
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, beachBlock);
            		}
            		else
            		{
            			chunkPrimer.setBlockState((y * 16 + x) * 256 + k, fillerBlock);
            		}
        		}
            }
		}
	}
}
